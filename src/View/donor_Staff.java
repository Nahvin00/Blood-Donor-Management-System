package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Donor;
import Model.Staff;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class donor_Staff extends JFrame {

	private JPanel contentPane;
	private JTextField textDONORIC;
	private JTextField textEVENTID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donor_Staff frame = new donor_Staff(null);
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
	public donor_Staff(Staff user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Attendance");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(46, 95, 716, 76);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard_Staff frame = new dashboard_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnBack.setBounds(526, 584, 162, 57);
		contentPane.add(btnBack);
		
		textDONORIC = new JTextField();
		textDONORIC.setBounds(304, 232, 229, 26);
		contentPane.add(textDONORIC);
		textDONORIC.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Donor IC no:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(138, 231, 125, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Event Refer ID:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(138, 466, 167, 20);
		contentPane.add(lblNewLabel_1_1);
		
		textEVENTID = new JTextField();
		textEVENTID.setColumns(10);
		textEVENTID.setBounds(304, 466, 229, 26);
		contentPane.add(textEVENTID);
		
		JLabel lblNAME = new JLabel("");
		lblNAME.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNAME.setForeground(Color.WHITE);
		lblNAME.setBounds(138, 290, 415, 20);
		contentPane.add(lblNAME);
		
		JLabel lblBLOOD = new JLabel("");
		lblBLOOD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBLOOD.setForeground(Color.WHITE);
		lblBLOOD.setBounds(138, 320, 415, 20);
		contentPane.add(lblBLOOD);
		
		JLabel lblPHONE = new JLabel("");
		lblPHONE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPHONE.setForeground(Color.WHITE);
		lblPHONE.setBounds(138, 350, 415, 20);
		contentPane.add(lblPHONE);
		
		JLabel lblEMAIL = new JLabel("");
		lblEMAIL.setForeground(Color.WHITE);
		lblEMAIL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEMAIL.setBounds(138, 380, 415, 20);
		contentPane.add(lblEMAIL);
		
		JLabel lblADDRESS = new JLabel("");
		lblADDRESS.setForeground(Color.WHITE);
		lblADDRESS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblADDRESS.setBounds(138, 410, 415, 20);
		contentPane.add(lblADDRESS);
		
		JButton btnFindDonor = new JButton("Find Donor");
		btnFindDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ic = textDONORIC.getText();
				Donor donor = new Donor();
				donor.setDonor_ICNUM(ic);
				Controller.UserController userController = new Controller.UserController();
				try {
					if(userController.doSearchDonor(donor))
					{
						lblNAME.setText("NAME:  "+donor.getDonor_NAME());
						lblBLOOD.setText("BLOODGROUP:  "+donor.getDonor_BLOODGROUP());
						lblPHONE.setText("PHONE NUMBER:  "+donor.getDonor_PHONE());
						lblEMAIL.setText("EMAIL:  "+donor.getDonor_EMAIL());
						lblADDRESS.setText("ADDRESS:  "+donor.getDonor_ADDRESS());
					}
					else
						JOptionPane.showMessageDialog(btnFindDonor, "Incorrect IC number!");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				}
			}
		});
		btnFindDonor.setBounds(565, 234, 101, 23);
		contentPane.add(btnFindDonor);
		
		JButton btnAttendance = new JButton("Add Attendance");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorIC = textDONORIC.getText();
				String eventID = textEVENTID.getText();
				
				Controller.UserController userController = new Controller.UserController();
				try {
					if(userController.doSearchAttendance(donorIC, eventID))
					{
						int x=userController.insertAttendance(donorIC, eventID);
						if(x==1) 
						{
							JOptionPane.showMessageDialog(btnFindDonor, "Attendance has been sucessfully recorded!");
							lblNAME.setText("");
							lblBLOOD.setText("");
							lblPHONE.setText("");
							lblEMAIL.setText("");
							lblADDRESS.setText("");
							textDONORIC.setText("");
							textEVENTID.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(btnFindDonor, "Invalid Donor IC num or Event Refer ID!");
						}
					}
					else
						JOptionPane.showMessageDialog(btnFindDonor, "Attendance has already been recorded!");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAttendance.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAttendance.setBounds(71, 584, 201, 57);
		contentPane.add(btnAttendance);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNAME.setText("");
				lblBLOOD.setText("");
				lblPHONE.setText("");
				lblEMAIL.setText("");
				lblADDRESS.setText("");
				textDONORIC.setText("");
				textEVENTID.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnClear.setBounds(307, 584, 162, 57);
		contentPane.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 61, 696);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 179, 113));
		panel_2.setBounds(60, 0, 712, 44);
		contentPane.add(panel_2);
		
		
	}
}
