/*
 * <트리거>
 * 지정한 테이블에 INSERT, UPDATE, DELETE 등의 DML문에 의해 변경사항이 생길 때(테이블에 이벤트가 발생했을 때)
 * 자동으로 매번 실행할 내용을 미리 정의해둘 수 있는 객체
 * 
 * EX)
 * 회원탈퇴 시 기존의 테이블에 데이터를 DELETE 후 곧바로 탈퇴한 회원들만 따로 보관하는 테이블에 자동으로 INSERT
 * 처리해야될 때 
 * 
 * 신고횟수가 일정수를 넘었을 때 묵시적으로 해당 회원을 블랙리스트 처리되게 끔 할 때
 * 
 * 입출고에 대한 데이터가 기럭(INSERT)될 떄마다 해당 상품에 대한 재고수량을 매번 수정(UPDATE)해야될 때
 * 
 *  * 트리거 종류
 * 	SQL문의 시행시기에 따른 분류
 * 		> BEFORE TRIGGER : 내가 지정한 테이블에 이벤트(INSERT, UPDATE, DELETE)가 발생되기전에 트리거 실행
 * 		> AFTER TRIGGRER : 내가 지정한 테이블에 이벤트가 발생된 후 트리거 실행
 * 
 * 	SQL문에 의해 영향을 받는 각 행에 따른 분류
 * 		> STATEMENT TRIGGER(문장트리거) : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행
 * 		> 	  ROW TRIGGER(행트리거) 	 : 해당 SQL문 실행할 때마다 매번 트리거 실행
 * 					> OLD - BEFORE UPDATE(수정전 자료), BEFORE DELETE(삭제전 자료)
 * 					> NEW - AFTER INSERT(추가된 자료), AFTER UPDATE(수정 후 자료)
 * 
 * 
 * 	* 트리거 생성구문
 * [표현식]
 * CREATE OR REPLACE TRIGGER 트리거명
 * BEFORE|AFTER INSERT|DELETE|UPDATE ON 테이블명
 * [FOR EACH ROW] -- 행트리거
 * DECLARE
 * 		변수선언;
 * BEGIN
 * 		실행내용(해당 위에 지정된 이벤트 발생 시 자동으로 실행할 구문)
 * EXCEPTION
 * END;
 * 
 * 
 * */
-- EMPLOYEE 테이블에 새로운 행이 INSERT될 때마다 자동으로 메세지가 출력되는 트리거 정의
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN 
	DBMS_OUTPUT.PUT_LINE('신입사원님 환영합니다');
END;

-------------------------------------------------------------------------------------------------------------------

-- 상품 입고 및 출고 관련 예시
--> 필요한 테이블 및 시퀀스 생성

-- 1. 상품에 대한 데이터를 보관할 테이블(TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
	PCODE NUMBER PRIMARY KEY, -- 상품번호
	PNAME VARCHAR2(30) NOT NULL, -- 상품명
	BRAND VARCHAR2(30) NOT NULL, -- 브랜드
	PRICE NUMBER, -- 가격
	STOCK NUMBER DEFAULT 0 -- 재고수량
);

-- 상품번호 중복 안되게끔 매번 새로운 번호를 발생시키는 시퀀스 생성(SEQ_PCODE)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;

-- TB_PRODUCT에 샘플데이터 추가하기
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시 z플립4','삼성',1000000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시북','삼성',3000000, 10);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '아이폰 14 PRO','삼성',1500000, 20);

SELECT * FROM TB_PRODUCT ;

COMMIT;

-- 2. 상품 입출고 상세 이력 테이블(TB_PRODETAIL)
-- 	  어떤 상품이 어떤 날짜에 몇개가 입출고 되었는지에 대한 데이터를 기록하는 테이블
CREATE TABLE TB_PRODETAIL(
	DCODE NUMBER PRIMARY KEY, -- 이력번호
	PCODE NUMBER REFERENCES TB_PRODUCT, -- 상품번호
	PDATE DATE NOT NULL, -- 상품 입출고일
	AMOUNT NUMBER NOT NULL, -- 입출고 수량
	STATUS CHAR(6) CHECK(STATUS IN ('입고','출고')) -- 상태(입출고)
);

-- 이력번호를 자동으로 발생시켜주는 시퀀스 생성(SEQ_DCODE)
CREATE SEQUENCE SEQ_DCODE;

-- 200번인 상품이 오늘 날자로 10개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 200, SYSDATE, 10, '입고');

-- 200번 상품에 대한 재고수량 10개 증가
UPDATE TB_PRODUCT 
SET STOCK = STOCK + 10
WHERE PCODE = 200;

SELECT * FROM TB_PRODUCT;

COMMIT;

-- 210번 상품이 오늘날짜로 5개가 출고
INSERT INTO TB_PRODETAIL 
VALUES(SEQ_DCODE.NEXTVAL, 210, SYSDATE, 5, '출고');

-- 210번 상품의 재고수량을 5 감소
UPDATE TB_PRODUCT 
SET STOCK = STOCK - 5
WHERE PCODE = 210;

COMMIT;

-- TB_PRODETAIL테이블에 INSERT이벤트 발생한 후
-- TB_PRODUCT테이블에 매번 자동으로 재고수량을 변경해주는 트리거 정의

/*
 * 	- 상품이 입고된 경우 -> 해당 상품을 찾아서 재고수량 증가 
 * 		UPDATE TB_PRODUCT
 * 			SET STOCK = STOCK + 현재 입고된 수량 (TB_PRODETAIL테이블에 INSERT된 AMOUNT값)
 * 		WHERE PCODE = 입고된 상품번호(INSERT된 PCODE값)
 * 	
 *  - 상품이 출고된 경우 -> 해당 상품을 찾아서 재고수량 감소 
 * 		UPDATE TB_PRODUCT
 * 			SET STOCK = STOCK - 현재 입고된 수량 (TB_PRODETAIL테이블에 INSERT된 AMOUNT값)
 * 		WHERE PCODE = 입고된 상품번호(INSERT된 PCODE값)
 * 
 * */

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW 
BEGIN 
	-- 상품이 입고된 경우 => 재고수량 증가
	IF(:NEW.STATUS = '입고')
		THEN 
		UPDATE TB_PRODUCT
		SET STOCK = STOCK + :NEW.AMOUNT -- :NEW 키워드를 통해 INSERT 값 활용
		WHERE PCODE = :NEW.PCODE;
	ELSE 
	UPDATE TB_PRODUCT
		SET STOCK = STOCK - :NEW.AMOUNT -- :NEW 키워드를 통해 INSERT 값 활용
		WHERE PCODE = :NEW.PCODE;
	END IF;
END;

-- 210번 상품이 오늘 날짜로 7개 출고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 210, SYSDATE, 7, '출고');

SELECT * FROM TB_PRODUCT;

INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 200, SYSDATE, 10, '입고');

/*
 * 트리거의 장점
 * 1. 데이터 추가, 수정, 삭제 시 자동으로 데이터 관리를 해줌으로써 무결성 보장
 * 2. 데이터베이스 관리의 자동화
 * 
 * 트리거의 단점
 * 1. 빈번한 추가, 수정, 삭제 시 ROW의 삽입, 추가, 삭제가 함께 실행되므로 성능상 좋지못하다
 * 2. * 관리적 측면에서 형상관리가 불가능하기 때문에 관리가 불편
 * 3. 트리거를 남용하개되는 경우 예상치 못한 사태가 발생할 수 있으며 유지보수가 힘들다
 * 
 * */






















