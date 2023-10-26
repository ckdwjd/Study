/*
 * <SUBQUERY>
 * 
 * 하나의 주된 SQL(SELECT, CREATE, INSERT, UPDATE ...) 안에 포함된 또 하나의 SELECT문
 * 
 * 메인 SQL문을 위해서 보조 역할을 하는 SELECT문
 * 
 */*/
 
 -- 노홍철 사원과 같은 부서인 사원들
 -- 1) 노홍철 사원의 부서코드를 조회
 SELECT DEPT_CODE
 FROM EMPLOYEE e 
 WHERE EMP_NAME = '노옹철';
 
-- 2) 부서코드가 D9인 사원들 조회
SELECT EMP_NAME
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D9';

-- 위 두 단계를 합치기 => 서브쿼리
SELECT EMP_NAME
FROM EMPLOYEE e
WHERE  DEPT_CODE = (
	 SELECT DEPT_CODE
	 FROM EMPLOYEE e
	 WHERE EMP_NAME = '노옹철');
 
-- 전체 사원의 평균 급여보다 더 많은 급여를 받고있는 사원들의 사번, 이름, 직급코드 조회
SELECT EMP_ID, EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE e
WHERE SALARY > (
	SELECT AVG(SALARY)
	FROM EMPLOYEE e2);

/*
 * 서브쿼리 구분
 * 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라서 분류
 * 
 * - 단일행(단일열) 서브쿼리 : 서브쿼리를 수행한 결과값이 오로지 1개일 때(한칸의 컬럼값으로 나올 떄)
 * - 다중행(단일열) 서브쿼리 : 서브쿼리를 수행한 결과값이 여러행일 때 
 * - (단일행)다중열 서브쿼리 : 서브쿼리를 수행한 결과값이 여러행일 때
 * - (다중행)다중열 서브쿼리 : 서브쿼리를 수행한 결과값이 여러행이면서 여러 열일 때
 * 
 * => 서브쿼리를 수행한 결과가 몇행 몇열이냐에 따라서 사용가능한 연산자가 달라짐
 * */

/*
 * 1. 단일행 (단일열) 서브쿼리 (SINGLE ROW SUBQUERY)
 * 서브쿼리의 조회 결과값이 오로지 1개일 때
 * 
 * 일반 연산자 사용 가능(= != >= <= > < ...)
 * 
 * */

-- 전 직원의 평균 급여보다 더 적게 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE e
WHERE SALARY < (
	SELECT AVG(SALARY)
	FROM EMPLOYEE e2);

-- 전 직원 중 최저 급여를 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE e
WHERE SALARY = (
	SELECT MIN(SALARY)
	FROM EMPLOYEE e2);

-- 노옹철 사원의 급여보다 더 많이 받는 사원들의 사번, 이름, 부서명, 급여조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_ID(+) AND SALARY > (
	SELECT SALARY
	FROM EMPLOYEE e2
	WHERE EMP_NAME = '노옹철');

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE e
LEFT JOIN DEPARTMENT d ON DEPT_ID = DEPT_CODE
WHERE SALARY > (
	SELECT SALARY
	FROM EMPLOYEE e2
	WHERE EMP_NAME = '노옹철');

-------------------------------------------------------------------------------------
-- 부서별 급여 합이 가장 큰 부서 하나만을 조회, 부서코드, 부서명, 급여의 합
SELECT DEPT_CODE, DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE e
LEFT JOIN DEPARTMENT d ON (DEPT_ID = DEPT_CODE)
GROUP BY DEPT_CODE, DEPT_TITLE
HAVING SUM(SALARY) = (
	SELECT MAX(SUM(SALARY))
	FROM DEPARTMENT d3 
	LEFT JOIN EMPLOYEE e2 ON (DEPT_CODE = DEPT_ID)
	GROUP BY DEPT_CODE);


