/*
    <함수 FUNCTION>
    자바로 따지면 메소드와 같은 존재
    매개변수로 전달된 값들을 읽어서 계산한 결과를 반환 => 호출해서 쓸 것
    
    - 단일행 함수 : n개의 값을 읽어서 n개의 결과를 리턴(매 행마다 함수 실행 후 결과 반환)
    - 그룹 함수 : n개의 값을 읽어서 1개의 결과를 리턴(하나의 그룹별로 함수 실행 후 결과를 반환)
    
    단일행 함수와 그룹함수는 함께 사용할 수 없음 : 결과 행의 갯수가 다르기 때문
*/
-------------------------------------<단일형 함수>---------------------------------
/*
    <문자열과 관련된 함수>
    LENGTH / LENGTHB
    
    - LENGTH(문자열) : 전달된 문자열의 글자 수 반환
    - LENGTHB(문자열) : 전달된 문자열의 바이트 수 반환
    
    결과값은 숫자로 반환 => NUMBER
    문자열 : 문자열 형식의 리터럴, 문자열 정보가 저장된 컬럼
    
    한글은 글자당 3BYTE OR 2BTYE
    영문, 숫자, 특수문자 : 글자당 1BYTE 취급
*/

SELECT LENGTH('오라클!'), LENGTHB('오라클!')
FROM DUAL;

-- DUAL : 가상테이블(DUMMY TABLE) : 산술이나 가상컬럼 등 값을 한번만 테스트 용도로 출력하고 싶을 때 사용하눈 테이블

SELECT '오라클' , 1,2,3, SYSDATE
FROM DUAL;

SELECT EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL), EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME)
FROM EMPLOYEE;    

/*
    INSTR
    - INSTR(문자열, 특정문자, 찾을 위치의 시작값, 순번) : 문자열로부터 특정 문자의 위치값을 반환
    
    찾을 위치의 시작값, 순번은 생략 가능. 결과값 => NUMBER타입으로 반환
    찾을 위치의 시작값 (1/-1)
    1 : 앞에서부터 시작(생략 시 기본값)
    -1 : 뒤에서부터 시작
*/

SELECT INSTR('AABAACAABBAA','B')
FROM DUAL; -- 3

SELECT INSTR('AABAACAABBAA','B',1)
FROM DUAL; -- 3

SELECT INSTR('AABAACAABBAA','B',-1)
FROM DUAL;

SELECT INSTR('AABAACAABBAA','B',-1, 2)
FROM DUAL; -- 9

SELECT INSTR('AABAACAABBAA','B',-1, 0)
FROM DUAL; -- 에러 발생(범위를 벗어난 순번 제시 시 오류)
-- 인덱스처럼 글자의 위치를 찾는 것은 맞지만 자바처럼 0부터 시작이 아니라 1부터 시작

-- EMAIL에서 @위치 찾기
SELECT INSTR(EMAIL, '@') AS "@의 위치"
FROM EMPLOYEE;

/*
    SUBSTR
    문자열로부터 특정 문자열을 추출하는 함수
    
    - SUBSTR(문자열, 처음위치, 추출할 문자갯수)
    
    결과 값은 CHARACTER타입으로 반환(문자열 형태)
    추출할 문자 갯수는 생략 가능(생략 시 문자열 끝까지 추출함)
    처음 위치는 음수로 제시 가능 : 뒤에서부터 N번째 위치로부터 문자를 추출하겠다는 의미
*/

SELECT SUBSTR('SHOWMETHEMONEY',7)
FROM DUAL; -- THEMONEY

SELECT SUBSTR('SHOWMETHEMONEY',5, 2)
FROM DUAL; -- ME

SELECT SUBSTR('SHOWMETHEMONEY', 1, 6)
FROM DUAL; -- SHOWME

SELECT SUBSTR('SHOWMETHEMONEY', -1, 6)
FROM DUAL; -- Y

