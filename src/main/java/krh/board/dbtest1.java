package krh.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbtest1 {
public static void main(String[] args) {
		
		//드라이버 검색 (db와 연동 준비)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("success");
		} catch (ClassNotFoundException e) {
			System.err.println("fail");
			System.exit(0);
		}
		
		//데이터베이스 연결 - 커넥션 만들기 
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl"
					,"sampleid", "samplepw"
					);
			System.out.println("success");
		} catch (SQLException e) {
			System.err.println("fail");
			System.exit(0);
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}