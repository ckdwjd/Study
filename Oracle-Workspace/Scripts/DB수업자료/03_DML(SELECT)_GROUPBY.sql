/*
 * <GROUP BY 절>
 * 그룹을 묶어줄 기준을 제시할 수 있는 구문 => 그룹함수와 같이 쓰임
 * 해당 제시된 기준별로 그룹을 묶을 수 있음
 * 여러개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용
 * 
 * [표현법]
 * GROUP BY 묶어줄 기준이 될 컬럼
 */

-- 각 부서별로 총 급여의 합계
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE e  -- 행의 갯수를 판단할 수 없기 떄문에 에러 발생
GROUP BY DEPT_CODE; -- 부서별로 그룹을 짓겠다

-- 각 부서별 사원 수
SELECT DEPT_CODE, COUNT(*) 
FROM EMPLOYEE e
GROUP BY DEPT_CODE;

-- 각 부서별 총 급여 합을 오름차순으로 정렬해서 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE e 
GROUP BY DEPT_CODE 
ORDER BY DEPT_CODE;

-- 각 부서별 총 급여 합을 급여별로 내림차순 정렬해서 조회 -> 어느 부서의 급여가 많은지 조회
SELECT  DEPT_CODE, SUM(SALARY) -- 3.
FROM EMPLOYEE e -- 1.
GROUP BY DEPT_CODE -- 2.
ORDER BY 2 DESC; -- 4.

-- 각 직급별로 직급코드, 총 급여의 합, 사원수, 보너스를 받는 사원 수, 평균급여, 최고급여, 최소 급여
SELECT JOB_CODE 직급코드,
	SUM(SALARY) 총급여합, COUNT(*) 사원수, COUNT(BONUS) 보너스받는사원, 
	ROUND(AVG(SALARY)) 평균급여, MAX(SALARY) 최고급여, MIN(SALARY) 최소급여
FROM EMPLOYEE e 
GROUP BY JOB_CODE
ORDER BY 1;

-- 성별별 사원의 수
-- 성별 : SUBSTR(EMP_NO, 8, 1)
SELECT 
	DECODE(SUBSTR(EMP_NO,8,1), '1', 'MAN', '2', 'GIRL') "성별",
	COUNT(*) "사원수"
FROM EMPLOYEE e 
GROUP BY SUBSTR(EMP_NO, 8, 1)
ORDER BY 1 DESC;

-- 각 부서별 평균 급여가 300만원 이상인 부서들만 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE e
WHERE ROUND(AVG(SALARY)) >= 3000000
GROUP BY DEPT_CODE ; -- 오류발생(문법상 그룹함수를 WHERE절에 쓸 수 없다)

/*
 * <HAVING 절>
 * 
 * 그룹에 대한 조건을 제시하고자 할 때 사용되는 구문
 * (주로 그룹함수를 가지고 조건 제시) => GROUP BY절과 함께 쓰임(뒤에)
 * 
 * 순서는 GROUP BY 다음으로 진행
 * 
 */

SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE e
GROUP BY DEPT_CODE
HAVING ROUND(AVG(SALARY)) >= 3000000; -- 에러 발생 X

-- 각 직급별 급여 평균이 300만원 이상인 직급코드, 평균 급여, 사원수, 최소급여, 최고급여
SELECT JOB_CODE, FLOOR(AVG(SALARY)), COUNT(*), MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE e 
GROUP BY JOB_CODE 
HAVING FLOOR(AVG(SALARY)) >= 3000000;

-- 각 부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT DEPT_CODE
FROM EMPLOYEE e 
GROUP BY DEPT_CODE 
HAVING COUNT(BONUS) = 0;

-- 각 부서별 평균급여가 350만원 이하인 부서만을 조회
SELECT DEPT_CODE
FROM EMPLOYEE e 
GROUP BY DEPT_CODE 
HAVING FLOOR(AVG(SALARY)) <= 3500000; 

-------------------------------------------------------------------------------------------------

