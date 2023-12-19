<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<h2>실시간 대기오염 정보</h2>

	지역 :
	<select id="location">
		<option>서울</option>
		<option>경기</option>
		<option>대구</option>
		<option>대전</option>
		<option>부산</option>
	</select>

	<button id="btn1">실시간 대기오염 정보 확인(json방식)</button>

	<button id="btn2">실시간 대기오염 정보 확인(xml방식)</button>

	<table id="result1" border="1" align="center">
		<thead>
			<tr>
				<th>측정소명</th>
				<th>측정시간</th>
				<th>통합대기환경수치</th>
				<th>미세먼지농도</th>
				<th>일산화탄소농도</th>
				<th>이산화탄소농도</th>
				<th>아황산가스농도</th>
				<th>오존농도</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>

	<script>
		$(() => {
			$("#btn1").click(() => {
				$("#result1>tbody").empty();
				$.ajax({
					url : 'air.do',
					data : {"location" : $("#location").val()},
					success : function(data) {
						console.log(data);
						for(let item of data.response.body.items) {
							$("#result1>tbody").append("<tr>"
															+ "<td>" + item.stationName +"</td>"
															+ "<td>" + item.dataTime +"</td>"
															+ "<td>" + item.khaiValue +"</td>"
															+ "<td>" + item.pm10Value +"</td>"
															+ "<td>" + item.coValue +"</td>"
															+ "<td>" + item.no2Value +"</td>"
															+ "<td>" + item.so2Value +"</td>"
															+ "<td>" + item.o3Value +"</td>"
														+"</tr>");
						}
					}
				})
			})
			
			
			
			$("#btn2").click(() => {
				$("#result1>tbody").empty();
				$.ajax({
					url:'air2.do',
					//data : {location : $("#location").val()},
					success : data => {
						console.log(data);
						
						// 1. 응답데이터 안에 데이터가 담겨있는 요소선택(item요소)
						let item = $(data).find("item");

						// 2. 반복문을 이용해서 데이터가 담긴 요소들에 접근 후 동적으로 요소 생성
						item.each((index, value) => { // each => jQuery함수
							$("#result1>tbody").append("<tr>"
														+ "<td>" + $(value).find("stationName").text() +"</td>"
														+ "<td>" + $(value).find("dataTime").text() +"</td>"
														+ "<td>" + $(value).find("khaiValue").text() +"</td>"
														+ "<td>" + $(value).find("pm10Value").text() +"</td>"
														+ "<td>" + $(value).find("coValue").text() +"</td>"
														+ "<td>" + $(value).find("no2Value").text() +"</td>"
														+ "<td>" + $(value).find("so2Value").text() +"</td>"
														+ "<td>" + $(value).find("o3Value").text() +"</td>"
													+"</tr>")
						})
					}
				})
			})
		})
	</script>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	<h2>서울시 노선 목록 조회</h2>

	<button id="btn3">노선 조회</button>

	<br>
	<br>

	<table id="result3" border="1">

		<thead>
			<tr>
				<th>노선 ID</th>
				<th>노선명</th>
				<th>노선 길이(Km)</th>
				<th>노선 기점</th>
				<th>노선 종점</th>
				<th>운수사명</th>
			</tr>
		</thead>
		<tbody>
				
		</tbody>

	</table>

	<script>
	
	$(function(){
	
		$("#btn3").click(function(){
		
			$.ajax({
				url:"busroute.do",
				success:function(data){
				
					const itemArr = data.msgBody.itemList;
					
					console.log(data);
					
					let value = "";
					
					for(let i in itemArr){
					
						console.log(itemArr[i]); //확인 후 주석
						
						let item = itemArr[i];
						
						// 화면에서 table tag안의 내용을 가져오는 코딩을 완성하시오
						
						$("#result3>tbody").append("<tr>"
														+ "<td>" + item.busRouteId +"</td>"
														+ "<td>" + item.busRouteNm +"</td>"
														+ "<td>" + item.length +"</td>"
														+ "<td>" + item.stStationNm +"</td>"
														+ "<td>" + item.edStationNm +"</td>"
														+ "<td>" + item.corpNm +"</td>"
													+"</tr>");
					}
				}
			})
		})
	})

	</script>


</body>
</html>