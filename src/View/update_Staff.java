package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Staff;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class update_Staff extends JFrame {

	private JPanel contentPane;
	private JTextField textNAME;
	private JTextField textEMAIL;
	private JTextField textPHONE;
	private JTextField textADDRESS;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_Staff frame = new update_Staff(null);
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
	public update_Staff(Staff user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(69, 143, 97, 33);
		contentPane.add(lblNewLabel_2);
		
		textNAME = new JTextField();
		textNAME.setColumns(10);
		textNAME.setBounds(233, 143, 418, 29);
		contentPane.add(textNAME);
		
		JLabel lblNewLabel_1 = new JLabel("Staff");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(-107, 43, 774, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(69, 186, 97, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Re-enter Password:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(69, 236, 173, 33);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Email:");
		lblNewLabel_2_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_1.setBounds(69, 322, 97, 33);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		textEMAIL = new JTextField();
		textEMAIL.setColumns(10);
		textEMAIL.setBounds(233, 326, 418, 29);
		contentPane.add(textEMAIL);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Phone number:");
		lblNewLabel_2_1_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2.setBounds(69, 365, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2);
		
		textPHONE = new JTextField();
		textPHONE.setColumns(10);
		textPHONE.setBounds(233, 375, 418, 29);
		contentPane.add(textPHONE);
		
		JLabel lblNewLabel_2_1_2_2_1 = new JLabel("Address:");
		lblNewLabel_2_1_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2_1.setBounds(69, 415, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2_1);
		
		textADDRESS = new JTextField();
		textADDRESS.setColumns(10);
		textADDRESS.setBounds(233, 425, 418, 67);
		contentPane.add(textADDRESS);
		
		JLabel lblNewLabel = new JLabel("Update Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(73, 76, 672, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = new String(passwordField.getPassword()).trim();
				String password2 = new String(passwordField2.getPassword()).trim();
				if(password.equals(password2))
				{
					user.setStaff_NAME(textNAME.getText());
					user.setStaff_EMAIL(textEMAIL.getText());
					user.setStaff_PHONE(textPHONE.getText());
					user.setStaff_ADDRESS(textADDRESS.getText());
					user.setStaff_PASSWORD(password);
					Controller.UserController userController = new Controller.UserController();
					try {
						userController.updateStaff(user);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					
					}
					JOptionPane.showMessageDialog(btnSave, "Details successfully updated!");
					dashboard_Staff frame = new dashboard_Staff(user);
					frame.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(btnSave, "Password does not match!");
					textNAME.setText("");
					textEMAIL.setText("");
					textPHONE.setText("");
					textADDRESS.setText("");
					passwordField.setText("");
					passwordField2.setText("");
					
				}
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSave.setBounds(279, 562, 97, 44);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard_Staff frame = new dashboard_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBack.setBounds(437, 562, 97, 44);
		contentPane.add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(233, 186, 418, 29);
		contentPane.add(passwordField);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(233, 236, 418, 29);
		contentPane.add(passwordField2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 61, 759);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 179, 113));
		panel_2.setBounds(57, 0, 715, 44);
		contentPane.add(panel_2);
	}
}
