package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "sampleid";
    private static final String PW = "samplepw";

	public MemberDAO() {
		try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	public void checkId(String id) {
		System.out.println("SQL 시작");
//		String sql = "select * from MEMBER";
		//String sql = "insert into member VALUES(0,'testid','testpassword','f','18','123','test@com,test','test')";
		String sql = "select * from TAB";
        try {
            con = DriverManager.getConnection(URL, USER, PW);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            int row = rs.getRow();
            System.out.println(row);
            System.out.println("SQL 가져오기");
            while (rs.next()) {
            	rs.toString();
            	//System.out.print(rs.getString("ID_NO") + " ");
                //System.out.print(rs.getString("ID") + " ");
                //System.out.print(rs.getString("PASSWORD") + " ");
            }
            System.out.println("SQL 찍기완료");
        } catch (SQLException e) {
        	System.out.println(e);
            e.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
	}
	
	public void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }
}
