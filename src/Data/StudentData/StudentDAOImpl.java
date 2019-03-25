package Data.StudentData;

import java.sql.*;
import java.util.Random;

public class StudentDAOImpl implements StudentDAO{
	
	Connection myConn;
	PreparedStatement stmt;
	ResultSet rs;

	public StudentDAOImpl()
	{
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Student getStudent(int idStudent) {
		
		Student s = new Student();
		
		String query = "select * from student where idStudent = " + idStudent;
		
		try {
			stmt = myConn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			int i = 0;
			
			while(rs.next())
			{
				s.setStudentId(Integer.parseInt(rs.getString("idstudent")));
				s.setNume(rs.getString("nume"));
				s.setCnp(rs.getString("cnp"));
				s.setAdresa(rs.getString("adresa"));
				s.setUserName(rs.getString("username"));
				s.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		return s;
	}

	@Override
	public void updateStudent(Student student) {
		
		try {
			stmt = myConn.prepareStatement("update student set nume = ?, cnp = ?, adresa = ?, userName = ? where idStudent = ?");
			stmt.setString(1,student.getNume());
			stmt.setString(2,student.getCnp());
			stmt.setString(3,student.getAdresa());
			stmt.setString(4,student.getUserName());
			stmt.setString(5, "" + student.getStudentId());
			stmt.executeUpdate();
			
			System.out.println("updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteStudent(int id) {
		
		try {
			
			int idS = getStudentProfile(id).getIdStudentProfile();
			
			stmt = myConn.prepareStatement("delete from StudentProfile_has_Curs where idStudentProfile = ?");
			stmt.setString(1, "" + idS);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("delete from StudentProfile where idStudentProfile = ?");
			stmt.setString(1, "" + idS);
			stmt.executeUpdate();
			
			stmt = myConn.prepareStatement("delete from student where idStudent = ?");
			stmt.setString(1,"" + id);
			stmt.executeUpdate();
			
			System.out.println("student deleted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void addStudent(Student student) {
		
		try {
			
			int i = 0;
			stmt = myConn.prepareStatement("SELECT MAX(idstudent) FROM student");
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				i = rs.getInt("MAX(idstudent)");
			}
			
			stmt = myConn.prepareStatement("insert into student values (?,?,?,?,?,?)");
			stmt.setString(1, ""+ (i + 1));
			stmt.setString(2, student.getNume());
			stmt.setString(3, student.getCnp());
			stmt.setString(4, student.getAdresa());
			stmt.setString(5, student.getUserName());
			stmt.setString(6, student.getPassword());
			stmt.executeUpdate();
			
			System.out.println("Student added ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void enrollStudent(int idS, int idC) {
		
		StudentProfile sp = getStudentProfile(idS);
		Random r = new Random();
		int low = 5;
		int high = 10;
		int result = r.nextInt(high-low) + low;
		
		try {
			stmt = myConn.prepareStatement("insert into StudentProfile_has_Curs values (?,?,?,?,?)");
		
			stmt.setString(1, "" + sp.getIdStudentProfile());
			stmt.setString(2, "" + idC);
			stmt.setString(3, "" + result);
			result = r.nextInt(high-low) + low;
			stmt.setString(4, "" + result);
			result = r.nextInt(high-low) + low;
			stmt.setString(5,"" + result);
			
			stmt.executeUpdate();
			
			System.out.println("enrolled");
			
		} catch (SQLException e) {
			System.out.println("already exists");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public StudentProfile getStudentProfile(int id) {
		
		StudentProfile sp = new StudentProfile();
		
		try {
			stmt = myConn.prepareStatement("select * from StudentProfile where student_idstudent = ?");
		
			stmt.setString(1, "" + id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) 
			{
				//System.out.println(rs.getString("idStudentProfile"));
				//System.out.println(rs.getString("grupa"));
				
				sp = new StudentProfile((Integer.parseInt(rs.getString("idStudentProfile"))),Integer.parseInt(rs.getString("grupa")));
				
				//sp.setIdStudentProfile(Integer.parseInt(rs.getString("idStudentProfile")));
				//sp.setGrupa(Integer.parseInt(rs.getString("grupa")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sp;
	}
	
	public void createStudentProfile(Student student)
	{
		try {
			
			int i = 0;
			stmt = myConn.prepareStatement("SELECT MAX(idStudentProfile) FROM StudentProfile");
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				i = rs.getInt("MAX(idStudentProfile)");
			}
			
			Random r = new Random();
			int low = 1;
			int high = 5;
			int result = r.nextInt(high-low) + low;
			
			stmt = myConn.prepareStatement("insert into StudentProfile values (?,?,?)");
		
			stmt.setString(1,"" + (i+1));
			stmt.setString(2,"" + result);
			stmt.setString(3, "" + student.getStudentId());
			
			stmt.executeUpdate();
			
			System.out.println("Student profile created");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int checkExists(String user, String pass)
	{
		try {
			stmt = myConn.prepareStatement("select * from student where userName = ? AND password = ?");
			stmt.setString(1, user);
			stmt.setString(2, pass);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				return Integer.parseInt(rs.getString("idStudent"));
			
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
		
	}

	public int getStudentProfileId(int idS)
	{
		StudentProfile s = getStudentProfile(idS);
		
		if(s.getIdStudentProfile() == -1)
			return -1;
		else
			return s.getIdStudentProfile();
	}
}
