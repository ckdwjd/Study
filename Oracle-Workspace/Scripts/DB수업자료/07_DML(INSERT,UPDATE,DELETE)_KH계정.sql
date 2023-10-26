/*
 * * DML (DATA MANIPULATION LANGUAGE)
 * 데이터 조작 언어
 * 
 * 테이블에 새로운 데이터를 삽입(INSERT)
 * 기존의 데이터를 수정(UPDATE)
 * 삭제(DELETE)하는 구문
 * 
 * */

/*
 * 1. INSERT : 테이블에 새로운 "행"을 추가하는 구문
 * 
 * [표현법]
 * 
 * * INSERT INTO 계열
 * 
 * 1) INSERT INTO 테이블명 VALUES(값1,값2 ... );
 * -> 해당 테이블에 존재하는 "모든" 컬럼에 대해 추가하고자 하는 값을 내가 직접
 * 	  제시해서 "한 행"을 INSERT하고자 할 때 쓰는 표현법
 * 
 * 	 ** 주의사항 **
 *    컬럼의 순서, 자료형, 갯수를 맞춰서 VALUES괄호 안에 값을 나열해야함
 * 	  - 부족하게 제시하면 : NOT ENOUGH VALUE 오류
 * 	  - 더 많이 제시하면 : TOO MANY VALUES 오류 발생
 * 
 * */

INSERT INTO EMPLOYEE e 
VALUES(900, '민경민', '880218-1234567','alsrudals@naver.com',01012345678, 'D1', 'J7','S6',1800000, 0.9,200,SYSDATE,NULL,DEFAULT);

SELECT *
FROM EMPLOYEE e ;

-----------------------------------------------------------------------------------
/*
 * 2) INSERT INTO 테이블명(컬럼1,컬럼2...)
 * VALUES(값1,값2, ...)
 * => 해당 테이블에 "특정"컬럼만 선택해서 그 컬럼에 추가할 값만 제시하고자 할 떄 사용
 * 
 * - 그래도 한 행단위로 추가되기 때문에 선택안된 컬럼은 NULL값이 들어감 (단, DEFAULT설정이 되어있을 경우 그 값이 들어감)
 * 
 * 주의사항 : NOT NULL 제약조건이 걸려있는 컬럼은 반드시 선택해서 직접 값을 제시해야함
 * 		    단, DEFAULT설정이 되어있다면 선택하지 않아도 된다
 * 
 * */

INSERT INTO EMPLOYEE e (EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, SAL_LEVEL)
VALUES (901, '민경민', '123456-1234567','D1','J6','S5');

SELECT *
FROM EMPLOYEE e
WHERE EMP_ID = 901;

/*
 * 3) INSERT INTO 테이블명 (서브쿼리);
 * => VALUES()로 값을 직접 기입하는 것이 아니라
 * 	  서브쿼리로 조회한 결과값을 통쨰로 INSERT하는 구문
 * 	  즉, 여러행을 한번에 INSERT할 수 있음
 * 
 * */

-- 새로운 테이블 생성
CREATE TABLE EMP_01 (
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(30),
	DEPT_TITLE VARCHAR2(20)
);
-- 전체 사원들의 사번, 이름, 부서명을 조회한 결과를 EMP_01테이블에 추가
-- 1) 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE e 
LEFT JOIN DEPARTMENT d  ON DEPT_CODE = DEPT_ID;

-- 2) INSERT 
INSERT INTO EMP_01 (
	SELECT EMP_ID, EMP_NAME, DEPT_TITLE
	FROM EMPLOYEE e 
	LEFT JOIN DEPARTMENT d  ON DEPT_CODE = DEPT_ID
);

SELECT *
FROM EMP_01;


/*
 * * INSERT ALL 계열
 * 두 개 이상의 테이블에 각각 INSERT 할 때 사용
 * 조건 : 그 떄 사용되는 서브쿼리가 동일해야함
 * 
 * 1) INSERT ALL
 *    INTO 테이블명1 VALUES(컬럼명, 컬럼명 ... )
 *    INTO 테이블명2 VALUES(컬럼명, 컬럼명 ... )
 * 		   서브쿼리;
 * 
 * */
-- 새로운 테이블 먼저 만들기
-- 첫번째 테이블 : 급여가 300만원 이상인 사원들의 사번, 사원명, 직급명을 보관할 테이블
CREATE TABLE EMP_JOB(
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(30),
	JOB_NAME VARCHAR2(20)
);
-- 테이블명 : EMP_JOB/ EMP_ID(NUMBER), EMP_NAME(VARCHAR2(30)), JOB_NAME(VARCHAR2(20))


-- 첫번째 테이블 : 급여가 300만원 이상인 사원들의 사번, 사원명, 직급명을 보관할 테이블
CREATE TABLE EMP_DEPT(
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(30),
	DEPT_TITLE VARCHAR2(20)
);
-- 테이블명 : EMP_DEPT/ EMP_ID(NUMBER), EMP_NAME(VARCHAR2(30)), DEPT_TITLE(VARCHAR2(20))

