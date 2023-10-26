/*
 * 
 * <JOIN>
 * 
 * 두 개 이상의 테이블에서 데이터를 같이 조회하고자 할 때 사용되는 구문 => SELECT문 이용
 * 조회 결과는 하나의 결과물(RESULTSET)으로 나옴
 * 
 * JOIN을 해야하는 이유?
 * 관계형 데이터베이스에서는 최소한의 데이터로 각각의 테이블에 데이터를 보관하고 있음
 * 사원정보는 사원테이블, 직급정보는 직급테이블, ... => 중복을 최소화해서 저장
 * => 즉, JOIN구문을 이용해서 여러 테이블간의 "관계"를 맺어서 같이 조회
 * => 단, JOIN을 하는 것이 아니라 테이블간에 "연결고리"에 해당하는 컬럼을 매칭시켜서 조회
 * 
 * 문법상 분류 : JOIN은 크게 "오라클 전용 구문" , "ANSI구문(미국 국립 표준 협회)"으로 나뉨
 * 
 * 			오라클 전용 구문				|				ANIS구문(오라클 + 기타 DBMS)
 * =========================================================================================
 * 		등가조인(EQUAL JOIN)							내부조인(INNER JOIN) -> JOIN USING/ON
 * =========================================================================================
 * 			포괄조인									외부조인(OUTER JOIN) -> JOIN USING										
 * 		LEFT OUTER JOIN								왼쪽 외부조인(LEFT OUTER JOIN)
 * 		RIGHT OUTER JOIN							오른쪽 외부조인(RIGHT OUTER JOIN)
 * 													전체 외부조인(FULL OUTER JOIN)
 * =========================================================================================
 * 			카테시안의 곱										교차조인(CROSS JOIN)
 * -----------------------------------------------------------------------------------------
 * 			자체조인
 * 			비등가조인
 * 		다중조인(테이블 3개 이상 조인)
 * 
 * 
 * */

-- JOIN을 사용하지 않은 예
-- 전체 사원들의 사번, 사원명, 부서코드, 부서명을 알아내고자 한다면?
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE e ;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT d ;

--> 조인을 통해서 연결고리에 해당되는 컬럼들만 제대로 매칭시키면 하나의 결과물로 조회가

/*
 * 1. 등가조인(EQUAL JOIN) / 내부조인(INNER JOIN)
 * 연결시키고자 하는 컬럼의 값이 일치하는 행들만 조인해서 조회
 * (일치하지 않는 경우 결과에서 제외)
 * => 동등비교연산자 = (일치한다는 조건을 제시함)
 * 
 * [표현법]
 * 1) 등가조인(오라클 구문)
 * 	SELECT 컬럼1, 컬럼2 ...
 * 	FROM 조인하고자 하는 테이블명 나열
 * 	WHERE 연결할 컬럼에 대한 조건을 제시(=)
 * 
 * 2) 내부조인(ANSI 구문)
 * 	SELECT 컬럼1, 컬럼2 ...
 * 	FROM 기준으로 삼을 컬럼명 1개만 제시
 * 	JOIN 조인할 테이블명 1개만 제시 ON(연결할 컬럼에 대한 조건을 제시 (=))
 * 
 * 	SELECT 컬럼1, 컬럼2 ...
 * 	FROM 기준으로 삼을 컬럼명 1개만 제시
 * 	JOIN 조인할 테이블명 1개만 제시 USING(연결할 컬럼명 1개만 제시)
 * 
 * + 만약에 연결할 컬럼명이 동일하다면 (EMPLOYEE의 JOB_CODE, JOB의 JOB_CODE) USING 구문을 제외하고
 * 명시적으로 어느 테이블로부터 온 컬럼명인지 적어줘야함(테이블 명이나 별칭을 활용)
 * 
 * 
 * */

--> 오라클 전용 구문
-- FROM절에 조회하고자 하는 테이블들을 나열( , 를 사용)
-- WHERE절에 매칭시킬 컬럼명에 대한 조건을 제시

-- 전체 사원들에 대한 사번, 사원명, 부서코드, 부서명
-- 1) 연결할 컬럼명이 다른 케이스(EMPLOYEE - "DEPT_CODE", DEPARTMENT = "DEPT_ID")
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_ID; -- DEPT_CODE & DEPT_ID가 동일하면 합쳐서 출력
--> 일치하지 않는 값은 조회결과에서 제외(NULL, D3, D4, D7 데이터는 조회되지 않는다)
--> 두 개 이상의 테이블을 조인할 때 일치하는 값이 없는 행들은 결과에서 제외가 되었음

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명까지 알아내고자 한다
-- 2) 연결할 컬럼명이 동일한 경우(EMPLOYEE - "JOB_CODE", JOB - "JOB_CODE")
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE e , JOB j 
WHERE JOB_CODE = JOB_CODE;
-- ambiguously : 애매하다 -> 조회하고자 하는 컬럼의 어떤 테이블의 컬럼인지 명시를 해야함

-- 방법 1) 테이블 명을 이용하는 방법 => 테이블명.컬럼명 ( JOB.JOB_CODE)
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