/*
 * 2. 다중행 서브쿼리 (MULTI ROW SUBQUERY)
 * 서브쿼리의 조회 결과 값이 여러 행일 경우
 * 
 * - IN (10, 20, 30) 서브쿼리 : 여러개의 결과값 중에서 하나라도 일치하는 것이 있으면
 * 
 * - ( > OR < ) ANY (10, 20, 30) 서브쿼리 : 여러개의 결과값 중에서 "하나"라도 클 경우
 * 							   즉, 여러개의 결과값 중에서 가장 작은 값보다 클 경우
 * 
 * - ( > OR < ) ALL : 여러개의 결과값의 모든 값보다 클 경우 혹은 작을 경우
 * 
 * */

-- 각 부서별 최고급여를 받는 사원의 이름, 직급코드, 급여 조회
-- 부서별 최고급여
SELECT MAX(SALARY)
FROM EMPLOYEE e 
GROUP BY DEPT_CODE;

-- 위의 급여를 받는 사원들 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE e 
WHERE SALARY IN (2890000,3660000,8000000,3760000,3900000,2490000,2550000);

-- 두 코드를 합치기
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE e 
WHERE SALARY IN (SELECT MAX(SALARY)
				 FROM EMPLOYEE e 
				 GROUP BY DEPT_CODE);

-------------------------------------------------------------
-- 이오리 또는 하동운 사원과 같은 직급인 사원들을 조회(사원명, 직급코드, 부서코드, 급여)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE JOB_CODE IN (
		SELECT JOB_CODE 
		FROM EMPLOYEE e2 
		WHERE EMP_NAME IN ('하동운','이오리')
		);

-- 사원 < 대리 < 과장 < 차장 < 부장
-- 대리 직급임에도 불구하고 과장 직급의 급여보다 많이 받는 사원들 조회(사번, 이름, 직급명, 급여)
-- 1) 과장 직급인 사원들의 급여를 조회
SELECT SALARY
FROM EMPLOYEE e, JOB j 
WHERE e.job_CODE = j.JOB_CODE 
	AND JOB_NAME = '과장';

SELECT SALARY
FROM EMPLOYEE e, JOB j 
WHERE e.job_CODE = j.JOB_CODE 
	AND JOB_NAME = '대리';

-- 2) 위의 급여들보다 "하나"라도 높은 급여를 받는 직원들 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE e
JOIN JOB j USING (JOB_CODE)
WHERE  SALARY >= ANY(2200000, 2500000,3760000)
	AND JOB_NAME = '대리';

-- 3) 위 내용을 하나의 쿼리문으로 합치기
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE e
JOIN JOB j USING (JOB_CODE)
WHERE  SALARY >= ANY(
		SELECT SALARY
		FROM EMPLOYEE e, JOB j 
		WHERE e.job_CODE = j.JOB_CODE 
		AND JOB_NAME = '과장')
AND JOB_NAME = '대리';

-- 과장 직급임에도 불구하고 "모든" 차장직급의 급여보다도 더 많이 받는 직원 조회(사번, 이름, 직급명, 급여)
-- ANSI 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE e
JOIN JOB j USING (JOB_CODE)
WHERE JOB_NAME = '과장' AND SALARY > ALL( SELECT SALARY
									  FROM EMPLOYEE e2 
									  JOIN JOB j2 USING (JOB_CODE)
									  WHERE JOB_NAME = '차장');


 /*
  * 3. (단일행) 다중열 서브쿼리
  * 
  * 서브쿼리 조회결과가 값은 한 행이지만, 나열된 컬럼의 갯수가 여러개일 경우
  * */
									 
-- 하이유 사원과 같은 부서코드, 같은 직급코드에 해당되는 사원들 조회(사원명, 부서코드, 직급코드, 고용일)
-- 1) 하이유 사원의 부서코드, 직급코드를 조회
SELECT DEPT_CODE, JOB_CODE -- D5, J5
FROM EMPLOYEE e 
WHERE EMP_NAME = '하이유';

-- 2) 부서코드가 D5이면서 직급코드가 J5인 사원
SELECT *
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D5' AND JOB_CODE = 'J5';

-- 3) 위 내용을 하나의 쿼리문으로 합치기
SELECT *
FROM EMPLOYEE e 
WHERE DEPT_CODE = ( SELECT DEPT_CODE -- D5, J5
					 FROM EMPLOYEE e 
					 WHERE EMP_NAME = '하이유')
AND JOB_CODE = ( SELECT JOB_CODE -- D5, J5
				 FROM EMPLOYEE e 
				 WHERE EMP_NAME = '하이유');

