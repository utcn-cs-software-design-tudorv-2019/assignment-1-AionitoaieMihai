package Data.StudentData;

public class Student {
	
	private int studentId;
	private String nume;
	private String cnp;
	private String adresa;
	private String userName;
	private String password;
	
	public Student(int studentId,String nume,String cnp,String adresa,String userName,String password)
	{
		this.studentId = studentId;
		this.nume = nume;
		this.cnp = cnp;
		this.adresa = adresa;
		this.userName = userName;
		this.password = password;
	}
	
	public Student()
	{	
		this.studentId = -1;
	}
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString()
	{
		return "" + studentId + " " + nume + " " + cnp + " " + adresa + " " + userName + " " + password;
	}
	
	
}