SELECT SUBSTR('SHOWMETHEMONEY', -8 ,3)
FROM DUAL; -- THE

-- 주민등록번호에서 성별부분을 추출해서 남자(1), 여자(2)를 체크
SELECT EMP_NAME, SUBSTR(EMP_NO, 8, 1) AS GENDER
FROM EMPLOYEE;

-- 이메일에서 ID부분만 추출해서 조회(INSTR + SUBSTR)
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL,'@') -1 ) AS ID
FROM EMPLOYEE;

-- 남자인 사원들만 조회
SELECT EMP_NAME, SALARY, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1','3');

/*
    LPAD / RPAD
    
    - LPAD / RPAD(문자열, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
    : 제시한 문자열에 덧붙이고자 하는 문자를 왼쪽, 오른쪽에 덧붙여서 최종적으로 N길이 만큼의 문자열 반환
    
    결과 값은 CHARACTER타입으로 반환
    덧붙이고자 하는 문자 생략가능(기본값 ' ')
*/

SELECT LPAD(EMAIL, 16), EMAIL
FROM EMPLOYEE;

SELECT RPAD(EMAIL,20 , '#')
FROM EMPLOYEE;

-- 주민등록번호 조회 : 621235-1985634 => 621235-1******
-- EMP_NAME, EMP_NO 조회

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1, 8), 14 ,'*') AS 주민번호
FROM EMPLOYEE;

/*
    LTRIM / RTRIM
    - LTRIM / RTRIM(문자열, 제거시키고자 하는 문자)
    : 문자열의 왼쪽, 오른쪽에서 제거시키고자 하는 문자들을 찾아서 제거한 후 반환
    
    결과 값은 CHARACTER형태로 나옴
    제거시키고자 하는 문자는 생략 가능 => ' '(공백)이 기본값
*/

SELECT LTRIM('        K        H             ')
FROM DUAL;

SELECT RTRIM('        K        H             ')
FROM DUAL;

SELECT LTRIM('00012304568100','0')
FROM DUAL;

SELECT RTRIM('00012304568100','0')
FROM DUAL;

SELECT LTRIM('12123KH123','123K')
FROM DUAL;
-- 제거시키고자하는 문자열을 통으로 지워주는게 아니라
-- 문자 하나하나가 존재하면 지워주는 원리(정규식과 유사)

/*
    TRIM
    - TRIM(BOTH/LEADING/TRAILING '제거하고자 하는 문자' FROM '문자열')
    : 문자열의 양쪽/앞쪽/뒤쪽에 있는 특정 문자를 제거한 나머지 문자열을 반환
    
    결과 값은 문자열 타입으로 반환
    옵션은 생략가능, 기본값은 BOTH
*/
SELECT TRIM('    K       H   ')
FROM DUAL;

-- 
SELECT TRIM(LEADING 'Z' FROM 'ZZZZZZK           HZZZZZZZ')
FROM DUAL; -- == LTRIM과 비슷

SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZZK           HZZZZZZZ')
FROM DUAL; -- == RTRIM과 비슷

SELECT TRIM(BOTH 'Z' FROM 'ZZZZZZK           HZZZZZZZ')
FROM DUAL; -- == TRIM과 비슷

/*
    LOWER / UPPER / INITCAP
    
    - LOWER(문자열) : 소문자로 변경
    
    - UPPER(문자열) : 대문자로 변경
    
    - INITCAP(문자열) : 각 단어의 첫 번째 글자만 대문자로 변경(스페이스바로 구분)
*/

SELECT LOWER('Welcome'), UPPER('Welcome'), INITCAP('welcome to c class')
FROM DUAL;

/*
    CONCAT
    
    - CONCAT(문자열1,문자열2) : 전달된 문자열 두개를 하나의 문자열로 합쳐서 반환
*/
SELECT CONCAT('민경민','MKM')
FROM DUAL;

