package studyonline.bean_life_cycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//This will connect to DB and performs various actions
//StudentDAO -> StudentDataAccessObject
public class StudentDAO {
	private String url;
	private String userName;
	private String password;

	private Connection conn;

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void createConnectionToStudentTable() {
		try {
			System.out.println("Establishing the connection..");
			// Establish the connection URL,Username,Password
			this.conn = DriverManager.getConnection(this.url, this.userName, this.password);
			System.out.println("Connection Established.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void closeConnection() {
		try {
			System.out.println("Closing the connection....");
			this.conn.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void getAllStudents() {
		try {

			// Create a statement
			Statement statement = conn.createStatement();
			// Execute the query
			ResultSet res = statement.executeQuery("select * from student");
			// process the resultset
			while (res.next()) {
				System.out.println(
						res.getString("id") + " " + res.getString("first_name") + " " + res.getString("last_name"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getSpecificStudent(int id) {
		try {

			// Create a Prepared statement
			String query = "select * from student where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			// Execute the query
			ResultSet res = pstmt.executeQuery();

			// process the resultset
			while (res.next()) {
				System.out.println(res.getString("first_name") + " " + res.getString("last_name"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
