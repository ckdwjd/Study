package com.kh.opendata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	public static final String serviceKey = "g1shMfZHZ4Qd5WUNV68bA6Ap0fyKMk9KvPNilRsdozLCNI2jMEgGAmYP97DVkwedpNxcNP57BUfZdcCRkk9vOw%3D%3D";
	
	// json으로 활용
	@RequestMapping(value="air.do", produces = "application/json; charset=UTF-8")
	public String airPollution(String location) throws IOException {
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + serviceKey;
		url += "&returnType=json";
		url += "&numOfRows=50"; // 반환받는 결과값 갯수
		url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8");
		
		
		// 1. 요청하고자 하는 url주소를 매개변수로 전달하면서 객체 생성
		URL requestUrl = new URL(url); 
				
		
		// 2. 생성된 URL객체를 가지고 HttpURLConection 객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		
		
		// 3. 요청 방식 설정
		urlConnection.setRequestMethod("GET");
		
		
		// 4. 요청주소에 적힌 OpenAPI서버로 요청을 보낸 후 "스트림"을 활용하여 응답데이터 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		
		// 5. 반복적으로 응답데이터 읽어들이기
		String responseTest = "";
		String line;
		
		while((line = br.readLine()) != null) {
			responseTest += line;
		}
		
		System.out.println(responseTest);
		
		br.close();
		urlConnection.disconnect();
		
		
		// 응답데이터를 보내주고자 한다면 문자열값 그대로 넘겨주면 알아서 JSON형태로 응답됨
		return responseTest;
	}

	
	
	// XML 형식으로 활용
	@RequestMapping(value="air2.do", produces = "text/xml; charset=UTF-8")
	public String airPollution2() throws IOException {
		
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		url += "?serviceKey=" + serviceKey;
		url += "&returnType=xml";
		url += "&numOfRows=2"; // 반환받는 결과값 갯수
//		url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8");
		
		
		// 1. 요청하고자 하는 url주소를 매개변수로 전달하면서 객체 생성
		URL requestUrl = new URL(url); 
				
		
		// 2. 생성된 URL객체를 가지고 HttpURLConection 객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		
		
		// 3. 요청 방식 설정
		urlConnection.setRequestMethod("GET");
		
		
		// 4. 요청주소에 적힌 OpenAPI서버로 요청을 보낸 후 "스트림"을 활용하여 응답데이터 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		
		// 5. 반복적으로 응답데이터 읽어들이기
		String responseTest = "";
		String line;
		
		while((line = br.readLine()) != null) {
			responseTest += line;
		}
		
		System.out.println(responseTest);
		
		br.close();
		urlConnection.disconnect();
		
		
		// 응답데이터를 보내주고자 한다면 문자열값 그대로 넘겨주면 알아서 JSON형태로 응답됨
		return responseTest;
	}
	
	@ResponseBody
	@RequestMapping(value="busroute.do", produces = "application/json; charset=UTF-8")
	public String busRoute() throws IOException {
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
		url += "?serviceKey=" + serviceKey;
		url += "&strSrch=3";
		url += "&returnType=json";
		
		URL requestUrl = new URL(url); 
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		
		String responseTest = "";
		String line;
		
		while((line = br.readLine()) != null) {
			responseTest += line;
		}
		
		System.out.println(responseTest);
		
		br.close();
		urlConnection.disconnect();
		return responseTest;
	}
	
	
}