SELECT CONCAT('민경민','MKM','MIN')
FROM DUAL;

SELECT CONCAT(CONCAT('민경민','MKM'), 'HAPPY')
FROM DUAL;

SELECT '민경민' || 'MKM' || 'MIN'
FROM DUAL;

/*
    REPLACE
    
    - REPLACE(문자열, 찾을 문자, 바꿀 문자) : 문자열로부터 찾을 문자를 바꿀문자로 변환 후 반환
*/

SELECT REPLACE('서울시 강남구 역삼동', '역삼동','삼성동')
FROM DUAL;

--------------------------------------------------------------------------------

/*
    <숫자와 관련된 함수>
    
    ABS
    
    - ABS(절댓값을 구할 숫자) : 절대값을 구해주는 함수
    
    결과 값은 NUMBER형태로 반환
*/

SELECT ABS(-59)
FROM DUAL;

/*
    MOD
    
    - MOD(숫자, 나눌값) : % 두 수를 나눈 나머지 값을 반환
*/

SELECT MOD(10,3)
FROM DUAL;

SELECT MOD(-10,3)
FROM DUAL;

SELECT MOD(10.9,3)
FROM DUAL;

/*
    ROUND
    
    - ROUND(반올림할 숫자, 반올림할 위치) : 반올림 처리
    
    반올림할 위치 : 소숫점 기준으로 아래 N번째에서 수행
                 위치 생략 시 기본값은 0, 소수 첫번째 위치에서 반올림 수행
*/

SELECT ABS(-59)
FROM DUAL; -- 123

SELECT ROUND(123.456, 1)
FROM DUAL; -- 123.5

SELECT ROUND(123.456, -1)
FROM DUAL; -- 120

/*
    CEIL
    
    - CEIL(올림할 숫자) : 소숫점 아래 수를 무조건 올림 수행
    
    FLOOR
    
    - FLOOR(버림할 숫자) : 소숫점 아래 수를 무조건 버림 수행
*/

SELECT CEIL(123.11111)
FROM DUAL; -- 124

SELECT FLOOR(123.9999991)
FROM DUAL; -- 123

-- 각 직원별 근무일 수 구하기 (오늘날짜 - 고용일 ==> 소숫점)
SELECT EMP_NAME, CONCAT(FLOOR(SYSDATE-HIRE_DATE),'일') AS 근무일수
FROM EMPLOYEE;

/*
    TRUNC
    
    - TRUNC(버림처리할 숫자, 위치) : 위치지정이 가능한 버림처리 함수
    
    위치 생략 시 기본값은 0 == FLOOR함수와 동일
*/

SELECT TRUNC(123.789)
FROM DUAL; -- 123

SELECT TRUNC(123.789, 1)
FROM DUAL; -- 123.7

SELECT TRUNC(123.789, 2)
FROM DUAL; -- 123.78

SELECT TRUNC(123.789, -1)
FROM DUAL; -- 120

-------------------------------------------------------------------------------

/*
    <날짜 관련 함수>
    
    DATE 타입 : 년도, 월, 일, 시, 분, 초를 다 포함한 자료형
*/

-- 1. MONTHS_BETWEEN(DATE1, DATE2) : 두 날짜 사이의 개월 수 반환(반환값 = NUMBER)
-- DATE2가 더 미래일 경우 음수 반환
-- 각 직원별 근무일수, 근무개월수

SELECT EMP_NAME, FLOOR(SYSDATE - HIRE_DATE) || '일' 근무일수
    , FLOOR(ABS(MONTHS_BETWEEN(SYSDATE , HIRE_DATE))) || '개월' 근무개월수
FROM EMPLOYEE;

-- 2. ADD_MONTHS(DATE, NUMBER) : 특정 날짜에 해당 숫자만큼 개월수를 더한 날짜 반환(결과값은 DATE 타입)
-- 오늘 날짜로부터 5개월 이후
SELECT ADD_MONTHS(SYSDATE, 5)
FROM DUAL;

