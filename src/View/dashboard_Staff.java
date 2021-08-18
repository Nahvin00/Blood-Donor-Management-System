package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Event;
import Model.Staff;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class dashboard_Staff extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard_Staff frame = new dashboard_Staff(null);
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
	public dashboard_Staff(Staff user) {
		
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
		
		JLabel lblNewLabel = new JLabel("Welcome Back Staff, "+user.getStaff_NAME());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 94, 697, 44);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Upcoming events:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(137, 178, 173, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Event Name: "+event.getEvent_NAME());
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(137, 228, 359, 22);
		contentPane.add(lblNewLabel_2);
		

		JLabel lblNewLabel_2_1 = new JLabel("Date & Time: "+event.getEvent_DATE()+" "+event.getEvent_TIME());
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(137, 259, 390, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Venue: "+event.getEvent_VENUE());
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(137, 297, 359, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Contact no: "+event.getEvent_CONTACT());
		lblNewLabel_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(137, 334, 359, 27);
		contentPane.add(lblNewLabel_2_2_1);
		
		JButton btnNewButton = new JButton("Update Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_Staff frame = new update_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(75, 405, 143, 44);
		contentPane.add(btnNewButton);
		
		JButton btnViewDonorDetails = new JButton("Manage Attendance");
		btnViewDonorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				donor_Staff frame = new donor_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnViewDonorDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewDonorDetails.setBounds(228, 405, 176, 44);
		contentPane.add(btnViewDonorDetails);
		
		JButton btnNewButton_2_1 = new JButton("Manage Events");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event_Staff frame = new event_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(414, 405, 143, 44);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Log Out");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_Donor frame = new login_Donor();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_1.setBounds(576, 405, 143, 44);
		contentPane.add(btnNewButton_2_1_1);
		
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
