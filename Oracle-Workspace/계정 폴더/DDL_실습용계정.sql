-- 계정명 DDL, 비밀번호 DDL

-- 부여할 권한 : 사용자가 DB에 접속 가능하기 위한 CREATE SESSION이 담겨있는 롤권한
--			  CREATE구문을 사용할 수 있는 권한들이 뭉쳐져있는 롤권한

CREATE USER DDL IDENTIFIED BY DDL;
GRANT CREATE SESSION, RESOURCE TO DDL;

SELECT * FROM dba_users;