-- 전체 사원들의 1년 근속일(== 입사일 기준 1주년)
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 12)
FROM EMPLOYEE;

-- 3. NEXT_DAY(DATE, 요일(문자/숫자)) : 특정 날짜에서 가장 가까운 요일을 찾아서 그 날짜를 반환
SELECT EMP_NAME, CONCAT(FLOOR(SYSDATE-HIRE_DATE),'일') AS 근무일수
FROM EMPLOYEE;

SELECT NEXT_DAY(SYSDATE, '토')
FROM DUAL;

-- 1:일요일, 2:월요일, 3:화 ... 7:토요일
SELECT NEXT_DAY(SYSDATE, 7)
FROM DUAL;

-- DDL(데이터 정의 언어) : CREATE, ALTER, DROP
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

SELECT NEXT_DAY(SYSDATE, 'sat')
FROM DUAL;

-- 한국어로 언어를 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

SELECT NEXT_DAY(SYSDATE, '토')
FROM DUAL;

-- 4. LAST_DAY(DATE) : 해당 특정 날짜 달의 마지막 날짜를 구해서 반환(DATE 자료형)
SELECT LAST_DAY(SYSDATE)
FROM DUAL;

-- 5. EXTRACT : 년도, 월, 일 등의 정보를 추출해서 반환(NUMBER 자료형)
/*
    - EXTRACT(YEAR FROM 날짜) : 특정 날짜로부터 YEAR만 추출
    - EXTRACT(MONTH FROM 날짜) : 특정 날짜로부터 MONTH만 추출
    - EXTRACT(DAY FROM 날짜) : 특정 날짜로부터 DAY만 추출
*/

SELECT EXTRACT(YEAR FROM SYSDATE),
       EXTRACT(MONTH FROM SYSDATE),
       EXTRACT(DAY FROM SYSDATE)
FROM DUAL;
--------------------------------------------------------------------------------

/*
    <형변환 함수>
    NUMBER/DATE => CHARACTER
    
    - TO_CHAR(NUMBER/DATE, 포멧)
    : 숫자/날짜형 데이터를 문자열 타입으로 반환(포멧을 기준)
*/

-- 숫자를 문자열로
SELECT TO_CHAR(1234)
FROM DUAL; -- 1234 => '1234'

SELECT TO_CHAR(1234,'00000')
FROM DUAL; -- 1234 => '01234' : 빈 공간을 0으로 채워줌

SELECT TO_CHAR(1234, '99999')
FROM DUAL; -- 1234 => '1234' : 빈칸을 ' '으로 채워줌

SELECT TO_CHAR(1234, 'L00000')
FROM DUAL; -- L : LOCAL => 현재 설정된 나라의 화폐단위

SELECT TO_CHAR(1234, 'L99,999')
FROM DUAL; -- ₩1,234

--------------------------------------------------------------------------------

SELECT SYSDATE
FROM DUAL; -- '23/05/30'

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
FROM DUAL; -- '2023-05-30'

-- 시 분 초 : 오전(AM)/오후(PM)
SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS')
FROM DUAL;

-- 시분초 : 24시간형태
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY')
FROM DUAL; -- 화

SELECT TO_CHAR(SYSDATE, 'MON DAY, YYYY')
FROM DUAL; -- 화요일

-- 년도로 쓸 수 있는 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')
      
FROM DUAL;
-- YY와 RR의 차이점
-- R : ROUND(반올림)
-- Y : 앞자리에 무조건 20이 붙음 => (20)21
-- RR : 50년 기준으로 작으면 20, 크면 19가 붙음 => 89 = 1989

-- 월로써 쓸 수 있는 포맷
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM') -- RM : 로마기호로 표기
FROM DUAL;

