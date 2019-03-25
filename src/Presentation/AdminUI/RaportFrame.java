package Presentation.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.CursValidation.CursValidation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RaportFrame extends JFrame {

	private JPanel contentPane;
	private JTextField oraStartField;
	private JTextField oraFinalField;
	private JTextField idStudentField;
	JTextArea textArea;
	
	ArrayList<String> cursuri = new ArrayList<>();
	ArrayList<String> ore = new ArrayList<>();
	
	CursValidation cv = new CursValidation();
	
	public void populateArea()
	{
		int oraS = Integer.parseInt(oraStartField.getText());
		int oraF = Integer.parseInt(oraFinalField.getText());
		int idS = Integer.parseInt(idStudentField.getText());
		
		textArea.removeAll();
		
		cursuri = cv.getCursuriFromStudent(idS);
		ore = cv.getOreCursuri();
		
		for(int i = 0; i < cursuri.size(); i++)
		{
			int startTime = Integer.parseInt(ore.get(i*4));
			int endTime = Integer.parseInt(ore.get(i*4 + 1));
			
			if(startTime >= oraS && endTime <= oraF)
			textArea.append(cursuri.get(i) +
							"\t" + ore.get(i*4) +
							"\t" + ore.get(i*4 + 1) +
							"\t" + ore.get(i*4 + 2) +
							"\t" + ore.get(i*4 + 3) +
							"\n\r");
		}
		
		
	}

	public RaportFrame() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOraStart = new JLabel("Ora start");
		lblOraStart.setBounds(10, 11, 65, 14);
		contentPane.add(lblOraStart);
		
		JLabel lblOraFinal = new JLabel("Ora final");
		lblOraFinal.setBounds(10, 36, 65, 14);
		contentPane.add(lblOraFinal);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(10, 61, 84, 14);
		contentPane.add(lblStudentId);
		
		oraStartField = new JTextField();
		oraStartField.setBounds(109, 8, 86, 20);
		contentPane.add(oraStartField);
		oraStartField.setColumns(10);
		
		oraFinalField = new JTextField();
		oraFinalField.setBounds(109, 33, 86, 20);
		contentPane.add(oraFinalField);
		oraFinalField.setColumns(10);
		
		idStudentField = new JTextField();
		idStudentField.setBounds(109, 58, 86, 20);
		contentPane.add(idStudentField);
		idStudentField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(48, 86, 452, 205);
		contentPane.add(textArea);
		
		JButton btnGenerateRaport = new JButton("Generate Raport");
		btnGenerateRaport.setBounds(219, 345, 141, 23);
		contentPane.add(btnGenerateRaport);
		btnGenerateRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				populateArea();
			}
		});
	}
}
