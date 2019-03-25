package Data.StudentData;

import java.util.List;

public interface StudentDAO {
	
	public Student getStudent(int idStudent);
	public void updateStudent(Student student); //edit infos
	public void deleteStudent(int id); //delete acc
	public void addStudent(Student student); //register student
	public void enrollStudent(int idS, int idC); //enroll student
	public StudentProfile getStudentProfile(int id);
	public void createStudentProfile(Student student);
	public int checkExists(String user, String pass);

}
