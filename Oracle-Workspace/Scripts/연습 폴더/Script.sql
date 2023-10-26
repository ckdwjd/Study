--아래의 SQL구문은 부서 별 평균 월급이 2800000을 초과하는 부서를 조회한 것이다.
--결과가 올바르지 않다고 할 때, 그 원인(20점)과 올바르게 수정한 조치사항(20점)을 각각 항목에 맞게 기술하시오. (총 40점)



SELECT DEPT_CODE, SUM(SALARY) 합계, FLOOR(AVG(SALARY)) 평균, COUNT(*) 인원수

FROM EMPLOYEE e 

WHERE SALARY > 2800000

GROUP BY DEPT_CODE

ORDER BY DEPT_CODE ASC;

