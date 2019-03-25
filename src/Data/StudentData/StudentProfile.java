package Data.StudentData;

public class StudentProfile {
	
	private int idStudentProfile;
	private int grupa;
	
	public StudentProfile(int idStudentProfile,int grupa)
	{
		this.idStudentProfile = idStudentProfile;
		this.grupa = grupa;
	}
	
	public StudentProfile() {
		this.grupa = -1;
		this.idStudentProfile = -1;
	}

	public int getIdStudentProfile() {
		return idStudentProfile;
	}
	public void setIdStudentProfile(int idStudentProfile) {
		this.idStudentProfile = idStudentProfile;
	}
	public int getGrupa() {
		return grupa;
	}
	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}
	

}
