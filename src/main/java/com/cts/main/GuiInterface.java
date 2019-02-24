package com.cts.main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GuiInterface {

	private JFrame frame;
	private JTextField fileLocationFeild;
	private JTextField xsdLocationFeild;
	private static String fileLocation;
	private static String xsdLocation;
	private static String responseMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInterface window = new GuiInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel fileLocationLabel = new JLabel("File Location :");
		fileLocationLabel.setBounds(12, 93, 102, 16);
		frame.getContentPane().add(fileLocationLabel);
		
		fileLocationFeild = new JTextField();
		fileLocationFeild.setBounds(118, 88, 286, 26);
		frame.getContentPane().add(fileLocationFeild);
		fileLocationFeild.setColumns(10);
		
		JLabel xsdLocationLabel = new JLabel("XSD Location :");
		xsdLocationLabel.setBounds(12, 149, 91, 16);
		frame.getContentPane().add(xsdLocationLabel);
		
		xsdLocationFeild = new JTextField();
		xsdLocationFeild.setBounds(118, 144, 286, 26);
		frame.getContentPane().add(xsdLocationFeild);
		xsdLocationFeild.setColumns(10);
		
		JButton validateButton = new JButton("Validate");
		validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			fileLocation=fileLocationFeild.getText();
			xsdLocation=xsdLocationFeild.getText();
			if(fileLocation.length()==0 || xsdLocation.length()==0) {
				 JOptionPane.showMessageDialog(null, "Please enter both the feilds", "Input Errors", 0);
			}else {
			OperationClass operationClass=new OperationClass();
		 responseMessage=	operationClass.executeCommand(fileLocation, xsdLocation);
		 JOptionPane.showMessageDialog(null, responseMessage, "Validation Output", 1);
			}
			}
		});
		validateButton.setBounds(118, 221, 117, 29);
		frame.getContentPane().add(validateButton);
		
		JButton resetButton = new JButton("Reset ");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileLocationFeild.setText(null);
				xsdLocationFeild.setText(null);
			}
		});
		resetButton.setBounds(255, 221, 117, 29);
		frame.getContentPane().add(resetButton);
		
		JLabel lblNewLabel_2 = new JLabel("       XML VALIDATION INTERFACE");
		lblNewLabel_2.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 25));
		lblNewLabel_2.setBounds(12, 6, 432, 56);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
