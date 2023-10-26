package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

/*
 * DAO(Data Access Object)
 * Controller를 통해서 호출
 * Controller에서 요청 받은 실질적인 기능을 수행하기 위해서
 * DB에 직접적으로 접근(Access) 후 해당 SQL문을 실행하고 결과를 돌려받기 => JDBC
 * 
 */

public class MemberDao {

	/*
	 *  * JDBC용 객체
	 *  - Connection : DB의 연결정보를 담고 있는 객체(IP주소, PORT 번호, 계정명, 비밀번호)
	 *  - (Prepared)Statement : 해당 DB에 SQL문을 전달하고 실행한 후 결과를 받아내는 객체
	 *  - ResultSet : 실행한 SQL문이 SELECT문일 경우 조회된 결과들이 담겨있는 객체
	 *  
	 *  
	 *  * JDBC 순서
	 *  1) JDBC Driver 등록 : 해당 DBMS가 제공하는 클래스 등록
	 *  
	 *  2) Connection 생성 : 접속하고자 하는 DB정보를 입력해서 DB에 접속하면서 생성
	 *  
	 *  3) Statement 생성 : Connection 객체를 이용해서 생성
	 *  
	 *  4) SQL문을 전달하면서 실행 : Statement객체를 이용해서 SQL문 실행
	 *  	> SELECT문일 경우 - executeQuery(sql) 메서드 사용
	 *  	> 나머지 DML문일 경우 - executeUpdate(sql) 메서드 사용
	 *  
	 *  5) 결과값 받기
	 *  	> SELECT 문일 경우 - ResultSet 객체로 받기(조회된 데이터들이 담겨있음) => 6-1)
	 *  	> 나머지 DML문일 경우 - int형 변수로 받기(처리된 행의 갯수가 담겨있음) => 6-2)
	 *  
	 *  6-1) ResultSet 객체에 담긴 데이터들을 하나씩 뽑아서 VO객체에 담기
	 *  	(반환된 데이터가 여러개일 경우 ArrayList로 묶어서 관리)
	 *  6-2) 트랜잭션 처리(성공 시 == 반환된 행의 갯수가 0이 아니라면 COMMIT;, 실패 시 ROLLBACK;)
	 *  
	 *  7) 다쓴 JDBC용 객체들을 반드시 자원반납(close) => 생성된 순서의 역순으로 닫기
	 *  
	 *  8) 결과값을 Controller로 반환
	 *  	> SELECT문일 경우 6-1)에서 만들어진 결과
	 *  	> 기타 DML문일 경우 - int형 값(처리된 행의 갯수)
	 *  
	 *  
	 *  * Statement 특징 : 완성된 SQL문을 실행할 수 있는 객체
	 *  
	 */
	
	
	
	/**
	 * 사용자가 회원 추가 요청 시 입력했던 값을 가지고 INSERT문을 실행하는 메서드
	 * @param m : 사용자가 입력했던 아이디 ~ 취미 값이 담겨있는 Member
	 * @return : INSERT문을 실행한 결과 처리된 행의 갯수
	 */
	public int insertMember(Member m) { // INSERT문 => 처리된 행의 갯수를 반환, 트랜잭션 처리
		
		// 0) 필요한 변수들 셋팅
		int result = 0; // 처리된 결과를 담아줄 변수
		Connection conn = null; // 접속된 DB의 연결정보를 담는 변수
		Statement stmt = null; // SQL문을 실행시킨 후 결과를 받기위한 변수
		
		// + 필요한 변수 : 실행할 SQL문(완성된 형태로 준비)
		// 				끝에 세미콜린(;)이 있으면 안됨
		/*
		 * INSERT INTO MEMBER
		 * VALUES(SEQ_USERNO.NEXTVAL, 'XXX','XXX','XXX',X,'X' ... , DEFUALT);
		 */
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,"
				+ "'" + m.getUserId() + "' ,"
				+ "'" + m.getUserPwd() + "' ,"
				+ "'" + m.getUserName() + "' ,"
				+ "'" + m.getGender() + "' ,"
					  + m.getAge() + " ,"
			    + "'" + m.getEmail() + "' ,"
			    + "'" + m.getPhone() + "' ,"
			    + "'" + m.getAddress() + "' ,"
			    + "'" + m.getHobby() + "' ,"
				+ "DEFAULT)";
		
		try {
			
			// 1) JDBC 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성( == DB와 연결 --> URL, 계정, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"JDBC","JDBC");
			conn.setAutoCommit(false);
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4,5) DB에 완성된 SQL문을 전달하면서 실행 후 결과 받기
			result = stmt.executeUpdate(sql);
			
			// 6-2) 트랜잭션 처리
			if(result > 0) { // 1개 이상의 행이 INSERT 됨 == 성공 == COMMIT
				conn.commit();
			} else { // 실패 시
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// 7) 다 쓴 JDBC용 객체 자원 반납 => 생성된 순서의 역순으로 CLOSE() 호출
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 8) 결과값 controller 반환
		return result;
	}

