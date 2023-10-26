/*
    DML : 데이터 조작, SELECT(DQL) , INSERT, UPDATE, DELETE
    DDL : 데이터 정의, CREATE, ALTER, DROP
    TCL : 트랜잭션 제어 COMMIT, ROLLBACK
    DCL : 권한 부여, GRANT, REVOKE
    
    
    <SELECT>
    데이터를 조회하거나 검색할 떄 사용하는 명령어
    
    - RESULT SET : SELECT 구문을 통해 조회된 데이터의 결과물을 의미
                    (조회된 행들의 집합)
    [표현법]
    SELECT 조회하고자 하는 컬럼명1, 컬럼명2, 컬렴명3,
    FROM 테이블명;
*/

-- EMPLOYEE 테이블 전체 사원들의 사원번호, 사원이름, 급여 컬럼을 조회
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;
-- 명령어, 키워드, 컬럼명, 테이블명 대소문자를 가리지 않음
-- 소문자로 해도 무방하지만 대문자로 쓰는게 관례


-- EMPLOYEE 테이블의 전체 사원들의 모든 컬럼을 조회
SELECT *
FROM EMPLOYEE;

-- EMPLOYEE에서 전체 사원들의 이름, 이메일, 휴대폰번호 조회
SELECT EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE;

----- 실습문제 -----
-- 1. JOB테이블의 모든 컬럼 조회
SELECT *
FROM JOB;

-- 2. JOB테이블의 직급명 컬럼만 조회
SELECT JOB_NAME
FROM JOB;

-- 3. DEPARTMENT 테이블의 모든 컬럼 조회
SELECT *
FROM DEPARTMENT;

-- 4. EMPLOYEE 테이블의 직원명, 이메일, 전화번호, 입사일 컬럼만 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

-- 5, EMPLOYEE 테아블의 입사일, 직원명, 급여 컬럼만 조회
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

/*
    <컬럼값을 통한 산술연선>
    조회하고자 하는 컬럼들을 나열하는 SELECT 절에 산술연산(+-/*)을 기술해서 결과를 조회할 수 있음
*/
-- EMPLOYEE테이블로부터 직원명, 월급, 연봉(== 월급*12)
SELECT EMP_NAME, SALARY, SALARY*12
FROM EMPLOYEE;

-- EMPLOYEE 테이블로부터 직원명, 월급, 보너스, 보너스가 포함된 연봉
SELECT EMP_NAME, SALARY, BONUS, (SALARY + BONUS * SALARY) * 12
FROM EMPLOYEE;
--> 산술연산 과정에서 NULL값이 존재할 경우 산술연산의 결과도 NULL이 된다.

-- DATE 타입끼리도 연산이 가능(DATE => 년,월,일,시,분,초)
-- EMPLOYEE 테이블로부터 직원명, 입사일, 근무일 수 조회(오늘날짜 - 입사일)
-- 오늘날짜 : SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE ,SYSDATE - HIRE_DATE
FROM EMPLOYEE;
-- 값이 지저분한 이유 : DATE 타입안에 포함된 시,분,초에 대한 연산까지 함꼐 수행하기 때문에
-- 결과값은 일 단위

/*
    <컬럼명에 별칭 부여하기>
    [표현법]
    컬럼명 AS 별칭, 컬렴명 AS "별칭명", 컬렴명 별칭, 컬럼명 "별칭"
    
    AS를 붙이든 안 붙이든 간에 별칭에 특수문자 띄어쓰기가 포함된 경우 무조건 ""로 묶어서 표기
    
*/
-- EMPLOYEE 테이블로부터 직원명, 월급, 연봉(== 월급 *12)
--                         급여(월), 연봉(보너스 미포함)
SELECT EMP_NAME, SALARY AS "급여(월)", SALARY*12 AS "연봉(보너스 미포함)"
FROM EMPLOYEE;

-- EMPLOYEE 테이블로부터 직원명, 입사일, 근무일수(오늘날짜 - 입사일) 조회
SELECT EMP_NAME "직원명", HIRE_DATE "입사일", (SYSDATE - HIRE_DATE) "근무일수"
FROM EMPLOYEE;

/*
    <리터럴>
    임의로 지정한 문자열('')을 SELECT절에 기술하면 실제 그 테이블에 존재하는 데이터처럼 조회가 가능하다
*/

-- EMPLOYEE 테이블로부터 사번, 사원명, 급여
SELECT EMP_ID 사번, EMP_NAME 사원명, SALARY 급여, '원' 단위
FROM EMPLOYEE;
-- SELECT절에 제시한 리터럴 값이 조회 결과인 RESULT SET의 모든 행에 반복적으로 출력된다

/*
    <DISTINCT>
    조회하고자 하는 컬럼에 중복된 값을 딱 한번만 조회하고자 할 떄 사용
    컬럼명 앞에 기술
    [표현법]
    DISTINCT 컬럼명
*/

