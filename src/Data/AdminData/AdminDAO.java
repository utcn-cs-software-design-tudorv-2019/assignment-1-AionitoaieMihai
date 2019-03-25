package Data.AdminData;

import java.util.List;

import Data.StudentData.Student;
import Data.StudentData.StudentProfile;

public interface AdminDAO {

	public List<Student> getAllStudents();
	public Student getStudent(int idStudent);
	public void updateStudent(Student student); //edit infos
	public void deleteStudent(Student student); //delete acc
	public void addStudent(Student student); //register student
	public StudentProfile getStudentProfile(Student student);
		
}
