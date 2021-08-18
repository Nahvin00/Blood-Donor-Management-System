package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Donor;
import Model.Event;
import Model.Staff;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class addevent_Staff extends JFrame {

	private JPanel contentPane;
	private JTextField textNAME;
	private JTextField textDATE;
	private JTextField textVENUE;
	private JTextField textTIME;
	private JTextField textCONTACT;
	private JTextField textREFERID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addevent_Staff frame = new addevent_Staff(null);
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
	public addevent_Staff(Staff user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Event");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(212, 64, 447, 69);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Event Name:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(105, 192, 157, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Event Date:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(105, 240, 157, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Event Venue:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(105, 289, 157, 51);
		contentPane.add(lblNewLabel_1_1_1);
		
		textNAME = new JTextField();
		textNAME.setBounds(272, 201, 338, 38);
		contentPane.add(textNAME);
		textNAME.setColumns(10);
		
		textDATE = new JTextField();
		textDATE.setColumns(10);
		textDATE.setBounds(272, 249, 338, 38);
		contentPane.add(textDATE);
		
		textVENUE = new JTextField();
		textVENUE.setColumns(10);
		textVENUE.setBounds(272, 298, 338, 38);
		contentPane.add(textVENUE);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event_Staff frame = new event_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.setBounds(472, 489, 121, 44);
		contentPane.add(btnCancel);
		
		textTIME = new JTextField();
		textTIME.setColumns(10);
		textTIME.setBounds(272, 347, 338, 38);
		contentPane.add(textTIME);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Event Time:");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(105, 338, 157, 51);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Event Contact:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(105, 389, 157, 51);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textCONTACT = new JTextField();
		textCONTACT.setColumns(10);
		textCONTACT.setBounds(272, 398, 338, 38);
		contentPane.add(textCONTACT);
		
		textREFERID = new JTextField();
		textREFERID.setColumns(10);
		textREFERID.setBounds(272, 152, 338, 38);
		contentPane.add(textREFERID);
		
		JLabel lblNewLabel_1_2 = new JLabel("Event ReferID:");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(105, 152, 157, 51);
		contentPane.add(lblNewLabel_1_2);
		
		
		JButton btnSAVE = new JButton("Save");
		btnSAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Event event=new Event();

				Controller.UserController userController = new Controller.UserController();
				try {
					if(userController.findEvent(textREFERID.getText()))
					{
						event.setEvent_REFERID(textREFERID.getText());
						event.setEvent_NAME(textNAME.getText());
						event.setEvent_DATE(textDATE.getText());
						event.setEvent_VENUE(textVENUE.getText());
						event.setEvent_TIME(textTIME.getText());
						event.setEvent_CONTACT(textCONTACT.getText());
						userController.insertEvent(event);
						JOptionPane.showMessageDialog(btnSAVE, "Event has been successfully added!");
						event_Staff frame = new event_Staff(user);
						frame.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(btnSAVE, "Invalid Event Refer ID!");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				}
				
				
			}
		});
		btnSAVE.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSAVE.setBounds(201, 489, 121, 44);
		contentPane.add(btnSAVE);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textREFERID.setText("");
				textNAME.setText("");
				textDATE.setText("");
				textVENUE.setText("");
				textTIME.setText("");
				textCONTACT.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnClear.setBounds(341, 489, 121, 44);
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