/*
 *	<ROLLUP, CUBE>
 * - 그룹별 산출결과 값의 "집계"를 계한하는 함수
 * 
 * ROLLUP(그룹기준에 해당하는 컬럼, 그룹기준에 해당하는 컬럼)
 * : 인자로 전달받은 그룹 중 가장 먼저 지정한 그룹을 기준으로 추가집계 결과를 반환
 * 
 * CUBE(그룹기준에 해당하는 컬럼, 그룹기준에 해당하는 컬럼)
 * : 인자로 전달받은 그룹들로 가능한 모든 조합별 집계를 반환
 */

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE e 
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY 1;

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE e 
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;

/*
 * <SELECT 문 구조 및 실행순서>
 * 5. SELECT 조회하고자 하는 컬럼명, *, 리터럴, 산술연산식, 함수식
 * 1. FROM 조회하고자 하는 테이블명/DUAL
 * 2. WHERE 조건식(그룹함수X)
 * 3. GROUP BY 그룹기준에 해당하는 컬럼명 / 함수식
 * 4. HAVING 그룹함수식에 대한 조건식
 * 6. ORDER BY 컬럼명/별칭/순번 [ASC/DESC] [NULLS FIRST/NULLS LAST]
 * */

------------------------------------------------------------------------------------------------

/*
 * <집합 연산자 SET OPERATOR>
 * 
 * 여러개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자
 * 
 * - UNION(합집합) : 두 쿼리문을 수행한 결과값을 더한 후 중복되는 부분은 한번만 뺴서 중복을 제거한 것
 * 
 * - UNION ALL : 두 쿼리문을 수행한 결과값을 더한 후 중복값은 제거하지 않고 그대로 둔 것 
 * 
 * - INTERSECT(교집합) : 두 쿼리문을 수행한 결과값의 중복된 부분만 가져온 것
 * 
 * - MINUS(차집합) : 선행 쿼리문 결과값에서 후행 쿼리문 결과값을 뺸 나머지 부분
 * 
 *  *주의사항* : 두 쿼리문의 결과를 합쳐서 한 개의 테이블로 보여줘야하기 때문에
 * 			  두 쿼리문의 SELECT절 부분은 같아야 함(조회할 컬럼명이 일치해야함)
 * 
 * */

-- 1. UNION (합집합) : 두 쿼리문을 수행한 결과값을 합산(중복값 제거)
-- 부서코드가 D5이거나, 급여가 300만원 초과인 사원들을 조회(사번, 사원명, 부서코드, 급여)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D5' -- 6명 조회
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE SALARY > 3000000; -- 8명 조회
-- UNION을 통해 중복값을 뺸 12행이 출력

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D5' -- 6명 조회
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE SALARY > 3000000; -- 8명 조회
-- UNION을 통해 중복값을 포함하여 14행이 출력

-- 직급코드가 J6이거나 부서코드가 D1인 사원들 조회(사번, 사원명, 부서코드, 급여)

-- OR연산자 버전
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE JOB_CODE = 'J6' OR DEPT_CODE = 'D1';

-- UNION 연산자 버전
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE JOB_CODE = 'J6'
UNION 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D1';

-- 2.UNION ALL : 여러개의 쿼리 결과를 더해서 보여주는 연산자(중복 포함)
-- 직급코드가 J6이거나 또는 부서코드가 D1인 사원 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE JOB_CODE = 'J6'
UNION ALL 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D1';

-- 3. INTERSECT : 교집합, 쿼리 결과 중 중복된 결과만을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE JOB_CODE = 'J6'
INTERSECT 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D1';

-- AND 연산자 버전
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE e 
WHERE JOB_CODE = 'J6' AND DEPT_CODE = 'D1';

-- 4. MINUS : 차집합, 선행 쿼리문의 결과에 후행 쿼리문 결과를 뺸 나머지
-- 직급코드가 J6인 사원들 중에서 부서코드가 D1 사원들을 제외한 나머지 사원들 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE e 
WHERE JOB_CODE = 'J6'
MINUS 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D1';











