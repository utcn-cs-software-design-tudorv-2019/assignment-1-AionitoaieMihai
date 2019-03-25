package Business.StudentValidation;

import Data.StudentData.Student;
import Data.StudentData.StudentDAOImpl;

public class StudentAccesValidation {
	
	StudentDAOImpl studentData = new StudentDAOImpl();
	
	public int grantAcces(String user, String password)
	{
		return studentData.checkExists(user, password);
	}
	
	public Student getStudent(int id)
	{
		return studentData.getStudent(id);
	}
	
	public void editStudent(Student s)
	{
		studentData.updateStudent(s);
	}
	
	public void enrollStudent(int idS, int idCurs)
	{
		studentData.enrollStudent(idS, idCurs);
	}

	public void createStudentProfile(Student s)
	{
		studentData.createStudentProfile(s);
	}
	
	public void registerStudent(Student s)
	{
		studentData.addStudent(s);
	}
	
	public int getStudentProfileId(int idS)
	{
		return studentData.getStudentProfileId(idS);
	}
	
	public void deleteStudent(int idS)
	{
		studentData.deleteStudent(idS);
	}
	
}
