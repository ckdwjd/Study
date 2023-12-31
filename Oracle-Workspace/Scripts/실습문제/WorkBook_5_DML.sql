-- 1.
INSERT INTO TB_CLASS_TYPE VALUES('01','전공필수');
INSERT INTO TB_CLASS_TYPE VALUES('02','전공선택');
INSERT INTO TB_CLASS_TYPE VALUES('03','교양필수');
INSERT INTO TB_CLASS_TYPE VALUES('04','교양선택');
INSERT INTO TB_CLASS_TYPE VALUES('05','논문지도');
COMMIT;

-- 2.
CREATE TABLE TB_STUDENT_INFO 
AS SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
   FROM TB_STUDENT ts;

-- 3.
DROP TABLE TB_KOR_DEPT;
CREATE TABLE TB_KOR_DEPT
AS SELECT STUDENT_NO, STUDENT_NAME, EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN,1,2),'RR')) 출생연도, PROFESSOR_NAME
	FROM TB_STUDENT ts 
	LEFT JOIN TB_PROFESSOR tp ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
	WHERE ts.DEPARTMENT_NO = (
		SELECT DEPARTMENT_NO
		FROM TB_DEPARTMENT td 
		WHERE DEPARTMENT_NAME = '국어국문학과'
);

SELECT *
FROM TB_KOR_DEPT tkd ;

-- 4.
CREATE TABLE TB_DEPARTMENT_COPY
AS SELECT *
   FROM TB_DEPARTMENT td ;

UPDATE TB_DEPARTMENT_COPY
SET CAPACITY = ROUND(CAPACITY * 1.1);

-- 5.
CREATE TABLE TB_STUDENT_COPY
AS SELECT *
   FROM TB_STUDENT ts ;

UPDATE TB_STUDENT_COPY
SET STUDENT_ADDRESS = '서울시 종로구 숭인동181-21'
WHERE STUDENT_NO = 'A413042';

-- 6.
UPDATE TB_STUDENT_COPY
SET STUDENT_SSN = SUBSTR(STUDENT_SSN,1,6);

-- 7.
DROP TABLE TB_GRADE_COPY ;
CREATE TABLE TB_GRADE_COPY
AS SELECT *
   FROM TB_GRADE tg ;
  
UPDATE TB_GRADE_COPY 
SET POINT = 3.5
WHERE POINT = (
	SELECT POINT
	FROM TB_GRADE_COPY tgc 
	JOIN TB_STUDENT_COPY tsc USING (STUDENT_NO)
	LEFT JOIN TB_DEPARTMENT_COPY tdc USING (DEPARTMENT_NO)
	JOIN TB_CLASS tc USING (CLASS_NO)
	WHERE STUDENT_NAME = '김명훈' AND DEPARTMENT_NAME = '의학과' AND CLASS_NAME = '피부생리학' AND TERM_NO = '200501'
);

-- 8.
UPDATE TB_GRADE_COPY 
SET POINT = 0
WHERE STUDENT_NO IN (
	SELECT STUDENT_NO
	FROM TB_STUDENT_COPY tsc
	WHERE ABSENCE_YN = 'Y'
);

DELETE TB_GRADE_COPY 
WHERE STUDENT_NO IN (
	SELECT STUDENT_NO
	FROM TB_STUDENT_COPY tsc
	WHERE ABSENCE_YN = 'Y'
);

ROLLBACK;

SELECT *
FROM TB_GRADE_COPY tgc ;







