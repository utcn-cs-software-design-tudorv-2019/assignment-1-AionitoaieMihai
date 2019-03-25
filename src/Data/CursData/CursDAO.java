package Data.CursData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursDAO {
	
	Connection myConn;
	PreparedStatement stmt;
	ResultSet rs;
	
	ArrayList<String> cursuri = new ArrayList<String>();
	ArrayList<String> note = new ArrayList<String>();
	ArrayList<String> ore = new ArrayList<>();
	
	public CursDAO()
	{
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getCursuri()
	{
		try {
			int maxId = 0;
			stmt = myConn.prepareStatement("select nume from Curs");
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
					cursuri.add(rs.getString("nume"));
			}
			
		}catch(Exception e){}

		return cursuri;
	}

	public int getCursId(String nume)
	{
		try {
			Curs curs = new Curs();
			
			stmt = myConn.prepareStatement("select * from Curs where nume = ?");
			stmt.setString(1, nume);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				return Integer.parseInt(rs.getString("idCurs"));
			}
			
		}catch(Exception e){}
		
		return 0;
		
	}

	public ArrayList<String> getCursuriFromStudent(int idS)
	{
		try {
			stmt = myConn.prepareStatement("select idStudent, Curs.nume, notaPartial, notaColocviu, notaExamen, startTime, endTime, year, semester from student\r\n" + 
					"inner join StudentProfile ON student.idstudent = StudentProfile.student_idstudent\r\n" + 
					"inner join StudentProfile_has_Curs ON StudentProfile.idStudentProfile = StudentProfile_has_Curs.idStudentProfile\r\n" + 
					"inner join Curs ON StudentProfile_has_Curs.idCurs = Curs.idCurs where idstudent = ?");
			stmt.setString(1,"" + idS);
			
			rs = stmt.executeQuery();
			
			cursuri.removeAll(cursuri);
			
			while(rs.next())
			{
				cursuri.add(rs.getString("nume"));
				note.add(rs.getString("notaPartial"));
				note.add(rs.getString("notaColocviu"));
				note.add(rs.getString("notaExamen"));
				ore.add(rs.getString("startTime"));
				ore.add(rs.getString("endTime"));
				ore.add(rs.getString("year"));
				ore.add(rs.getString("semester"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cursuri;
	}

	public ArrayList<String> getNoteExamene()
	{
		return note;
	}

	public ArrayList<String> getOreCursuri()
	{
		return ore;
	}
}
