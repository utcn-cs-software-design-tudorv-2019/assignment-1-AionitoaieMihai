package Business.CursValidation;

import java.util.ArrayList;
import java.util.List;

import Data.CursData.CursDAO;

public class CursValidation {
	
	CursDAO cd = new CursDAO();
	ArrayList<String> cursuri = new ArrayList<String>();
	
	public ArrayList<String> getCursuri()
	{
		return cd.getCursuri();
	}
	
	public ArrayList<String> getCursuriFromStudent(int idS)
	{
		return cd.getCursuriFromStudent(idS);
	}
	
	public ArrayList<String> getNote()
	{
		return cd.getNoteExamene();
	}
	
	public int getCursId(String nume)
	{
		return cd.getCursId(nume);
	}
	
	public ArrayList<String> getOreCursuri()
	{
		return cd.getOreCursuri();
	}

}
