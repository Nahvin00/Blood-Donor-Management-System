package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Donor;
import Model.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class dashboard_Donor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard_Donor frame = new dashboard_Donor(null);
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
	public dashboard_Donor(Donor user) {
		Event event = new Event();
		Controller.UserController userController = new Controller.UserController();
		try {
			event = userController.upcomingEvent();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		
		}
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Back, "+user.getDonor_NAME());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(27, 61, 697, 44);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Upcoming events:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(158, 141, 173, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Event Name: "+event.getEvent_NAME());
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(158, 191, 359, 22);
		contentPane.add(lblNewLabel_2);
		

		JLabel lblNewLabel_2_1 = new JLabel("Date & Time: "+event.getEvent_DATE()+" "+event.getEvent_TIME());
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(158, 222, 390, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Venue: "+event.getEvent_VENUE());
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(158, 260, 359, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Contact no: "+event.getEvent_CONTACT());
		lblNewLabel_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(158, 297, 359, 27);
		contentPane.add(lblNewLabel_2_2_1);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_Donor frame = new update_Donor(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnUpdateDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDetails.setBounds(300, 382, 149, 36);
		contentPane.add(btnUpdateDetails);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_Donor frame = new login_Donor();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(491, 382, 107, 36);
		contentPane.add(btnLogOut);
		
		JButton btnAttendedEvent = new JButton("Attended Event");
		btnAttendedEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attended_Donor frame = new attended_Donor(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAttendedEvent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAttendedEvent.setBounds(124, 382, 149, 36);
		contentPane.add(btnAttendedEvent);
		
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
