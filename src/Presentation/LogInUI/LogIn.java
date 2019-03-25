package Presentation.LogInUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.StudentValidation.StudentAccesValidation;
import Presentation.AdminUI.AdminPanel;
import Presentation.StudentUI.AddStudent;
import Presentation.StudentUI.StudentInfo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JTextField passField;
	StudentAccesValidation av = new StudentAccesValidation();
	int admin = 0;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(112, 91, 65, 19);
		contentPane.add(lblUsername);
		
		userNameField = new JTextField();
		userNameField.setBounds(182, 90, 86, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(112, 121, 65, 19);
		contentPane.add(lblPassword);
		
		passField = new JTextField();
		passField.setBounds(182, 121, 86, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setBounds(167, 188, 89, 23);
		contentPane.add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(167, 222, 89, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new AddStudent().setVisible(true);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			String username = userNameField.getText();
			String password = passField.getText();
			
			if(username.equals("admin") && password.equals("admin"))
			{
				setVisible(false);
				AdminPanel frame = new AdminPanel();
				frame.setVisible(true);
			}
			
			else
			{
				int id = av.grantAcces(username, password);
				if(id != -1)
				{
					setVisible(false);
					StudentInfo frame = new StudentInfo(false,id);
					frame.populateFields(id);
					frame.setVisible(true);
				}

			}

			
			}
		});
		
	}
}