	/**
	 * 사용자가 회원 전체 요청 시 SELECT문을 실행해주는 메서드
	 * @return
	 */
	public ArrayList<Member> selectAll() { // SELECT => ResultSet형태 => ArrayList반환
		
		// 0) 필요변수 셋팅
		// 조회된 결과를 뽑아서 담아줄 변수 => ArrayList생성(여러 회원의 정보, 여러행)
		ArrayList<Member> list = new ArrayList(); // 빈 리스트
		
		// Connection, Statement, ResultSet => finally블록에서 자원 반납하기 위해
		//									   try블럭 밖에서 선언
		
		Connection conn = null; // 접속된 DB에 연결정보를 담는 변수
		Statement stmt = null; // SQL문 실행 후 결과값 돌려받기 위한 변수
		ResultSet rset = null; // SELECT문이 실행된 조회결과 값들이 처음에 담길 객체
		
		String sql = "SELECT * FROM MEMBER";
	
		try {
			// 1) JDBC 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성( == DB와 연결 --> URL, 계정, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"JDBC","JDBC");
			conn.setAutoCommit(false);
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4,5) SQL문(SELECT)를 전달해서 실행 후 결과 받기
			rset = stmt.executeQuery(sql);
			
			// 6-1) 현재 조회결과가 담긴 ResultSet에서 한 행씩 뽑아서 VO객체에 담기
			// rset.next() : 커서를 한 줄 아래로 옮겨주고 해당 행이 존재할 경우 true, 없으면 false 반환
			while(rset.next()) {
				
				// 현재 rset의 커서가 가리키고 있는 해당 행의 데이터를 하나씩 뽑아서 VO객체에 담기
				Member m = new Member();
				
				// rset으로 부터 어떤 컬럼에 해당하는 값을 뽑을건지 제시
				// => 컬럼명(대소문자 가리지 않음), 컬럼 순번
				// 	  권장사항 : 컬럼명 + 대문자로 쓰는 것을 권장
				// rset.getInt(컬럼명 또는 순번) : int형으로 값을 뽑아올 때
				// rset.getString(컬럼명 또는 순번) : String형으로 뽑아올 때
				// rset.getDate(컬럼명 또는 순번) : Date형 값을 뽑을 때
				
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				/*
				 * 한 행에 대한 모든 컬럼에 있는 값들을 Member VO객체의 각 필드에 담기
				 * 
				 * 초기화시킨 VO객체를 list에 담기
				 */
				
				list.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// 7) 다 쓴 JDBC용 객체 반납(생성의 역순)
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 8) 결과값 controller 반환
		return list;
	}
	
	public Member selectByUserId(String userId) {
		
		// SELECT => ResultSet => Member(1개의 행, 반복 X)
		
		// 0) 필요한 변수 셋팅
		// 조회된 회원에 대한 정보를 담을 변수
		Member m = null;
		
		// JDBC관련 객체
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		// 실행할 SQL문
		String sql = "SELECT * FROM MEMBER WHERE USERID = " + "'" + userId + "'"; 
		
		
			try {
				// 1) JDBC 드라이버 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// 2) Connection 객체 생성( == DB와 연결 --> URL, 계정, 비밀번호)
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						"JDBC","JDBC");
				conn.setAutoCommit(false);
				
				// 3) Statement 객체 생성
				stmt = conn.createStatement();
				
				// 4,5) SQL문(SELECT)를 전달해서 실행 후 결과 받기
				rset = stmt.executeQuery(sql);
				
				// 6-1) 현재 조회결과가 담긴 ResultSet에서 한 행만 뽑아서 VO객체에 담기
				// 	    => ID검색은 한 행만 조회될 것이기 때문
				if(rset.next()) {
					
					// 커서를 한 행 움직여보고 조회결과가 있다면 true/없다면 false
					m = new Member();
					
					m.setUserNo(rset.getInt("USERNO"));
					m.setUserId(rset.getString("USERID"));
					m.setUserPwd(rset.getString("USERPWD"));
					m.setUserName(rset.getString("USERNAME"));
					m.setGender(rset.getString("GENDER"));
					m.setAge(rset.getInt("AGE"));
					m.setEmail(rset.getString("EMAIL"));
					m.setPhone(rset.getString("PHONE"));
					m.setAddress(rset.getString("ADDRESS"));
					m.setHobby(rset.getString("HOBBY"));
					m.setEnrollDate(rset.getDate("ENROLLDATE"));
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rset.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		// 8) 결과값 반환
		return m;
	}
	
	
	public ArrayList<Member> selectByUserName(String keyword) {
		
		ArrayList<Member> list = new ArrayList();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE " + "'%" + keyword + "%'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"JDBC","JDBC");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				
				Member m = new Member();
				
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int updateMember(Member m) {
		
		
		// UPDATE문 실행 => 처리된 행의 갯수(INT) => DML호출 시 트랜잭션 필수
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "UPDATE MEMBER SET "
				+ "USERPWD = '" + m.getUserPwd() + "',"
				+ "EMAIL = '" + m.getEmail() + "',"
				+ "PHONE = '" + m.getPhone() + "',"
				+ "ADDRESS = '" + m.getAddress() + "'"
				+ "WHERE USERID = " + "'" + m.getUserId() + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"JDBC","JDBC");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) { 
				conn.commit();
			} else { 
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMember(Member m) {
		
		// DELETE문 => 처리된 행의 갯수 => 트랜잭션
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE"
				+" USERID = " + "'" + m.getUserId() + "'"
				+" AND USERPWD = " + "'" + m.getUserPwd() + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"JDBC","JDBC");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) { 
				conn.commit();
			} else { 
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