-- 방법 2) 테이블에 별칭을 붙여서 사용하는 방법(별칭.컬럼명)
SELECT EMP_ID, EMP_NAME, e.JOB_CODE, JOB_NAME
FROM EMPLOYEE e , JOB j -- 테이블 별칭에는 AS를 붙일 수 없다
WHERE e.JOB_CODE = j.JOB_CODE;

--> ANSI구문
-- FROM절에 기준 테이블을 "하나"만 기술 한 뒤
-- 그 뒤에 JOIN절에서 같이 조회하고자 하는 테이블 기술, 또한 매칭시킬 컬럼에 대한 조건도 같이 기술
-- USING, ON 구문

-- 전체 사원들에 대한 사번, 사원명, 부서코드, 부서명
-- 1) 연결할 컬럼명이 다른 케이스(EMPLOYEE - "DEPT_CODE", DEPARTMENT = "DEPT_ID")
-- 무조건 ON 구문만 사용 가능
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE e 
/* INNER */ JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID ; -- INNER 생략 가능

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명까지 알아내고자 한다
-- 2) 연결할 컬럼명이 동일한 경우(EMPLOYEE - "JOB_CODE", JOB - "JOB_CODE")
-- => ON 구문,USING 구문 가능
-- 2-1) ON 구문
SELECT EMP_ID, EMP_NAME, e.JOB_CODE, JOB_NAME
FROM EMPLOYEE e 
JOIN JOB j ON j.JOB_CODE = e.JOB_CODE ;

-- 2-2) USING 구문 : 컬럼명이 동일한 경우만 사용가능, 동일한 컬럼명을 작성하면 매칭함
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE e 
JOIN JOB USING (JOB_CODE);

-- [참고] 자연조인(NATURAL JOIN) : 등가조인 방법 중 하나(권장하지 않음)
-- => 동일한 타입과 이름을 가진 컬럼을 조인 조건으로 이용하는 방법
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE e 
NATURAL JOIN JOB;
-- 두 개의 테이블에 일치하는 컬럼이 유일하게 딱 한개만 존재(= JOB_CODE)
-- 새로운 컬럼이 추가되거나 수정되면 오류발생할 수 있음

-------------------------------------------------------------------------------

-- 1) 직급이 대리인 사원들의 정보를 조회(사번, 사원명, 월급, 직급명)

-- 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE e , JOB j 
WHERE e.JOB_CODE = j.JOB_CODE AND JOB_NAME = '대리';

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE e 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리';

-- 2) 부서가 인사관리부인 사원들의 사번, 사원명, 보너스를 조회

-- 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_ID AND DEPT_TITLE = '인사관리부';

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE e 
JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE = '인사관리부'; 


-- 3) 부서가 총무부가 아닌 사원들의 사원명, 급여, 입사일 조회(1,1)

-- 오라클 전용 구문
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_ID AND DEPT_TITLE != '총무부';

-- ANSI 구문
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE e 
JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID
WHERE DEPT_TITLE !='총무부';

-- 4) 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회

-- 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_ID AND BONUS IS NOT NULL;

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE e
JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID 
WHERE BONUS IS NOT NULL;

-- 5) 아래의 두 테이블을 참고해서 부서코드, 부서명, 지역코드, 지역명 조회
-- DEPARTMENT, LOCATION 참고

-- 오라클 전용 구문
SELECT DEPT_ID, DEPT_TITLE ,LOCAL_CODE , LOCAL_NAME
FROM DEPARTMENT d , LOCATION l 
WHERE LOCATION_ID = LOCAL_CODE;

-- ANSI 구문
SELECT DEPT_ID, DEPT_TITLE ,LOCAL_CODE , LOCAL_NAME
FROM DEPARTMENT d
JOIN LOCATION l ON LOCATION_ID = LOCAL_CODE ;


-- 등가조인 / 내부(이너) 조인 : 일치하지 않는 행들은 제외되고 조회가 됨
------------------------------------------------------------------------------
-- 전체 사원들의 사원명, 급여, 부서명
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE e 
JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID;
-- DEPT_CODE가 NULL인 사원 2명은 조회되지 않았음
-- 즉, 부서배정 받지 않은 사원들은 조회되지 않음
-- 아무도 존재하지 않는 부서인 D3, D4, D7에 대해서도 조회되지 않음

/*
 * 2. 포괄조인 / 외부조인(OUTER JOIN)
 * 
 * 테이블간의 JOIN시에 "일치하지 않는 행도"포함시켜서 조회 가능
 * 단, 반드시 LEFT/RIGHT를 지정해야함 => 기준이되는 테이블이 왼쪾이면 LEFT, 오른쪽이면 RIGHT
 * 
 * 일치하는 행 + 기준이 되는 테이블 기준으로 일치하지 않는 행도 포함시켜 조회
 * */

-- 전체 사원들의 사원명, 급여, 부서명
-- 1) LEFT OUTER JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 조인
--                      즉, 왼쪽에 기술된 데이터는 무조건 다 조회
--						(일치하는 것을 찾지 못해도 조회함)

