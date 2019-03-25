package Presentation.StudentUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.StudentValidation.StudentAccesValidation;
import Data.StudentData.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
	private JTextField cnpField;
	private JTextField adresaField;
	private JTextField numeField;
	
	StudentAccesValidation av = new StudentAccesValidation();

	public void registerStudent()
	{
		Student s = new Student();
		s.setUserName(userField.getText());
		s.setPassword(passField.getText());
		s.setCnp(cnpField.getText());
		s.setAdresa(adresaField.getText());
		s.setNume(numeField.getText());
		
		
		av.registerStudent(s);
	}
	
	
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(22, 11, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 36, 57, 14);
		contentPane.add(lblPassword);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(22, 66, 46, 14);
		contentPane.add(lblCnp);
		
		JLabel lblAdresa = new JLabel("adresa");
		lblAdresa.setBounds(22, 91, 46, 14);
		contentPane.add(lblAdresa);
		
		JLabel lblNume = new JLabel("nume");
		lblNume.setBounds(22, 116, 46, 14);
		contentPane.add(lblNume);
		
		userField = new JTextField();
		userField.setBounds(89, 8, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(89, 33, 86, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		
		cnpField = new JTextField();
		cnpField.setBounds(89, 63, 86, 20);
		contentPane.add(cnpField);
		cnpField.setColumns(10);
		
		adresaField = new JTextField();
		adresaField.setBounds(89, 88, 86, 20);
		contentPane.add(adresaField);
		adresaField.setColumns(10);
		
		numeField = new JTextField();
		numeField.setBounds(89, 113, 86, 20);
		contentPane.add(numeField);
		numeField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(244, 136, 89, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				registerStudent();
			}
		});
	}

}