-- 다중열 서브쿼리
-- (비교대상컬럼1, 비교대상컬럼2, ...) = (비교할값1, 비교할값2, ...  => 서브쿼리형식으로 제시)
SELECT *
FROM EMPLOYEE e 
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE e2 WHERE EMP_NAME = '하이유');

-- 박나라 사원과 같은 직급코드, 같은 사수사번을 가진 사원들의 사번, 이름, 직급코드, 사수사번 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE e 
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID FROM EMPLOYEE e2 WHERE EMP_NAME = '박나라');



/*
 * 4. 다중행, 다중열 서브쿼리
 * 
 * 서브쿼리 조회 결과가 여러행, 여러 컬럼일 경우
 * */

-- 각 직급별 최소급여를 받는 사원들 조회(사번, 이름, 직급코드, 급여)
-- 1) 각 직급별 최소 급여
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE e 
GROUP BY JOB_CODE;

-- 2) 위의 목록들 중에서 일치하는 사원
-- 2-1) 조건 나열
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE e
WHERE (JOB_CODE, SALARY) IN (('J2', 3700000), ('J7', 1380000));

-- 3) 위 내용을 하나의 쿼리문으로 합치기
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE e
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
								FROM EMPLOYEE e 
								GROUP BY JOB_CODE);

--------------------------------------------------------------------------------------
							
-- 각 부서별 최고 급여를 받는 사원들 조회(사번, 이름, 부서코드, 급여)
-- 1) 각 부서별 최고 급여
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE e 
GROUP BY DEPT_CODE;
							
-- 2) 위 조건을 만족하는 사원들 추출(IN)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE (DEPT_CODE, SALARY) IN (('D1', 3660000), ('D9',8000000));
							
-- 3) 두 쿼리문 합치기
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE (NVL(DEPT_CODE, '없음'), SALARY) IN (
							SELECT NVL(DEPT_CODE, '없음'), MAX(SALARY)
							FROM EMPLOYEE e 
							GROUP BY DEPT_CODE);

----------------------------------------------------------------------------------------------
						
/*
 * 5. 인라인뷰(INLINE VIEW) (하나의 임시 테이블같은 느낌)
 * FROM 절에 서브쿼리를 제시하면 
 * => 서브쿼리를 실행한 결과값인 RESULT SET을 테이블을 대신해서 사용
 * 
 * */

-- 보너스 포함 연봉이 3000만원 이상인 사원들의 사번, 이름, 보너스포함 연봉, 부서코드 조회
SELECT EMP_ID, EMP_NAME, SALARY * (1 + NVL(BONUS,0)) * 12 "보너스포함연봉", DEPT_CODE
FROM EMPLOYEE e 
WHERE SALARY * (1 + NVL(BONUS,0)) * 12 >= 30000000;

-- => 인라인 뷰를 이용 : 사원명만 골라내기(보너스 포함 연봉이 3000만원 이상인 사원들의 이름)
SELECT EMP_NAME, "보너스포함연봉"
FROM (
	SELECT EMP_ID, EMP_NAME, SALARY * (1 + NVL(BONUS,0)) * 12 "보너스포함연봉", DEPT_CODE
	FROM EMPLOYEE e 
	WHERE SALARY * (1 + NVL(BONUS,0)) * 12 >= 30000000
)
WHERE DEPT_CODE IS NULL;

-- 인라인뷰를 주로 사용하는 예
-- TOP-N분석 : 데이터베이스 상에 존재하는 자료 중 최상위 N개의 자료를 보기위해 사용하는 기능

-- 전 직원 중 급여가 가장 높은 상위 5명 조회(순위, 사원명, 급여)
-- * ROWNUM : 오라클에서 제공하는 컬럼, 조회된 순서대로 1부터 순서를 부여
SELECT ROWNUM, EMP_NAME, SALARY
FROM (
	SELECT *
	FROM EMPLOYEE e 
	ORDER BY SALARY DESC
	-- ORDER BY로 정렬 후
)
WHERE ROWNUM <= 5;

