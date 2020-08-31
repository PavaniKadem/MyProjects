package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JInternalFrame;

public class mylogin {

	private JFrame frame;
	private JTextField txtEmailAddressOr;
	private JPasswordField passwordField;
	private JTextField txtFacebook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mylogin window = new mylogin();
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
	public mylogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(UIManager.getFont("PopupMenu.font"));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 570, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		txtEmailAddressOr = new JTextField();
		txtEmailAddressOr.setForeground(Color.LIGHT_GRAY);
		txtEmailAddressOr.setText("Email address or phone number");
		txtEmailAddressOr.setBounds(161, 140, 218, 23);
		frame.getContentPane().add(txtEmailAddressOr);
		txtEmailAddressOr.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setName("");
		passwordField.setToolTipText("Password");
		passwordField.setBounds(161, 174, 218, 23);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(222, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblLogInTo = new JLabel("Log in to Facebook");
		lblLogInTo.setForeground(Color.BLACK);
		lblLogInTo.setBackground(Color.WHITE);
		lblLogInTo.setBounds(202, 95, 139, 14);
		frame.getContentPane().add(lblLogInTo);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.WHITE);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(91, 277, 352, -193);
		frame.getContentPane().add(layeredPane);
		
		txtFacebook = new JTextField();
		txtFacebook.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtFacebook.setForeground(Color.WHITE);
		txtFacebook.setText("   facebook");
		txtFacebook.setBackground(new Color(0, 0, 139));
		txtFacebook.setBounds(0, -2, 554, 46);
		frame.getContentPane().add(txtFacebook);
		txtFacebook.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("sign Up");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1.setBounds(133, 55, 67, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