--> ANSI구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE e 
LEFT /* OUTER */ JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID;
--> EMPLOYEE 테이블을 기준으로 조회했기 떄문에 EMPLOYEE에 존재하는 데이터 모두를 조회함

--> 오라클 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_ID(+);
-- 기준으로 삼을 테이블명의 반대 테이블에 (+)를 붙여준다



-- 2) RIGHT OUTER JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 조인
--						 즉, 오른편에 기술된 데이터는 무조건 다 조회

--> ANSI구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE e 
RIGHT JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID;

--> 오라클 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE(+) = DEPT_ID;



-- 3) FULL OUTER JOIN : 두 테이블이 가진 모든 행을 조회
-- 일치하는 행 + LEFT OUTER JOIN 기준 새롭게 추가된 행들 + RIGHT OUTER JOIN 기준 새롭게 추가된 행들

--> ANSI 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE e 
FULL OUTER JOIN DEPARTMENT d ON DEPT_ID = DEPT_CODE;

--> 오라클 전용 구문은 사용 불가능



/*
 * 3. 카테시안의 곱(CARTESIAN PRODUCT) / 교차조인(CROSS JOIN)
 * 
 * 모든 테이블의 각 행들이 서로서로 맵핑된 데이터가 조회됨(곱집합) N * M
 * 두 테이블의 행들이 모두 곱해진 행들의 조합이 출력
 * 
 * => 각각 N개, M개 행을 가진 테이블들의 카테시안 곱의 결과행은 N*M행
 * => 모든 경우의 수를 조회
 * => 방대한 데이터를 출력(과부하 위험 발생)
 * 
 * */

--> 오라클 전용 구문(카테시안의 곱)
-- 사원명, 부서명
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE e , DEPARTMENT d 
WHERE DEPT_CODE = DEPT_CODE;
-- 23 * 9 = 207행 출력(NULL값 제외)

--> ANSI 구문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE e
CROSS JOIN DEPARTMENT d ;
-- 23 * 9 = 207행 출력(NULL값 제외)


-- 카테시안 곱의 경우 : WHERE절에 기술하는 조인 조건이 잘못되었거나, 없을 경우 발생

/*
 * 4. 비등가조인(non equal join)
 * 
 * '='를 사용하지 않는 조인문 => 다른 비교연산자를 써서 조인( > < >= <= BETWEEN A AND B)
 * => 지정한 컬럼값들이 일치하는 경우가 아니라 범위에 포함되는 경우 매칭해서 조회
 * 
 * 등가조인 -> =를 통해 일치하는 경우만 조회
 * 비등가조인 => =가 아닌 다른 비교연산자들로 범위에 포함되는 경우를 조회
 * 
 * */

-- 사원명과 급여, 급여등급(SAL_LEVEL)
SELECT EMP_NAME, SALARY
FROM EMPLOYEE e ;

SELECT *
FROM SAL_GRADE sg ;

SELECT EMP_NAME, SALARY, sg.SAL_LEVEL
FROM EMPLOYEE e , SAL_GRADE sg 
--WHERE SALARY >= MIN_SAL AND SALARY <= MAX_SAL;
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-- ANSI 구문
SELECT EMP_NAME, SALARY, sg.SAL_LEVEL
FROM EMPLOYEE e 
JOIN SAL_GRADE sg (SALARY BETWEEN MIN_SAL AND MAX_SAL);

/*
 * 5. 자체 조인(SELF JOIN)
 * 같은 테이블끼리 조인한 경우
 * 즉, 자기 자신의 테이블과 다시 조인을 맺을 때
 * => 자체 조인의 경우 테이블에 반드시 별칭을 부여해야함
 * */

-- 사원의 사번, 사원명, 사수의 사번, 사수명

-- 오라클 전용 구문
SELECT e.EMP_ID, e.EMP_NAME, e.MANAGER_ID, e2.EMP_NAME
FROM EMPLOYEE e ,EMPLOYEE e2 
WHERE e.MANAGER_ID = e2.EMP_ID(+); -- LEFT OUTER JOIN

-- ANSI 구문
SELECT e.EMP_ID, e.EMP_NAME, e.MANAGER_ID, e2.EMP_NAME
FROM EMPLOYEE e 
LEFT JOIN EMPLOYEE e2 ON (e.MANAGER_ID = e2.EMP_ID);


/*
 * <다중 JOIN>
 * 3개 이상의 테이블을 조인해서 조회
 * => 조인 순서가 매우 중요
 * 
 * */

-- 사번, 사원명, 부서명, 직급명

-- 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE e , DEPARTMENT d , JOB j 
WHERE e.DEPT_CODE = d.DEPT_ID(+) AND e.JOB_CODE = j.JOB_CODE;

-- ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE e
LEFT JOIN DEPARTMENT d ON (e.DEPT_CODE = d.DEPT_ID)
JOIN JOB j ON(e.JOB_CODE = j.JOB_CODE);


--------------------------------------------------------------------------------------------------



















