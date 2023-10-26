package com.kh.client.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void clientStart() {
		// 1) 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트 소켓객체를 생성
		int port = 30027;
		String str = null;
		String serverIP = null;
		Socket socket = null;

		//serverIP = InetAddress.getLocalHost().getHostAddress();
		serverIP = "192.168.130.30";

		try {
			// 서버에 연결을 보내기(요청하고자 하는 서버의 IP주소와 포트번호를 동시에 제시해주면서 객체생성)
			socket = new Socket(serverIP, port);
			// 서버와 연결이 실패한다면 socket에는 null값이 반환될 것
			
			if(socket != null) { // 연결 성공
				// 2) 서버와의 입출력 스트림 오픈
				
				InputStream is = socket.getInputStream(); // 서버가 보낸 값을 입력받을 스트림
				OutputStream os = socket.getOutputStream(); // 서버로 값을 출력하는 스트림
				
				// 3) 성능개선
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				PrintWriter pw = new PrintWriter(os, true); 
				
				// 4) 스트림을 통해 읽고 쓰기
				Scanner sc = new Scanner(System.in);
				
				do {
					System.out.print("서버에 보낼 내용을 입력해주세요 : ");
					str = sc.nextLine();
					
					pw.println(str);
					
					if(str == null || "exit".equals(str)) {
						System.out.println("종료");
						break;
					}
					String message = br.readLine();
					System.out.println("받은 메세지 : " + message);
					
				}while(true);
				
				// 5) 통신 종료(스트림, 소켓 닫기)
				pw.close();
				br.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
