package Presentation.EnrollUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.CursValidation.CursValidation;
import Business.StudentValidation.StudentAccesValidation;
import Presentation.StudentUI.StudentInfo;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ViewEnrolled extends JFrame {

	private JPanel contentPane;
	CursValidation cv = new CursValidation();
	StudentAccesValidation av = new StudentAccesValidation();
	JComboBox comboCursuri;
	int idS = 0;
	JLabel Nota1,Nota2,Nota3;
	
	ArrayList<String> cursuri = new ArrayList<String>();
	ArrayList<String> note = new ArrayList<String>();
	
	public boolean populateViewEnrolled(int idS)
	{
		cursuri = cv.getCursuriFromStudent(idS);	
		this.idS = idS;
		
		if(cursuri.size() == 0)
		{
			return false;
		}
		
		else
		{
			for(int i = 0; i < cursuri.size(); i++)
			{
				comboCursuri.addItem(cursuri.get(i));
			}
			
			return true;
		}

	}
	
	public void changeData()
	{
		note = cv.getNote();
		int pos = cursuri.indexOf(comboCursuri.getSelectedItem().toString());
		Nota1.setText(note.get(pos*3));
		Nota2.setText(note.get(pos*3+1));
		Nota3.setText(note.get(pos*3+2));
	}
	
	public ViewEnrolled() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(10, 11, 46, 14);
		contentPane.add(lblStudent);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(66, 11, 130, 14);
		contentPane.add(lblNume);
		
		comboCursuri = new JComboBox();
		comboCursuri.setBounds(154, 36, 118, 22);
		contentPane.add(comboCursuri);
		comboCursuri.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					changeData();
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 147, 74, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				StudentInfo frame = new StudentInfo(false,idS);
				frame.populateFields(idS);
				frame.setVisible(true);
			}
		});
		
		
		JLabel Materie1 = new JLabel("Partial");
		Materie1.setBounds(137, 171, 46, 14);
		contentPane.add(Materie1);
		
		JLabel Materie2 = new JLabel("Colocviu");
		Materie2.setBounds(137, 196, 46, 14);
		contentPane.add(Materie2);
		
		JLabel Materie3 = new JLabel("Examen");
		Materie3.setBounds(137, 223, 46, 14);
		contentPane.add(Materie3);
		
		Nota1 = new JLabel("Nota1");
		Nota1.setBounds(226, 171, 46, 14);
		contentPane.add(Nota1);
		
		Nota2 = new JLabel("Nota2");
		Nota2.setBounds(226, 196, 46, 14);
		contentPane.add(Nota2);
		
		Nota3 = new JLabel("Nota3");
		Nota3.setBounds(226, 223, 46, 14);
		contentPane.add(Nota3);
	}

}
