package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Donor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class signup_Donor extends JFrame {

	private JPanel contentPane;
	private JTextField textNAME;
	private JTextField textIC;
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
					signup_Donor frame = new signup_Donor();
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
	public signup_Donor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(86, 58, 298, 100);
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Donor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblNewLabel_1.setBounds(404, 71, 191, 75);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(86, 177, 97, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(86, 220, 97, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Re-enter Password:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(86, 270, 173, 33);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("IC number:");
		lblNewLabel_2_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(86, 313, 97, 33);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Email:");
		lblNewLabel_2_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_1.setBounds(86, 356, 97, 33);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Phone number:");
		lblNewLabel_2_1_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2.setBounds(86, 399, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2);
		
		JLabel lblNewLabel_2_1_2_2_1 = new JLabel("Address:");
		lblNewLabel_2_1_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2_1.setBounds(86, 449, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2_1);
		
		JLabel lblNewLabel_2_1_2_2_1_1 = new JLabel("Blood Group:");
		lblNewLabel_2_1_2_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2_1_1.setBounds(86, 526, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2_1_1);
		
		textNAME = new JTextField();
		textNAME.setBounds(250, 177, 418, 29);
		contentPane.add(textNAME);
		textNAME.setColumns(10);
		
		textIC = new JTextField();
		textIC.setColumns(10);
		textIC.setBounds(250, 313, 418, 29);
		contentPane.add(textIC);
		
		textEMAIL = new JTextField();
		textEMAIL.setColumns(10);
		textEMAIL.setBounds(250, 360, 418, 29);
		contentPane.add(textEMAIL);
		
		textPHONE = new JTextField();
		textPHONE.setColumns(10);
		textPHONE.setBounds(250, 409, 418, 29);
		contentPane.add(textPHONE);
		
		textADDRESS = new JTextField();
		textADDRESS.setColumns(10);
		textADDRESS.setBounds(250, 459, 418, 67);
		contentPane.add(textADDRESS);
		
		JComboBox comboBLOOD = new JComboBox();
		comboBLOOD.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBLOOD.setEditable(true);
		comboBLOOD.setBounds(250, 535, 51, 21);
		contentPane.add(comboBLOOD);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 220, 418, 33);
		contentPane.add(passwordField);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(250, 270, 418, 29);
		contentPane.add(passwordField2);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = new String(passwordField.getPassword()).trim();
				String password2 = new String(passwordField2.getPassword()).trim();
				if(password.equals(password2))
				{
					
					Donor user=new Donor();
					

					Controller.UserController userController = new Controller.UserController();
					try {
						if(userController.findDonor(textIC.getText()))
						{
							JOptionPane.showMessageDialog(btnNewButton, "Account already exist. Please login instead!");
							login_Donor frame = new login_Donor();
							frame.setVisible(true);
							dispose();
						}
						else
						{
							user.setDonor_NAME(textNAME.getText());
							user.setDonor_EMAIL(textEMAIL.getText());
							user.setDonor_PHONE(textPHONE.getText());
							user.setDonor_ADDRESS(textADDRESS.getText());
							user.setDonor_PASSWORD(password);
							user.setDonor_BLOODGROUP(comboBLOOD.getSelectedItem().toString());
							user.setDonor_ICNUM(textIC.getText());
							userController.insertDonor(user);
							JOptionPane.showMessageDialog(btnNewButton, "Account successfully creted. Please Login!");
							login_Donor frame = new login_Donor();
							frame.setVisible(true);
							dispose();
						}
						
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Password does not match!");
					textNAME.setText("");
					textEMAIL.setText("");
					textPHONE.setText("");
					textADDRESS.setText("");
					passwordField.setText("");
					passwordField2.setText("");
					textIC.setText("");
					comboBLOOD.setSelectedItem("A+");
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(280, 624, 133, 50);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_Donor frame = new login_Donor();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnBack.setBounds(494, 624, 133, 50);
		contentPane.add(btnBack);
		
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
