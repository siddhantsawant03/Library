
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUsers extends JFrame {
	static AdminUsers frame;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new AdminUsers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminUsers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibraryManagement = new JLabel("");
		lblLibraryManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLibraryManagement.setForeground(Color.GRAY);
		
		// ADMIN LOGIN BUTTON
		// JButton btnAdminLogin = new JButton("Admin Login");
		// btnAdminLogin.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 	AdminLogin.main(new String[]{});
		// 	frame.dispose();
		// 	}
		// });
		// btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		// LIBRARIAN BUTTON
		JButton btnLibrarian = new JButton("Librarian ");
		btnLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// STUDENT BUTTON
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentSuccess.main(new String[]{});
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //  LOGOUT BUTTON
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Library.main(new String[]{});
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lblLibraryManagement))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnLibrarian, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnStudent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLogout, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLibraryManagement)
					.addGap(32)
					.addComponent(btnLibrarian, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnStudent, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}