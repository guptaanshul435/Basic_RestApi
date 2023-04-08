package Ms.India.demoRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositry {
	
	
	static Connection conn;
	Statement stmt;
     PreparedStatement pstmt;
	ResultSet rs;
	int result;

	List<Student> list;
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/DemoRest", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public int postStudent(Student s1) {
		try {
			String query="insert into student values(?,?)";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, s1.course);
			pstmt.setString(2, s1.stuName);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	
	public List<Student> getStudends() {
		
		String query="select * from student";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			list=new ArrayList<Student>();
			rs.next();
            while(rs.next()) {
            	Student stu=new Student(rs.getString(1),rs.getString(2));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
}
