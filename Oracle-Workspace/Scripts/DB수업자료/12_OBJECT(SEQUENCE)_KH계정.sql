/*
 * <시퀀스 SEQUENCE>
 * 
 * 자동으로 번호를 발생시켜주는 역할을 하는 객체(자동번호 부여)
 * 정수값을 자동으로 순차적으로 발생
 * 
 * EX) 주차번호, 회원번호, 사번, 게시글번호 등
 * => 순차적으로 겹치지 않는 숫자로 채번을 할 때 사용할 예정
 *
 * 1. 시퀀스 객체 생성 구문
 * 
 * [표현법]
 * CREATE SEQUENCE 시퀀스명
 * START WITH 시작 숫자 => 생략 가능, 처음 발생시킬 시작값(기본값 = 1)
 * INCREMENT BY 증가값 => 생략 가능, 시퀀스 증가할 때마다 몇 씩 증가값 결정(기본값 1씩 증가)
 * MAXVALUE 최대값 => 생략가능, 최대값 지정
 * MINVALUE 최소값 => 생략가능, 최소값 지정
 * CYCLE/NOCYCLE => 생략가능, 값의 순환여부를 결정
 * CACHE 바이트크기/NOCACHE => 생략가능, 캐시메모리 여부 지정(기본값 = 20BYTE)
 * 
 * 	* 캐시메모리
 * 	시퀀스로부터 미리 발생될 값들을 생성해서 저장해두는 공간
 *	매번 호출할 때마다 새로이 번호를 생성하는 것 보다 캐시메모리 공간에 미리 생성된 값들을 가져다 쓰면 속도가 빠름
 *	(단, 접속이 끊기고 나서 재접속 후 기존에 생성되어있던 값들은 날라가고 없음)
 *  
 * */

CREATE SEQUENCE SEQ_TEST;

-- 현재 접속된 계정이 소유하고 있는 시퀀스에 대한 정보 조회용 데이터 딕셔너리
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
 * 2. 시퀀스 사용 구문
 * 
 * 시퀀스명.CURRVAL : 현재 시퀀스의 값(마지막으로 성공적으로 발생된 NEXTVAL의 값)
 * 시퀀스명.NEXTVAL : 현재 시퀀스의 값을 증가시키고, 그 증가된 시퀀스의 값
 * 					= 시퀀명.CURRVAL + INCREMENT BY 값만큼 증가된 값
 *  
 * 단, 시퀀스 생성 후 첫번째 NEXTVAL은 START WITH으로 지정된 시작값으로 발생된다
 * 	  시퀀스 생성 후 NEXTVAL이 호출되지 않은 시점에서 CURRVAL은 수행이 불가능함
 * 
 * */

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
-- sequence SEQ_EMPNO.CURRVAL is not yet defined in this session
-- 시퀀스가 생성되고 나서 NEXTVAL을 한번이라도 수행하지 않는 이상 CURRVAL을 수행할 수 없기 때문에 발생된 에러
-- CURRVAL은 마지막으로 성공적으로 수행된 NEXTVAL의 값을 저장해서 보여주는 임시값이기 때문

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300

SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300

SELECT * FROM USER_SEQUENCES;
-- LAST_NUMBER : 앞으로 NEXTVAL을 한번 수행할 경우 얻어올 예정값


SELECT SEQ_EMPNO.CURRVAL FROM DUAL;

-- CURRVAL == 310 == MAXVALUE
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;
--  ORA-08004: sequence SEQ_EMPNO.NEXTVAL exceeds MAXVALUE and cannot be instantiated
-- 지정한 MAXVALUE 값을 초과했기 때문에 오류 발생

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
-- 마지막으로 수행된 NEXTVAL 값

/*
 * 3. 시퀀스 변경
 * 	 (시작값은 변경 불가능)
 * 
 * [표현법]
 * ALTER SEQUENCE 시퀀스명
 * INCREMENT BY 증가값 => 생략 가능, 시퀀스 증가할 때마다 몇 씩 증가값 결정(기본값 1씩 증가)
 * MAXVALUE 최대값 => 생략가능, 최대값 지정
 * MINVALUE 최소값 => 생략가능, 최소값 지정
 * CYCLE/NOCYCLE => 생략가능, 값의 순환여부를 결정
 * CACHE 바이트크기/NOCACHE => 생략가능, 캐시메모리 여부 지정(기본값 = 20BYTE)
 * 
 * => START WITH 변경 불가 : 시퀀스를 삭제 후 재생성 해야함
 * 
 * */

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 320 == 310 + 10
-- 중간의 시퀀스가 변경되더라도 CURRVAL값은 유지됨


DROP SEQUENCE SEQ_EMPNO;

SELECT * FROM USER_SEQUENCES;

-- 매번 새로운 사번이 발생되는 시퀀스 생성(시퀀스명 : SEQ_EID)
CREATE SEQUENCE SEQ_EID
START WITH 300
INCREMENT BY 1
MAXVALUE 400;

-- 시퀀스는 PK값에 주로 사용


-- 사원이 추가될 때 실행할 INSERT문
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, SAL_LEVEL, HIRE_DATE)
VALUES(SEQ_EID.NEXTVAL, '민경민', '123456-1234567','J2','S3',SYSDATE);

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, SAL_LEVEL, HIRE_DATE)
VALUES(SEQ_EID.NEXTVAL, ?, ?, ?, ?,SYSDATE);

SELECT * FROM EMPLOYEE;

-- 시퀀스가 가장 많이 사용되는 위치는 INSERT 문의 PK값에 넣을 때

/*
 *	* 사용할 수 없는 구문
 *	1) VIEW의 SELECT문
 *	2) DISTINCT가 포함된 SELECT문
 *	3) GROUP BY HAVING ORDER BY가 있는 SELECT문
 *	4) 서브쿼리 안
 *	5) CREATE TABLE, ALTER TABLE의 DEFAULT값으로도 사용이 불가능
 * 
 * */





























