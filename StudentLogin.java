import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class StudentLogin extends JFrame{
    static StudentLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;



    public static void main(String[] strings) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

    public StudentLogin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

        JLabel lblStudentLoginForm = new JLabel("Student Login Form");
		lblStudentLoginForm.setForeground(Color.GRAY);
		lblStudentLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblEnterName = new JLabel("Enter Name:");
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
        JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
            // Form Validation
			if (name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(StudentLogin.this, "Please enter your name", "Login Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (password.trim().isEmpty()) {
				JOptionPane.showMessageDialog(StudentLogin.this, "Please enter your password", "Login Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
            // Regular Expression Validation
			String namePattern = "^[A-Za-z]+$";
			Pattern pattern = Pattern.compile(namePattern);
			Matcher nameMatcher = pattern.matcher(name);


			if (!nameMatcher.matches()) {
				JOptionPane.showMessageDialog(StudentLogin.this, "Please enter a valid name", "Login Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//System.out.println(name+" "+password);
			if(StudentDB.validate(name, password)){
				StudentSuccess1.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(StudentLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});


        passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblStudentLoginForm))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterName)
								.addComponent(lblEnterPassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblStudentLoginForm)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
    }
    
}
