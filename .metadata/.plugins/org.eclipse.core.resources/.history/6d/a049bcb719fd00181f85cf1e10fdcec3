package db;

import java.sql.*;


public class ConnectionFactory {
	
	private static final String LocalHost			= "//localhost:";
	
	private static final String DriverOracle 		= "oracle.jdbc.driver.OracleDriver";
	private static final String DriverMYSQL 		= "com.mysql.jdbc.Driver";
	
	private static final String UrlOracleThin		= "jdbc:oracle:thin:@";
	private static final String	UrlMySql			= "jdbc:mysql:";
	
	private static final String AphroditeIpExtern	= "212.152.179.117:";
	private static final String AphroditeIP 		= "192.168.128.152:";
	private static final String AphroditeSID		= "ora11g";
	private static final String AphroditePort		= "1521:";
	private static final String AphroditeDBUser 	= "d4b11";
	private static final String AphroditeDBPwd  	= "d4b";

	private static final String MySQLDBUser 		= "pupil";
	private static final String MySQLDDPwd			= "Pupil!#1";
	private static final String MySQLPort			= "3306/";
	
	
	public static ConnectionFactory instance = new ConnectionFactory();

	private ConnectionFactory() {
		try {
			Class.forName(DriverOracle);
			Class.forName(DriverMYSQL);
		} catch(ClassNotFoundException ex) {
			System.err.println(ex);
		}
	}

	public static Connection get(String type, String user, String pwd) {
		Connection conn = null;

		try {
			switch (type) {
			case "oracle":
				conn = DriverManager.getConnection(UrlOracleThin + AphroditeIP + AphroditePort + AphroditeSID,user,pwd);
				
				if(conn == null)
					conn = DriverManager.getConnection(UrlOracleThin + AphroditeIpExtern + AphroditePort + AphroditeSID ,AphroditeDBUser,AphroditeDBPwd);
					
				break;
			case "mysql":
				conn = DriverManager.getConnection(UrlMySql + LocalHost + MySQLPort,user,pwd);
				break;
			default:
				//Standard Oracle Connection
				conn = DriverManager.getConnection(UrlOracleThin + AphroditeIP + AphroditePort + AphroditeSID ,AphroditeDBUser,AphroditeDBPwd);
				
				if(conn == null)
					conn = DriverManager.getConnection(UrlOracleThin + AphroditeIpExtern + AphroditePort + AphroditeSID ,AphroditeDBUser,AphroditeDBPwd);
				break;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
		return conn;
	}
	
	public static Connection get(Properties p) {
		Connection conn = null;

		try {
			switch (p.getDbType()) {
			case "oracle":
				Class.forName(p.getDbDriver());
				conn = DriverManager.getConnection(p.getDbUrl() + ":" + "@192.168.128.152:1521:ora11g",p.getDbUser(),p.getPassword());
				break;
			case "mysql":
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",p.getDbUser(),p.getPassword());
				break;
			default:
				//Standard Oracle Connection
				conn = DriverManager.getConnection("jdbc:oracle:thin@192.168.128.152:1521:ora11g",p.getDbUser(),p.getPassword());
				break;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
		return conn;
	}

	public static Connection get(String type) {
		Connection conn = null;

		try {
			switch (type) {
			case "oracle":
				conn = DriverManager.getConnection(UrlOracleThin + AphroditeIP + AphroditePort + AphroditeSID,AphroditeDBUser,AphroditeDBPwd);
				
				if(conn == null)
					conn = DriverManager.getConnection(UrlOracleThin + AphroditeIpExtern + AphroditePort + AphroditeSID ,AphroditeDBUser,AphroditeDBPwd);
				break;
			case "mysql":
				conn = DriverManager.getConnection(UrlMySql + LocalHost + MySQLPort,MySQLDBUser,MySQLDDPwd);
				break;
			default:
				//Standard Oracle Connection
				conn = DriverManager.getConnection(UrlOracleThin + AphroditeIP + AphroditePort + AphroditeSID ,AphroditeDBUser,AphroditeDBPwd);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return conn;
	}
	
	public static boolean close(Connection conn) {
		try {
			conn.close();
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean close(Statement stmt) {
		try {
			stmt.close();
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean close(ResultSet rs) {
		try {
			rs.close();
		} catch(Exception ex) {
			return false;
		}
		return true;
	}

}