-- 급여가 300만원 이상인 사원들의 사번, 이름, 직급명, 부서명 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE
FROM EMPLOYEE e 
JOIN JOB USING (JOB_CODE)
LEFT JOIN DEPARTMENT d  ON DEPT_CODE = DEPT_ID
WHERE SALARY >= 3000000;

-- EMP_JOB 테이블에는 급여가 300만원 이상인 사원들의 EMP_ID, EMP_NAME, JOB_NAME 삽입
-- EMP DEPT 테이블에는 급여가 300만원 이상인 사원들의 EMP_ID, EMP_NAME, DEPT_TITLE 삽입
INSERT ALL
INTO EMP_JOB VALUES (EMP_ID, EMP_NAME, JOB_NAME)
INTO EMP_DEPT VALUES (EMP_ID, EMP_NAME, DEPT_TITLE)
	 SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE
	 FROM EMPLOYEE e 
	 JOIN JOB USING (JOB_CODE)
	 LEFT JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID
	 WHERE SALARY >= 3000000;
	
SELECT *
FROM EMP_JOB;
	 
SELECT *
FROM EMP_DEPT;

-----------------------------------------------------------------------

/*
 * 2) INSERT ALL
 * 	  WHEN 조건1 THEN
 * 			INTO 테이블명1 VALUES (컬럼명, 컬럼명 ...)
 * 	  WHEN 조건2 THEN
 * 			INTO 테이블명2 VALUES (컬럼명, 컬럼명 ...)
 *    서브쿼리
 * 
 *    - 조건에 맞는 값들만 넣을것
 * 
 * */

-- 조건을 사용해서 각 테이블에 값 INSERT
-- 새로운 테스트용 테이블 생성

-- 2010년도 기준으로 이전에 입사한 사원들의 사번, 사원명, 입사일, 급여를 담는 테이블 (EMP_OLD)
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE e 
WHERE 1 = 0;

-- 2010년도 기준으로 이전에 입사한 사원들의 사번, 사원명, 입사일, 급여를 담는 테이블 (EMP_NEW)
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE e 
WHERE 1 = 0;

-- 1) 서브쿼리 부분
-- 2010년 이전, 이후
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE e 
WHERE HIRE_DATE < '2010/01/01';

SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE e 
WHERE HIRE_DATE >= '2010/01/01';