-- 각 부서별 평균 급여가 높은 3개의 부서의 코드, 평균 급여 조회
-- 1) 각 부서별 평균 급여 => 높은 순서대로
SELECT ROWNUM, DEPT_CODE, "평균 급여" -- 별칭 또는 컬럼명에 ""로 감싸기
FROM (
	SELECT DEPT_CODE, ROUND(AVG(SALARY),1) "평균 급여"
	FROM EMPLOYEE e 
	GROUP BY DEPT_CODE
	ORDER BY "평균 급여" DESC
) s
-- 2) 순번 부여, 상위 3개만
-- SELECT ROWNUM " 순위", s;
WHERE ROWNUM <= 3
GROUP BY ROWNUM, DEPT_CODE, "평균 급여";


-- ROWNUM컬럼을 이용해서 순위를 매길 수 있음
-- 다만, 정렬이 되지 않은 상태에서는 순위를 매기면 의미가 없으므로 정렬을 먼저 시키고 순위를 나중에 매겨야 함
-- 우선적으로 인라인뷰로 ORDER BY를 정렬하고, 메인쿼리에서 순서를 붙인다

-- 가장 최근에 입사한 사원 5명 조회(사원명, 급여, 입사일)
-- 입사일 기준 미래 ~ 과거(내림차순) , 순번 부여 후 5명
SELECT ROWNUM, e.*
FROM (
	SELECT EMP_NAME, SALARY, HIRE_DATE
	FROM EMPLOYEE e 
	ORDER BY 3 DESC
) e
WHERE ROWNUM <= 5;


/*
 * 6. 순위 매기는 함수(WINDOW FUNCTION)
 * RANK() OVER(정렬기준)
 * DENSE_RANK() OVER(정렬기준)
 * 
 * - RANK() OVER(정렬기준) : 공동 1위가 3명이면 그 다음 순위를 4위로 설정
 * 
 * - DENSE_RANK() OVER(정렬기준) : 공동 1위가 3명이면 그 다음 순위는 2위로 설정
 * 
 * 정렬기준 : ORDER BY (정렬기준, 컬럼이름, 오름차순/내림차순), NULLS FIRST/ NULLS LAST 옵션은 기술 불가능
 * 
 * SELECT 절에서만 사용 가능
 * 
 * */

-- 사원들의 급여가 높은 순서대로 매겨서 사원명, 급여, 순위 조회 : RANK() OVER()
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE e ; -- 공동 19위 2명 다음은 21위

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE e ;-- 공동 19위 2명 다음은 20위

-- 급여기준 5위까지 출력은 불가능(범위 한정은 불가능)
SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE e 
WHERE DENSE_RANK() OVER(ORDER BY SALARY DESC) <= 5;
-- window  functions are not allowed here = 윈도우 함수를 WHERE조건절에 기술할 수 없음

--> 인라인뷰로 전환
-- 1) RANK함수로 순위를 매김(정렬까지 완료)
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE e ;

-- 2-1) 1번 결과물을 토대로 조회(5위까지))
SELECT E.*
FROM (
	SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
	FROM EMPLOYEE) E
WHERE "순위" <= 5;

SELECT R.* 
FROM EMPLOYEE R 
JOIN EMPLOYEE E ON R.EMP_ID = E.MANAGER_ID;

SELECT LEVEL,  R.* 
FROM (SELECT REPLY_NO, REPLY_CONTENT,
        TO_CHAR(CREATE_DT, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') CREATE_DT,
        BOARD_NO, MEMBER_NO, MEMBER_NICK, PROFILE_IMG, PARENT_REPLY_NO, REPLY_ST
	    FROM REPLY_S
	    JOIN MEMBER_S USING(MEMBER_NO)
	    WHERE BOARD_NO = 1555) R

-- 계층형 쿼리로 정렬 후 조건을 이용해서 조회할 행을 제어
WHERE REPLY_ST = 'N'

-- PARENT_REPLY_NO의 값이 NULL인 행이 최상위 부모
START WITH PARENT_REPLY_NO IS NULL

-- 부모 -> 자식 계층 구조
CONNECT BY PRIOR REPLY_NO = PARENT_REPLY_NO

-- 계층 구조 정렬
ORDER SIBLINGS BY REPLY_NO; 