-- 일로써 쓸 수 있는 포맷
SELECT TO_CHAR(SYSDATE, 'D'), -- 일주일 기준으로 3번째에 위치
       TO_CHAR(SYSDATE, 'DD'),
       TO_CHAR(SYSDATE, 'DDD') -- 일년 기준으로 현재 몇번째 요일
FROM DUAL;
-- D : 1주일 기준으로 일요일부터 며칠째인지 알려줌
-- DD : 1달 기준으로 1일부터 며칠째인지 알려줌
-- DDD : 1년 기준으로 1월 1일부터 며칠쨰인지 알려줌

-- 요일로써 쓸 수 있는 포맷
SELECT TO_CHAR(SYSDATE, 'DY'),
       TO_CHAR(SYSDATE, 'DAY')
FROM DUAL; -- '요일'이라는 단위가 여부

-- EMPLOYEE에서 2010년 이후에 입사한 사원들의 사원명, 입사일(xxxx년 xx월 xx일 (수))을 조회
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" (DY)') AS 입사일
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) >+2010;
-- WHERE HIRE_DATE >= '10/01/01';

/*
    NUMBER/CHARACTER => DATE
    - TO_DATE(NUMBER/CHARACTER, 포맷) : 숫자형, 문자열 데이터를 날짜형 데이터로 변환
*/
SELECT TO_DATE(20210101)
FROM DUAL; -- 기본 포맷 YY/MM/DD로 변환

SELECT TO_DATE('20210101')
FROM DUAL;

SELECT TO_DATE(00010101)
FROM DUAL;
-- 숫자는 0부터 시작할 수 없다

SELECT TO_DATE('00010101')
FROM DUAL;
-- 따라서 ''로 묶어서 표기

SELECT TO_DATE('20100101','YYYYMMDD')
FROM DUAL; -- 10/01/01

SELECT TO_DATE('140630','YYMMDD')
FROM DUAL; -- 14/06/30 => 2014/06/30

SELECT TO_DATE('880218','YYMMDD')
FROM DUAL; -- 2088/02/18

SELECT TO_DATE('880218','RRMMDD')
FROM DUAL; -- 1988/02/18
-- 두 자리 년도에 대해 RR포맷을 적용시켰을 경우 => 50년 이상이면 19, 50미만이면 20이 붙음

/*
 *  CHARACTER => NUMBER
 * - TO_NUMBER(CHARACTER,포멧) : 문자열 데이터를 숫자형으로 변환(결과값 : NUMBER)
 */

-- 자동형변환 예시 (문자열 -> 숫자)
SELECT '123'+'456'
FROM DUAL; -- 579 : 자동형변환 시킨 후 산술연산 실행

SELECT '10,000,000' + '550,000'
FROM DUAL; -- 문자(,)가 포함되어 있기 떄문에 자동형변환이 안됨

SELECT  TO_NUMBER('0123')
FROM DUAL; -- 123

SELECT TO_NUMBER('10,000,000','99,999,999') + TO_NUMBER('550,000','999,999')
FROM DUAL;

-- 문자열, 숫자, 날짜 형변환(RO_CHAR, TO_NUMBER, TO_DATE)

----------------------------------------------------------------------------------

-- NULL : 값이 존재하지 않음을 나타내는 값
-- NULL 처리 함수 : NVL, NVL2, NULLIF

/*
 * < NULL 처리 함수>
 * 
 * NVL(컬럼명, 해당 컬럼값이 NULL일 경우 반환할 값)
 * 해당 컬럼에 값이 존재할 경우 기존의 컬럼값을 반환
 * 컬럼에 값이 존재하지 않을 경우 내가 제시한 값이 반
 */

-- 사원명, 보너스, 보너스가 없는 경우 0으로 바꿔서 출력
SELECT EMP_NAME, BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

-- 보너스 포함 연봉 조회
SELECT EMP_NAME, (SALARY + (SALARY * NVL(BONUS,0)))*12 연봉
FROM EMPLOYEE e;