INSERT ALL
WHEN HIRE_DATE < '2010/01.01' THEN
	INTO EMP_OLD VALUES (EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2010/01.01' THEN
	INTO EMP_NEW VALUES (EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
	SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
	FROM EMPLOYEE e ;

SELECT *
FROM EMP_OLD;

SELECT *
FROM EMP_NEW;

/*
 * 2. UPDATE
 * 
 * 테이블에 기록된 기존의 데이터를 수정하는 구문
 * 
 * [표현법]
 * UPDATE 테이블명
 * SET 컬럼명 = 바꿀값,
 * 	   컬럼명 = 바꿀값,
 * 	   ... (여러개의 컬럼값을 동시에 변경 가능 이떄 AND가 아니라 ,를 사용함)
 * WHERE 조건; (WHERE절은 생략 가능, 생략 시 모든 테이블의 모든 행이 바뀌게 됨)
 * 
 * 주의사항 : WHERE절 무조건 기입
 * 
 * */

DROP TABLE DEPT_COPY;

-- 복사본 테이블 만든 후 작업
CREATE TABLE DEPT_COPY
AS SELECT *
   FROM DEPARTMENT d ;
  
SELECT *
FROM DEPT_COPY;

-- DEPT_COPY 테이블에서 D9부서의 부서명을 전략기획팀으로 수정
UPDATE DEPT_COPY 
SET DEPT_TITLE = '전략기획팀';
-- WHERE절을 기입하지 않고 실행하면
-- 전체 행의 모든 DEPT_TITLE값들이 모두 전략기획팀으로 수정됨

-- 참고) 변경사항에 대해서 되돌리는 명령어 : ROLLBACK;
ROLLBACK;

UPDATE DEPT_COPY 
SET DEPT_TITLE = '전략기획팀'
WHERE DEPT_ID = 'D9';

SELECT *
FROM DEPT_COPY;

DROP TABLE EMP_SALARY;

CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
FROM EMPLOYEE e ;

SELECT *
FROM EMP_SALARY;

-- EMP_SALARY 테이블에서 노옹철 사원의 급여를 1000만원으로 변경
UPDATE EMP_SALARY 
SET SALARY = 10000000
WHERE EMP_NAME = '노옹철';

SELECT *
FROM EMP_SALARY;

-- EMP_SALARY 테이블에서 선동일 사원의 급여를 700만원 보너스를 0.2로 변경
UPDATE EMP_SALARY 
SET SALARY = 7000000,
	BONUS = 0.2
WHERE EMP_NAME = '선동일';

-- EMP_SALARY 테이블에서 전체 사원의 급여를 기존의 급여에 20% 인상한 금액으로 변경
UPDATE EMP_SALARY 
SET SALARY = SALARY * 1.2;

SELECT *
FROM EMP_SALARY;
/*
 * UPDATE 시 서브쿼리 사용
 * 서브쿼리를 수행한 결과값으로 기존의 값으로부터 변경
 * 
 * - CREATE 서브쿼리 사용 시 : 서브쿼리 수행한 결과로 테이블을 만들겠다
 * - INSERT 서브쿼리 사용 시 : 서브쿼리 수행한 결과를 해당 테이블에 삽입하겠다
 * 
 * [표현법]
 * UPDATE 테이블명
 * SET 컬럼명 = (서브쿼리)
 * WHERE 조건;
 * 
 * */

-- EMP_SALARY 테이블에 민경민 사원의 부서코드를 선동일 사원의 부서코드로 변경
UPDATE EMP_SALARY 
SET DEPT_CODE = (
	SELECT DEPT_CODE
	FROM EMPLOYEE e 
	WHERE EMP_NAME = '선동일'
)
WHERE EMP_NAME = '민경민';

SELECT *
FROM EMP_SALARY;

-- 방명수 사원의 급여와 보너스를 유재식 사원의 급여와 보너스값으로 변경
UPDATE EMP_SALARY 
SET (SALARY, BONUS) = (
	SELECT SALARY, BONUS
	FROM EMPLOYEE e 
	WHERE EMP_NAME = '유재식'
)
WHERE EMP_NAME = '방명수';

-- 주의사항 : UPDATE 시에도 변경할 값에 대해서 해당 컬럼의 제약조건에 위배되면 안된다

-- 송종기 사원의 사번을 200
UPDATE EMPLOYEE 
SET EMP_ID = 200
WHERE EMP_NAME = '송종기';
-- unique constraint (KH.EMPLOYEE_PK) violated : PRIMARY KEY 제약조건 위배

UPDATE EMPLOYEE 
SET EMP_NAME = NULL
WHERE EMP_ID = 200;
-- ORA-01407: cannot update ("KH"."EMPLOYEE"."EMP_NAME") to NULL
-- NOT NULL 제약조건 위배

COMMIT;
-- 모든 변경사항을 확정하는 명령어

/*
 * 4. DELETE
 * 
 * 테이블에 기록된 데이터를 "행"단위로 삭제하는 구문
 * 
 * [표현법]
 * DELETE FROM 테이블명
 * WHERE 조건; -- 생략 가능. 단, 생략 시 해당 테이블의 모든 행이 삭제
 * */

DELETE FROM EMPLOYEE e ;

SELECT *
FROM EMPLOYEE e ;

ROLLBACK; -- 롤백 시 마지막 커밋시점으로 돌아감

-- EMPLOYEE 테이블에있는 민경민, 민경민2 사원 정보 지우기
DELETE FROM EMPLOYEE e 
WHERE EMP_NAME IN ('민경민','민경민2');

COMMIT;

-- DEPARTMENT테이블로부터 DEPT_ID가 D1인 부서를 삭제
DELETE FROM DEPARTMENT d 
WHERE DEPT_ID = 'D1';
-- 만약 EMPLOYEE테이블의 DEPT_CODE컬럼에서 외래키 제약조건이 있을 경우 삭제 불가능

DELETE FROM DEPARTMENT d 
WHERE DEPT_ID = 'D3'; 
-- 외래키 제약조건이 자식테이블에서 걸려있었더라도 사용하지 않았으므로 삭제 가능

ROLLBACK;

/*
 *  * TRUNCATE : 테이블의 전체 행을 다 삭제할 때 사용
 * 				 DELETE 구문보다 수행속도가 빠름
 * 				 별도의 조건을 제시 불가
 * 			 	 ROLLBACK이 불가능(신중하게 삭제해야함)
 * 
 * [표현법]
 * TRUNCATE TABLE 테이블명;
 * 
 * DELETE 구문과 비교
 * ------------------------------------------------------------------------------------------------
 * 			TRUNCATE TABLE 테이블명; 				|				DELETE FROM 테이블명;
 * ------------------------------------------------------------------------------------------------
 * 			별도의 조건 제시 불가(WHERE X)			| 				특정 조건 제시 가능(WHERE O)
 * 			수행 속도가 빠름						|				수행 속도가 느림
 * 			ROLLBACK 불가능						|				ROLLBACK 가능
 * ------------------------------------------------------------------------------------------------
 * 		 
 * */
SELECT *
FROM EMP_SALARY;

DELETE FROM EMP_SALARY es ;

ROLLBACK; -- DELETE문은 롤백 가능

TRUNCATE TABLE EMP_SALARY ;

COMMIT;





















 
 