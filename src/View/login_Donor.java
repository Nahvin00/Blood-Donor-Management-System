package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import Model.Donor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Component;

public class login_Donor extends JFrame {

	private JPanel contentPane;
	private JTextField textIC;
	private JPasswordField textPWD;
	/**
	 * @wbp.nonvisual location=-17,-26
	 */
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_Donor frame = new login_Donor();
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
	public login_Donor() {
		setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Blood Management System");
		lblNewLabel.setBounds(32, 117, 753, 44);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Donor");
		lblNewLabel_1.setBounds(213, 153, 368, 105);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 90));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IC no:");
		lblNewLabel_2.setBounds(107, 283, 129, 52);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setBounds(71, 362, 140, 72);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblNewLabel_2_1);
		
		textIC = new JTextField();
		textIC.setBounds(256, 291, 346, 44);
		contentPane.add(textIC);
		textIC.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(157, 507, 129, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ic = textIC.getText();
				String password = new String(textPWD.getPassword()).trim();
				
				Donor user = new Donor();
				user.setDonor_ICNUM(ic);
				user.setDonor_PASSWORD(password);
				
				Controller.UserController userController = new Controller.UserController();
				try {
					if(userController.doLogin(user))
					{
						dashboard_Donor frame = new dashboard_Donor(user);
						frame.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(btnNewButton, "Incorrect IC or Password!");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(357, 507, 140, 44);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup_Donor frame = new signup_Donor();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(btnSignUp);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(559, 507, 123, 44);
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_Staff frame = new login_Staff();
				frame.setVisible(true);
				dispose();
			}
		});
		btnStaff.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(btnStaff);
		
		textPWD = new JPasswordField();
		textPWD.setBounds(256, 384, 346, 44);
		contentPane.add(textPWD);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 61, 759);
		panel.setBackground(new Color(60, 179, 113));
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(57, 0, 715, 44);
		panel_2.setBackground(new Color(60, 179, 113));
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("Images\\Artboard 206.png"));
		lblNewLabel_3.setBounds(193, 290, 82, 44);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("Images\\A1.png"));
		lblNewLabel_4.setBounds(196, 385, 61, 44);
		contentPane.add(lblNewLabel_4);
	}
}