/*
 * NVL2(컬럼명, 결과값1, 결과값2)
 * 해당 컬럼값이 NULL이 아닐경우 결과값1 반환
 * 해당 컬럼값이 NULL일 경우 결과값2 반  
 */

-- 이름 + 부서코드 + 보너스가 있는 사원은 '보너스가 있음', 보너스가 없는 사원은 '보너스 없음 '
SELECT EMP_NAME, DEPT_CODE, NVL2(BONUS, '보너스 있음', '보너스 없음') "보너스 유무"
FROM EMPLOYEE e ;

-- 이름 + 부서코드 + 부서코드가 있는 사원은 '부서배치완료', 없는 사원은 '없음' 조회
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '부서배치완료', '없음') "부서배치 유무"
FROM EMPLOYEE e ;

/*
 * NULLIF(비교대상1, 비교대상2) : 동등비교
 * 두 값이 동일할 경우 NULL반환
 * 두 값이 동일하지 않을 경우 비교대상1 반환
 */
SELECT NULLIF('123','456')
FROM DUAL;

------------------------------------------------------------------------------

-- 선택함수 : DECODE => SWITCH문
--			CASE WHEN THEN 구문 => IF문

/*
 * <선택함수>
 * - DECODE(비교대상, 조건값1, 결과값1, 조건값2, 결과값2, ... , 결과값)
 * 
 * - 자바의 SWITCH문과 유사
 * 	SWITCH(비교대상) {
 * case 조건1 : 결과값1; break; 
 * case 조건2 : 결과값2; break;
 * ...
 * default : 결과값 
 * 
 * 비교대상에는 컬럼, 산술연산, 함수가 들어갈 수 있음
 */

-- 사원, 사원명, 주민등록번호, 주민등록번호로 부터 성별 자리를 추출해서 1이면 남자 2이면 여자 성별컬럼 만들기
SELECT EMP_ID, EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8,1), '1' ,'남자' , 2 , '여자') 성별 
FROM EMPLOYEE e ;

-- 직원들의 급여를 인상시켜서 조회
-- 직급코드가 'J7'인 사원은 급여를 10%인상
-- 직급코드가 'J6'인 사원은 급여를 15%인상
-- 직급코드가 'J5'인 사원은 급여를 20%인상
-- 그 외의 직급코드는 급여를 5%만 인상시켜 조회
-- 사원명, 직급코드, 변경전 급여와 변경후 급여를 출력
SELECT EMP_NAME, JOB_CODE, SALARY "변경전 급여", 
DECODE(JOB_CODE, 'J7', SALARY*1.1, 'J6', SALARY*1.15, 'J5',SALARY*1.2, SALARY*1.05) "변경후 급여"
FROM EMPLOYEE e ;

/*
 * CASE WHEN THEN 구문
 * - DECODE 선택함수와 비겨하면 DECODE는 해당 조건 검사 시 동등비교만을 수행
 * 
 * CASE WHEN THEN구문의 경우 특정 조건을 내 마음대로 제시 가능(is ~ else문과 유사)
 * [표현법]
 * CASE WHEN 조건식1 THEN 결과값1
 * 		WHEN 조건식2 THEN 결과값2
 * 		WHEN 조건식3 THEN 결과값3
 * 		...
 * 		ELSE 결과값
 * END;
 * */

SELECT EMP_NAME, JOB_CODE, SALARY "변경전 급여", 
CASE WHEN JOB_CODE = 'J7' THEN SALARY*1.1
	 WHEN JOB_CODE = 'J6' THEN SALARY *1.15
	 WHEN JOB_CODE = 'J5' THEN SALARY *1.2
	 ELSE SALARY * 1.05
 END "변경후 급여"
FROM EMPLOYEE e ;