-- EMPLOYEE 테이블에서 부서코드들만 조회
SELECT DISTINCT
DEPT_CODE
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 직급코드들만 조회
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- DEPT_CODE, JOB_CODE를 세트로 묶어서 중복된 값인지 판별
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;

--------------------------------------------------------------------------------

/*
    <WHERE 절>
    조회하고자 하는 테이블에 조건을 제시해서
    그 조건을 만족하는 데이터들만 조회하고자 할 때 기술
    
    [표현법]
    SELECT 컬럼명, 컬럼명, ...
    FROM 테이블명
    WHERE 조건식;
    => 조건에 만족하는 행들을 추출
    
    실행순서
    FROM -> WHERE -> SELECT
    
    - 조건식에 다양한 연산자들 사용 가능
    <비교 연산자>
    >, <, >=, <=
    = (일치하는가? : 자바, JS는 ==)
    !=, ^=, <> (일치하지 않는가?)
*/

-- EMPLOYEE 테이블로부터 급여가 400만원 이상인 사원들만 조회(모든컬럼)
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE테이블로 부터 부서코드가 D9인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE 테이블로 부터 부서코드가 D9이 아닌 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE != 'D9';
-- WHERE DEPT_CODE ^= 'D9';
WHERE DEPT_CODE <> 'D9';

--------------------------------------------------------------------------------

-- 1. EMPLOYEE 테이블에서 급여가 300만원 이상인 사원들의 이름, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. EMPLOYEE 테이블에서 직급코드가 J2인 사원들의 이름, 급여, 보너스 조회
SELECT EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE JOB_CODE = 'J2';

-- 3. EMPLOYEE 테이블에서 현재 재직중인 사원들의 사번, 이름, 입사일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- 4. EMPLOYEE 테이블에서 연봉이 5000만원 이상인 사원들의 이름, 급여, 연봉, 입사일 조회
SELECT EMP_NAME, SALARY, SALARY*12, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY*12 >= 50000000;
--> SELECT절에서 부여한 별칭을 WHERE절에서 사용할 수 없음


/*
    <논리연산자>
    여러 개의 조건을 엮을 때 사용
    AND(JAVA = &&), OR(JAVA = ||)
    AND : ~이면서, 그리고 
    OR : ~이거나, 또는
*/

-- EMPLOYEE 테이블에서 부서 코드가 D9 이면서 급여가 500만원 이상인 사원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY >= 5000000;

-- 부서코드가 D6이거나 급여가 300만원 이상인 사원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY >= 3000000;


-- 급여가 350만원 이상이고 600만원 이하인 사원들위 이름, 사번, 급여, 직급코드 조회
SELECT EMP_NAME, EMP_ID, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

/*
    <BETWEEN A AND B>
    몇 이상 몇 이하의 범위에 대한 조건을 제시할 때 사용
    [표현법]
    비교대상 컬럼명 BETWEEN 하한값 AND 상한값
*/
-- 급여가 350만원 이상이고 600만원 이하인 사원들위 이름, 사번, 급여, 직급코드 조회
SELECT EMP_NAME, EMP_ID, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- 급여가 350만원 미만이고 600만원 초과인 사원들의 이름, 사번, 급여, 직급코드 조회
SELECT EMP_NAME, EMP_ID, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
--> 오라클의 NOT은 자바의 논리 부정연산자와 동일한 의미를 가짐, 위치는 컬럼명 앞, 뒤 상관없음

-- ** BETWEEN AND 연산자는 DATE형식간의 범위에도 사용 가능
-- 입사일이 '90/01/01' ~ '03/01/01'인 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
-- WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '03/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '03/01/01';

-- 입사일이 '90/01/01' ~ '03/01/01'가 아닌 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE NOT HIRE_DATE BETWEEN '90/01/01' AND '03/01/01';

/*
    <LIKE '특정패턴'>
    비교하고자 하는 컬럼 값이 내가 지정한 특정 패턴에 만족될 경우 조회
    
    [표현법]
    비교대상컬럼 LIKE '특정패턴'
    
    - 옵션 : 특정패턴 부분에 와일드카드인 '%', '_'를 가지고 제시할 수 있음
    
    '%' : 0글자 이상
          비교대상 컬럼명 LIKE '문자%' => 컬럼값 중에 '문자'로 시작하는 것을 조회
          비교대상 컬럼명 LIKE '%문자' => 컬럼값 중에 '문자'로 끝나는 것을 조회
          비교대상 컬럼명 LIKE '%문자%' => 컬럼값 중에 '문자'가 포함괴는 것 조회
          
    '_' : 1글자
          비교대상 컬럼명 LIKE '_문자' => 컬럼값 중에 '문자'앞에 무조건 1글자가 존재하는 경우만 조회
          비교대상 컬럼명 LIKE '__문자' => 컬럼값 중에 '문자'앞에 무조건 2글자가 존재하는 경우만 조회
*/

