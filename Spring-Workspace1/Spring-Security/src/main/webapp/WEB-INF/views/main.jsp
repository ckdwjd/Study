<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<!--  
		Authentication?
		- 로그인한 사용자의 정보가 담기는 객체
	-->
	<div class="content">
		<p>
			Principal<br>
			- 인증된 사용자 객체(Member 객체)<br>
			
			<sec:authentication property="principal" /><br>
		</p>
		<p>
			Credentials<br>
			- 인증에 필요한 "비밀번호"에 대한 정보를 가진 객체, 내부 인증작업 시에만 사용, 외부에 노출 X<br>
			
			<sec:authentication property="credentials"/><br>
		</p>
		<p>
			Authorities<br>
			- 인증된 사용자가 가진 권한목록들 => ROLE_USER, ROLE_ADMIN ...<br>
			
			<sec:authentication property="authorities"/>
		</p>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>