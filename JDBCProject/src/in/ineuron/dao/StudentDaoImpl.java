package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JDBCConnection;

public class StudentDaoImpl implements IStudentDao {

	Connection conn = null;
	@Override
	public String save(Student student) {
		
		PreparedStatement pstmt=null;
		String sqlInsertQuery= "insert into student(name, email, city, country) values(?,?,?,?)";
		String status=null;
		try {
			
			conn = JDBCConnection.getConnection();
			
			if(conn!=null) {
				pstmt = conn.prepareStatement(sqlInsertQuery);
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		
		Student student=new Student();
		PreparedStatement pstmt=null;
		String sqlSelectQuery= "select name, email, city, country from student where id =?";
		try {
			
			conn = JDBCConnection.getConnection();
			
			if(conn!=null) {
				pstmt = conn.prepareStatement(sqlSelectQuery);
				pstmt.setInt(1, sid);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					student.setName(rs.getString(1));
					student.setEmail(rs.getString(2));
					student.setCity(rs.getString(3));
					student.setCountry(rs.getString(4));
				}
			}
			
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		return student;
	}

	@Override
	public String updateById(Integer sid) {
		
		PreparedStatement pstmt=null;
		String sqlUpdateQuery= "update student set name='Ganesh' where id=?";
		String status=null;
		try {
			
			conn = JDBCConnection.getConnection();
			
			if(conn!=null) {
				pstmt = conn.prepareStatement(sqlUpdateQuery);
				pstmt.setInt(1, sid);
				
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
		
		
		
	
	}

	@Override
	public String deleteById(Integer sid) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt=null;
		String sqlDeleteQuery= "delete from student where id = ?";
		String status=null;
		try {
			
			conn = JDBCConnection.getConnection();
			
			if(conn!=null) {
				pstmt = conn.prepareStatement(sqlDeleteQuery);
				pstmt.setInt(1, sid);
				
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected==1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
		
		
	}

}
