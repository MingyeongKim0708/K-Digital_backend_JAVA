package 회원정보;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO { // member 테이블에 crud를 하고 싶으면 MemberDAO를 사용하면 됨.
	// DAO = DB Access Object
	// shop DB member table에 접근해서 처리하는 객체
	
	public void insert(String id, String pw, String name, String tel) {
		// Java-DB 연결 (JDBC) 4단계

		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		// 외부자원연결(db,network,cpu,file,...)
		// 상황이 발생했을 때 어떻게 대처할지를 반드시 써주어야 함. try-catch
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지.대표클래스
			System.out.println("1. 커넥터 연결 성공!!");

			// 2. 1번 설정을 커넥터로 db연결하고 승인
			// 1) url - ip + port+ db명
			// 2) id, pw
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db 연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into member values (?, ?, ?, ?)";
			// String site = "http://www.naver.com";
			// 해당 부품으로 만들어주어야 한다.
			// sql ==> PreparedStatement
			// site ==> URL
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 첫번째 물음표에 id 넣기
			ps.setString(2, pw); // 두번째 물음표에 pw 넣기
			ps.setString(3, name); // 세번째 물음표에 name 넣기
			ps.setString(4, tel); // 네번째 물음표에 tel 넣기
			System.out.println("3. sql문 생성 성공!!");

			// 4. 3번에서 생성된 sql문을 mySQL로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // 모든 에러를 catch 함 Exception == Error
			e.printStackTrace();
			System.out.println("에러발생");
		}

	}
	
	// delete
	public void delete(String id) {
		// Java-DB 연결 (JDBC) 4단계

		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		// 외부자원연결(db,network,cpu,file,...)
		// 상황이 발생했을 때 어떻게 대처할지를 반드시 써주어야 함. try-catch
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지.대표클래스
			System.out.println("1. 커넥터 연결 성공!!");

			// 2. 1번 설정을 커넷터로 db연결하고 승인
			// 1) url - ip + port+ db명
			// 2) id, pw
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db 연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "delete from member where id = ?";
			// 해당 부품으로 만들어주어야 한다.
			// sql ==> PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 첫번째 물음표에 id 넣기
			System.out.println("3. sql문 생성 성공!!");

			// 4. 3번에서 생성된 sql문을 mySQL로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // 모든 에러를 catch 함 Exception == Error
			e.printStackTrace();
			System.out.println("에러발생");
		}

	}
	
	// update
	public void update(String id, String tel) {
		// Java-DB 연결 (JDBC) 4단계

		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		// 외부자원연결(db,network,cpu,file,...)
		// 상황이 발생했을 때 어떻게 대처할지를 반드시 써주어야 함. try-catch
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지.대표클래스
			System.out.println("1. 커넥터 연결 성공!!");

			// 2. 1번 설정을 커넷터로 db연결하고 승인
			// 1) url - ip + port+ db명
			// 2) id, pw
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db 연결 성공!!");

			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update member set tel = ? where id = ?";
			// 해당 부품으로 만들어주어야 한다.
			// sql ==> PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel); // 첫번째 물음표에 id 넣기
			ps.setString(2, id); // 두번째 물음표에 tel 넣기
			System.out.println("3. sql문 생성 성공!!");

			// 4. 3번에서 생성된 sql문을 mySQL로 전송
			ps.execute();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");

		} catch (Exception e) { // 모든 에러를 catch 함 Exception == Error
			e.printStackTrace();
			System.out.println("에러발생");
		}

	}

}
