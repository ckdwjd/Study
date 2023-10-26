/*
 * <INDEX>
 * 데이터를 빠르게 검색하기 위한 구조 데이터의 정렬과 탐색과 같은 DBMS의 성능 향상을 목적으로함
 * 
 * 인덱스의 특징
 * 
 * 인덱스로 설정한 컬럼의 데이터들을 별도로 "오름차순"으로 정렬하여
 * 특정 메모리 공간에 물리적인 주소(ROWID) 실제 컬럼의 값을 함께 저장시킴
 * 
 * */

-- 현재 계정에 생성된 인덱스 확인
SELECT * FROM USER_INDEXES; -- PK설정 시 자동으로 인덱스 생성됨
-- 현재 계정에 생성된 인덱스와 + 인덱스가 적용된 컬럼을 확인

SELECT * FROM USER_IND_COLUMNS ;

-- 실행계획 확인.
SELECT * 
FROM EMPLOYEE e
JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID
WHERE EMP_NAME = '송종기';

-- 일반 컬럼인덱스
CREATE INDEX IND_EMPLOYEE_EMP_NAME ON EMPLOYEE(EMP_NAME);

-- 실행계획 확인
-- 인덱스를 만들었다고 해서 조건절에 인덱스를 활용한 컬럼을 제시했을 때 바로 사용하지 않는다
-- 인덱스를 활용하여 조회 여부는 옵티마이저가 판담함
SELECT * 
FROM EMPLOYEE e
JOIN DEPARTMENT d ON DEPT_CODE = DEPT_ID
WHERE EMP_NAME = '송종기';

SELECT EMP_ID
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D5';

CREATE INDEX IND_EMPLOYEE_DEPT_CODE ON EMPLOYEE(DEPT_CODE);

-- 인덱스 삭제 구문
DROP INDEX IND_EMPLOYEE_EMP_NAME;


/*
 * 인덱스의 장점
 * 1) WHERE절에 인덱스 컬럼을 사용 시 훨씬 빠르게 연산이 가능
 * 2) ORDER BY연산을 사용할 필요가 없다(이미 오름차순으로 정렬됨)
 * 	  ORDER BY절은 메모리를 많이 잡아먹는 작업
 * 3) MIN, MAX값을 찾을 때 연산속도가 매우 빠름(정렬되어 있음)
 * 
 * 
 * 인덱스의 단점
 * 1) DML에 취약함
 * 	  INSERT, DELETE, UPDATE 등 데이터가 새롭게 추가/삭제되면 인덱스 테이블안에 있는 값들을 다시 정렬하고,
 * 	  물리적 주소를 수정해야함
 * 2) INDEX를 이용한 INDEX_SCAN보다 단순한 FULL_SCAN이 더 효율적일 수 있음
 * 	  일반적으로 테이블의 전체 데이터 중 10~15%정도의 데이터를 처리하는 경우에만 효율적
 * 3) 인덱스가 많을수록 저장공간을 잡아먹음, 인덱스가 많으면 저장공간이 부족하게 되므로
 * 	  적절한 수준을 유지해야함
 * 
 * */