-- 성이 전씨인 사원들의 이름, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전_%';

-- 이름 중에 '하'가 포함된 사원들의 이름, 주민번호, 부서코드 조회
SELECT EMP_NAME, EMP_NO, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- 전화번호 4번쨰 자리가 9로 시작하는 사원들의 사번, 사원명, 전화번호, 이메일 조회
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- 이름 가운데 글자가 '지'인 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_지_';

--------------------------------------------------------------------------------

-- 1. 이름이 '연'으로 끝나는 사원들의 이름, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- 2. 전화번호가 010이 아닌 사원들의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

-- 3. DEPARTMENT테이블에서 해외영업과 관련된 부서들의 모든 컬럼을 조회
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';

/*
    <IS NULL>
    해당 값이 NULL인지 비교
    
    [표현법]
    비교대상 컬럼 IS NULL : 컬럼 값이 NULL인 경우 
    비교대상 컬럼 IS NOT NULL : 컬럼 값이 NULL이 아는 경우
*/

-- 보너스를 받지 않는 사원들의 사번, 이름, 급여, 보너스
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- 보너스를 받는 사원들의 사번, 이름, 급여, 보너스
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 사수가 없는 사원들의 사원명, 사수사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 사수도 없고 부서배치도 아직 받지 않은 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 부서 배치는 받지 않았지만 보너스는 받는 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

/*
    <IN>
    비교 대상 컬럼값에 제시한 목록들 중에 일치하는 값이 있는지 판단
    
    [표현법]
    비교대상컬럼 IN (값1,값2,값3,값4, ...)
*/
-- 부서코드가 D6이거나 또는 D8이거나 D5인 사원들의 이름, 부서코드, 급여를 조회
SELECT EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D5' OR DEPT_CODE = 'D8';
WHERE DEPT_CODE IN ('D6','D5','D8');

-- 직급코드가 J1이거나 J3이거나 J4인 사원들을 제외한 모든 사원들의 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE NOT JOB_CODE IN ('J1','J3','J4');

/*
    <연결 연산자 ||>
    여려 컬럼 값들을 마치 하나의 컬럼인것 처럼 연결시켜주는 연산자 
    컬럼과 리터럴(임이의 문자열)을 연결할 수 있음
*/
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- xx번 xxx의 월급은 xxx원 입니다. AS 급여정보
SELECT
EMP_ID || '번 ' || EMP_NAME || '의 월급은 ' || SALARY || '원 입니다.' AS 급여정보
FROM EMPLOYEE;

/*
    <연산자 우선순위>
    0. ()
    1. 산술연산자
    2. 연결연산자
    3. 비교연산자
    4. IS NULL, LIKE, IN
    5. BETWEEN AND
    6. NOT
    7. 논리연산자 (AND)
    8. 논리연산자 (OR)
*/

/*
    <ORDER BY 절>
    SELECT문 가장 마지막에 기입하는 구문일 뿐만 아니라 실제로도 가장 마지막에 실행되는 구문
    최종 조회된 결과물들에 대해서 정렬 기준을 세어주는 구문
    
    [표현법]
    SELECT 조회할 컬럼1,2,3 ...
    FROM 조회할 테이블명
    WHERE 조건식(생략가능)
    ORDER BY [정렬기준으로 세우고자하는 컬럼명/별칭/컬럼 순번] [ASC/DESC](생략가능) [NULLS FIRST/NULLS LAST](생략가능)
    
    오름차순 / 내림차순
    - ASC : 오름차순(생략 시 기본값)
    - DESC : 내림차순
    
    정렬하고자 하는 컬럼 값에 NULL이 있을 경우
    - NULLS FIRST : NULL값들을 앞으로 배치(내림차순의 기본값)
    - NULLS LAST : NULL값들을 뒤쪽으로 배치(오름차순의 기본값)
    
*/

-- 월급이 높은 사람부터 나열하고자 한다면(내림차순)
SELECT *
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 보너스 기준 정렬
SELECT *
FROM EMPLOYEE
-- ORDER BY BONUS; -- ASC(오름차순) & NULLS LAST : 기본값
-- ORDER BY BONUS ASC NULLS FIRST;
ORDER BY BONUS DESC, SALARY;

-- 연봉 기준 오름차순 정렬하기
SELECT EMP_NAME, SALARY, SALARY*12 "연봉"
FROM EMPLOYEE
-- ORDER BY "연봉" ASC;
-- ORDER BY 3 ASC;
ORDER BY (SALARY * 12) ASC;
-- ORDER BY는 숫자 뿐만 아니라 문자열, 날짜에 대해서도 정렬가능

-- 