-- 사원명, 급여, 급여등급(SAL_LEVEL컬럼 사용 금지)
-- 급여등급 : 급여값이 500만원 초과일 경우 '고급'
-- 급여등급 : 급여값이 500만원 이하 350만원 초과일 경우 '중급'
-- 급여등급 : 급여값이 350만원 이하일 경우 '초급'

SELECT EMP_NAME, SALARY,
CASE WHEN SALARY > 5000000 THEN '고급'
	 WHEN SALARY > 3500000 THEN '중급'
	 ELSE '초급'
 END "급여등급"
FROM EMPLOYEE e ;

-----------------------단일행 함수----------------------------------------------------------------

-- 그룹함수 : 데이터들의 함(SUM), 데이터들의 평균(AVG), 
/*
 * N개의 값을 읽어서 1개의 결과를 반환(하나의 그룹별로 함수 실행결과 반환)
 * */

-- 1. SUM(숫자타입컬럼) : 해당 컬럼값들의 총 합계를 반환해주는 함수
-- 전체 사원들의 총 급여 합계
SELECT SUM(SALARY)
FROM EMPLOYEE e ;

-- 부서 코드가 'D5'인 사원들의 총 급여 합계
SELECT SUM(SALARY)
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D5';

-- 2. AVG(숫자타입컬럼) : 해당 컬럼값들의 평균을 구해서 반환
-- 전체 사원들의 평균 급여
SELECT ROUND(AVG(SALARY)) 
FROM EMPLOYEE e ;

-- 3. MIN(ANY타입) : 해당 컬럼값들 중 가장 작은 값을 반환
-- 전체 사원들 중 최저급여, 가장작은 이름값, 가장작은 이메일값, 입사일이 가장 예전인 사원
SELECT 
	MIN(SALARY), MIN(EMP_NAME), MIN(EMAIL), MIN(HIRE_DATE)
FROM EMPLOYEE e ;

-- 4. MAX(ANY타입) : 해당 컬럼값들 중 가장 큰 값 반환
SELECT 
	MAX(SALARY), MAX(EMP_NAME), MAX(EMAIL), MAX(HIRE_DATE)
FROM EMPLOYEE e ;
	
-- 5. COUNT(*/컬럼이름/DISTINCT 컬럼이름) 조회된 행의 갯수를 세서 반환

-- COUNT(*) : 조회결과에 해당하는 모든 행의 갯수를 다 세서 반환

-- COUNT(컬럼이름) : 제시한 해당 컬럼의 값이 NULL이 아닌것만 세서 반환

-- COUNT(DISTINCT 컬럼이름) : 제시한 해당 컬럼값이 중복 값이 있을 경우 하나로만 세서 반환


-- 전체 사원수에 대해 조회
SELECT COUNT(*)
FROM EMPLOYEE e ; -- 23

-- 여자인 사원수만 조회
SELECT COUNT(*)
FROM EMPLOYEE e 
WHERE SUBSTR(EMP_NO, 8, 1) = '2'; 

-- 부서 배치가 완료된 여자 사원수
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE e 
--WHERE SUBSTR(EMP_NO, 8, 1) = '2' AND DEPT_CODE IS NOT NULL;
WHERE SUBSTR(EMP_NO, 8, 1) = '2';

-- 현재 사원들이 속해있는 부서의 갯수
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE e ;

----------------------------------------------------------------------------------
-- EMPLOYEE 테이블에서 직원명, 부서코드, 생년월일, 나이 조회
-- (단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력)
-- 나이는 주민번호에서 날짜데이터로 변환한 다음 계산

SELECT EMP_NAME, DEPT_CODE,
	TO_CHAR(TO_DATE(SUBSTR(EMP_NO , 1 , 6) , 'RRMMDD') , 'YY"년" MM"월" DD"일"') "생년월일", 
--	EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2) , 'RRRR')) "나이"
	TO_CHAR(SYSDATE, 'YY') + 100 - SUBSTR(EMP_NO, 1, 2) "나이"
FROM EMPLOYEE e ;






















