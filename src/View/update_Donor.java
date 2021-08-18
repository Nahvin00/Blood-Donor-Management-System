package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Donor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class update_Donor extends JFrame {

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
					update_Donor frame = new update_Donor(null);
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
	public update_Donor(Donor user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(27, 38, 722, 93);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(79, 146, 97, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(79, 189, 97, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Re-enter Password:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(79, 233, 173, 33);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Email:");
		lblNewLabel_2_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_1.setBounds(79, 325, 97, 33);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Phone number:");
		lblNewLabel_2_1_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2.setBounds(79, 368, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2);
		
		JLabel lblNewLabel_2_1_2_2_1 = new JLabel("Address:");
		lblNewLabel_2_1_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2_1.setBounds(79, 418, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2_1);
		
		JLabel lblNewLabel_2_1_2_2_1_1 = new JLabel("Blood Group:");
		lblNewLabel_2_1_2_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2_2_1_1.setBounds(79, 495, 133, 33);
		contentPane.add(lblNewLabel_2_1_2_2_1_1);
		
		textNAME = new JTextField();
		textNAME.setColumns(10);
		textNAME.setBounds(243, 146, 418, 29);
		contentPane.add(textNAME);
		
		textEMAIL = new JTextField();
		textEMAIL.setColumns(10);
		textEMAIL.setBounds(243, 329, 418, 29);
		contentPane.add(textEMAIL);
		
		textPHONE = new JTextField();
		textPHONE.setColumns(10);
		textPHONE.setBounds(243, 378, 418, 29);
		contentPane.add(textPHONE);
		
		textADDRESS = new JTextField();
		textADDRESS.setColumns(10);
		textADDRESS.setBounds(243, 428, 418, 67);
		contentPane.add(textADDRESS);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 189, 418, 29);
		contentPane.add(passwordField);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(243, 233, 418, 26);
		contentPane.add(passwordField2);
		
		JComboBox comboBLOOD = new JComboBox();
		comboBLOOD.setEditable(true);
		comboBLOOD.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBLOOD.setBounds(243, 504, 51, 21);
		contentPane.add(comboBLOOD);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword()).trim();
				String password2 = new String(passwordField2.getPassword()).trim();
				if(password.equals(password2))
				{
					user.setDonor_NAME(textNAME.getText());
					user.setDonor_EMAIL(textEMAIL.getText());
					user.setDonor_PHONE(textPHONE.getText());
					user.setDonor_ADDRESS(textADDRESS.getText());
					user.setDonor_PASSWORD(password);
					user.setDonor_BLOODGROUP(comboBLOOD.getSelectedItem().toString());
					Controller.UserController userController = new Controller.UserController();
					try {
						userController.updateDonor(user);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					
					}
					JOptionPane.showMessageDialog(btnSave, "Details successfully updated!");
					dashboard_Donor frame = new dashboard_Donor(user);
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
					comboBLOOD.setSelectedItem("A+");
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(211, 596, 107, 36);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard_Donor frame = new dashboard_Donor(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(456, 596, 107, 36);
		contentPane.add(btnBack);
		
		
		
		
	}
}
