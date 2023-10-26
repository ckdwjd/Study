-- 3-1.
-- CREATE TABLE 권한 부여받기 전 상태
CREATE TABLE TEST (
	TEST_ID NUMBER
);
-- ORA-01950: no privileges on tablespace 'SYSTEM'
-- 불충분한 권한 에러 : SAMPLE 계정에 테이블을 생성할 수 있는 권한을 부여하지 않음

-- 3-2.
-- CREATE TABLE 권한 부여받기 후 상태
CREATE TABLE TEST (
	TEST_ID NUMBER
);
-- ORA-01950: no privileges on tablespace 'SYSTEM'
-- 불충분한 권한 에러 : SAMPLE 계정에 테이블을 생성할 수 있는 권한을 부여하지 않음
-- SAMPLE 계정에 TABLESPACE가 아직 할당되지 않아서 오류 발생

-- TABLESPACE를 할당받은 후
CREATE TABLE TEST (
	TEST_ID NUMBER
);
-- 테이블 생성 완료

-- 위의 테이블 생성권한을 부여받게 되면
-- 계정이 소유하고 있는 테이블들을 조작하는것도 가능해짐(DML)
INSERT INTO TEST VALUES(1);
SELECT *
FROM TEST;

-- 4. 뷰 만들어보기
CREATE VIEW V_TEST
AS SELECT * FROM TEST;
-- 불충분한 권한 에러

-- CREATE VIEW 권한 부여받은 후
CREATE VIEW V_TEST
AS SELECT * FROM TEST;
-- 뷰 생성 완료

-- 5. SAMPLE계정에서 KH계쩡의 테이블에 접근해서 조회해보기
SELECT *
FROM KH.EMPLOYEE;
-- KH계정의 테이블에 접근해서 조회할 수 있는 권한이 없기 떄문에 오류 발생

-- SELECT ON 권한 부여 후
SELECT *
FROM KH.EMPLOYEE;

SELECT *
FROM KH.DEPARTMENT;
-- DEPARTMENT테이블에 접근할 수 있는 권한이 없기 때문에 오류

-- 6. SAMPLE계정에서 KH계정의 테이블에 접근해서 행 삽입하기
INSERT INTO KH.DEPARTMENT d VALUES('D0','회계부','L2');

INSERT INTO KH.DEPARTMENT d VALUES('D0','회계부','L2');
COMMIT;


-- 7. 테이블 만들기
CREATE TABLE TEST2 (
	TEST_ID NUMBER
);
-- SAMPLE 계정에서 테이블을 생성할 수 없도록 권한을 회수했기 때문에 오류 발생






















