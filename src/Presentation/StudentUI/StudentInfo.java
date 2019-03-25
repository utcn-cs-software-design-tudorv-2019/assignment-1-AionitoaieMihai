package Presentation.StudentUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.StudentValidation.StudentAccesValidation;
import Data.StudentData.Student;
import Presentation.AdminUI.AdminPanel;
import Presentation.EnrollUI.EnrollInfo;
import Presentation.EnrollUI.ViewEnrolled;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class StudentInfo extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField cnptextField_1;
	private JTextField adresatextField_2;
	private JTextField usertextField_3;
	
	Student student = new Student();
	StudentAccesValidation av = new StudentAccesValidation();
	int idS;

	public void populateFields(int id)
	{
		student = av.getStudent(id);
		
		idS = student.getStudentId();
		nametextField.setText(student.getNume());
		cnptextField_1.setText(student.getCnp());
		adresatextField_2.setText(student.getAdresa());
		usertextField_3.setText(student.getUserName());
	}
	
	void saveEdit()
	{
		student.setNume(nametextField.getText());
		student.setCnp(cnptextField_1.getText());
		student.setAdresa(adresatextField_2.getText());
		student.setUserName(usertextField_3.getText());
		
		av.editStudent(student);
	}

	public StudentInfo(boolean edit) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudent = new JLabel("Student:");
		lblStudent.setBounds(10, 11, 59, 14);
		contentPane.add(lblStudent);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(10, 36, 46, 14);
		contentPane.add(lblCnp);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(10, 61, 46, 14);
		contentPane.add(lblAdresa);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 86, 59, 14);
		contentPane.add(lblUsername);
		
		nametextField = new JTextField();
		nametextField.setBounds(94, 8, 86, 20);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		cnptextField_1 = new JTextField();
		cnptextField_1.setBounds(94, 33, 86, 20);
		contentPane.add(cnptextField_1);
		cnptextField_1.setColumns(10);
		
		adresatextField_2 = new JTextField();
		adresatextField_2.setBounds(94, 58, 86, 20);
		contentPane.add(adresatextField_2);
		adresatextField_2.setColumns(10);
		
		usertextField_3 = new JTextField();
		usertextField_3.setBounds(94, 83, 86, 20);
		contentPane.add(usertextField_3);
		usertextField_3.setColumns(10);
		
		
		nametextField.setEditable(false);
		cnptextField_1.setEditable(false);
		adresatextField_2.setEditable(false);
		usertextField_3.setEditable(false);
		
		if(edit)
		{
			nametextField.setEditable(true);
			cnptextField_1.setEditable(true);
			adresatextField_2.setEditable(true);
			usertextField_3.setEditable(true);
		}
		

		if(!edit)
		{
			
			JButton btnEdit = new JButton("Edit");
			btnEdit.setBounds(309, 27, 89, 23);
			contentPane.add(btnEdit);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					setVisible(false);
					StudentInfo frame = new StudentInfo(true);
					frame.populateFields(idS);
					frame.setVisible(true);
				}
			});
		}


		if(edit)
		{
			JButton btnSave = new JButton("Save");
			btnSave.setBounds(309, 57, 89, 23);
			contentPane.add(btnSave);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					saveEdit();
					setVisible(false);
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				}
			});
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setBounds(12, 147, 74, 23);
			contentPane.add(btnDelete);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					av.deleteStudent(idS);
					
					setVisible(false);
					setVisible(false);
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				}
			});
			
		}
	}
	
	public StudentInfo(boolean edit, int id) {
		
		idS = av.getStudentProfileId(id);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudent = new JLabel("Student:");
		lblStudent.setBounds(10, 11, 59, 14);
		contentPane.add(lblStudent);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(10, 36, 46, 14);
		contentPane.add(lblCnp);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(10, 61, 46, 14);
		contentPane.add(lblAdresa);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 86, 59, 14);
		contentPane.add(lblUsername);
		
		nametextField = new JTextField();
		nametextField.setBounds(94, 8, 86, 20);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		cnptextField_1 = new JTextField();
		cnptextField_1.setBounds(94, 33, 86, 20);
		contentPane.add(cnptextField_1);
		cnptextField_1.setColumns(10);
		
		adresatextField_2 = new JTextField();
		adresatextField_2.setBounds(94, 58, 86, 20);
		contentPane.add(adresatextField_2);
		adresatextField_2.setColumns(10);
		
		usertextField_3 = new JTextField();
		usertextField_3.setBounds(94, 83, 86, 20);
		contentPane.add(usertextField_3);
		usertextField_3.setColumns(10);
		
		
		nametextField.setEditable(false);
		cnptextField_1.setEditable(false);
		adresatextField_2.setEditable(false);
		usertextField_3.setEditable(false);
		
		if(edit)
		{
			nametextField.setEditable(true);
			cnptextField_1.setEditable(true);
			adresatextField_2.setEditable(true);
			usertextField_3.setEditable(true);
		}
		

		if(!edit)
		{
			if(idS != -1)
			{
				JButton btnViewEnrolled = new JButton("Enroll Courses");
				btnViewEnrolled.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						EnrollInfo ei = new EnrollInfo();
						ei.populateEnrollInfo(idS);
						ei.setVisible(true);
					}
				});
				btnViewEnrolled.setBounds(10, 184, 117, 40);
				contentPane.add(btnViewEnrolled);
				
				JButton btnEnroll = new JButton("Enrolled");
				btnEnroll.setBounds(159, 193, 89, 23);
				contentPane.add(btnEnroll);
				btnEnroll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						ViewEnrolled ve = new ViewEnrolled();
						if(ve.populateViewEnrolled(idS))
						{
							ve.setVisible(true);
						}
						
						else
						{
							setVisible(false);
							StudentInfo frame = new StudentInfo(false,idS);
							frame.populateFields(idS);
							frame.setVisible(true);
						}
					}
				});
				
			}
			
			JLabel warningMsg = new JLabel("Have a nice day");
			warningMsg.setBounds(10, 125, 388, 14);
			contentPane.add(warningMsg);
			
			if(idS == -1)
			{
				warningMsg.setText("Warning Student Profile not created!");
				
				JButton btnCreateStudProfile = new JButton("Create Stud Profile");
				btnCreateStudProfile.setBounds(275, 188, 123, 32);
				contentPane.add(btnCreateStudProfile);
				btnCreateStudProfile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Student s1 = av.getStudent(idS);
						av.createStudentProfile(s1);
						
						setVisible(false);
						StudentInfo frame = new StudentInfo(false,idS);
						frame.populateFields(idS);
						frame.setVisible(true);
						
					}
				});
			}
			
			JButton btnEdit = new JButton("Edit");
			btnEdit.setBounds(309, 27, 89, 23);
			contentPane.add(btnEdit);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					setVisible(false);
					StudentInfo frame = new StudentInfo(true,idS);
					frame.populateFields(idS);
					frame.setVisible(true);
				}
			});
		}


		if(edit)
		{
			System.out.println("student frame");
			JButton btnSave = new JButton("Save");
			btnSave.setBounds(309, 57, 89, 23);
			contentPane.add(btnSave);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					saveEdit();
					
					setVisible(false);
					StudentInfo frame = new StudentInfo(false,idS);
					frame.populateFields(idS);
					frame.setVisible(true);
				}
			});
		}
	}
}
