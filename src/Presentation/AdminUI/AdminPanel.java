package Presentation.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.StudentValidation.StudentAccesValidation;
import Presentation.StudentUI.AddStudent;
import Presentation.StudentUI.StudentInfo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	StudentAccesValidation av = new StudentAccesValidation();
	
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(10, 11, 46, 14);
		contentPane.add(lblAdmin);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(104, 48, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(163, 45, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGenRaport = new JButton("Generate Raport");
		btnGenRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportFrame rf = new RaportFrame();
				rf.setVisible(true);
				setVisible(false);
			}
		});
		btnGenRaport.setBounds(10, 138, 140, 23);
		contentPane.add(btnGenRaport);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(160, 138, 89, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				int id = av.getStudent(Integer.parseInt(textField.getText())).getStudentId();
				
				if(id != -1)
				{
					StudentInfo frame = new StudentInfo(false);
					frame.populateFields(id);
					frame.setVisible(true);
				}
				
				else
				{
					setVisible(false);
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				}

			}
		});
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(282, 138, 118, 23);
		contentPane.add(btnAddStudent);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddStudent().setVisible(true);
			}
		});
		
	}

}
