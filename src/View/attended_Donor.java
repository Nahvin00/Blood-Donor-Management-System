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

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class attended_Donor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attended_Donor frame = new attended_Donor(null);
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
	public attended_Donor(Donor user) {
		
		Event event=new Event();
		String[][] data = new String[4][3];
		
		Controller.UserController userController = new Controller.UserController();
		try {
			for(int i=0;i<3;i++)
			{
				event = userController.attendedEvent(user.getDonor_ICNUM(),i+1);
				for(int j=0;j<4;j++)
				{
					if(j==0)
					{
						data[j][i]=event.getEvent_NAME();
					}
					else if(j==1)
					{
						data[j][i]=event.getEvent_DATE();
					}
					else if(j==2)
					{
						data[j][i]=event.getEvent_TIME();
					}
					else if(j==3)
					{
						data[j][i]=event.getEvent_VENUE();
					}
				}
			}
			event = userController.upcomingEvent();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		
		}
		
		setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Welcome Back, "+user.getDonor_NAME());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(42, 106, 698, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard_Donor frame = new dashboard_Donor(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(340, 453, 107, 36);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Attended Events");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 160, 688, 29);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 239, 520, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{data[0][0], data[1][0]},
				{data[0][1], data[1][1]},
				{data[0][2], data[1][2]},
			},
			new String[] {
				"Event Name", "Event Date"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 61, 696);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 179, 113));
		panel_2.setBounds(60, 0, 712, 44);
		contentPane.add(panel_2);
		
		
		
		if(data[0][0]!=null)
		{
			JButton btnCertificate1 = new JButton("Certificate");
			btnCertificate1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("                               Blood Donor Management System             \n");
					textArea.setText(textArea.getText()+"\n\n\n");
					textArea.setText(textArea.getText()+"                                   Certificate of Appreciation              \n");
					textArea.setText(textArea.getText()+"\n\n");
					textArea.setText(textArea.getText()+"                                      "+user.getDonor_NAME()+"               \n");
					textArea.setText(textArea.getText()+"                                          "+user.getDonor_ICNUM()+"             \n");
					textArea.setText(textArea.getText()+"\n\n"); 
					textArea.setText(textArea.getText()+"                           has donated their blood by participating in      \n");
					textArea.setText(textArea.getText()+"\n");
					textArea.setText(textArea.getText()+"                           Event name: "+data[0][0]+"               \n");
					textArea.setText(textArea.getText()+"                           Date & Time: "+data[1][0]+"  "+data[2][0]+"      \n");
					textArea.setText(textArea.getText()+"                           Venue: "+data[3][0]+"                 \n");
					textArea.setText(textArea.getText()+"\n\n\n\n\n\n\n");
					textArea.setText(textArea.getText()+"******************This is  a computer generated certificate******************\n");
					
					try {
						textArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnCertificate1.setBounds(630, 255, 107, 15);
			contentPane.add(btnCertificate1);
		}
		
		if(data[0][1]!=null)
		{
			JButton btnCertificate2 = new JButton("Certificate");
			btnCertificate2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					textArea.setText("                               Blood Donor Management System             \n");
					textArea.setText(textArea.getText()+"\n\n\n");
					textArea.setText(textArea.getText()+"                                   Certificate of Appreciation              \n");
					textArea.setText(textArea.getText()+"\n\n");
					textArea.setText(textArea.getText()+"                                      "+user.getDonor_NAME()+"               \n");
					textArea.setText(textArea.getText()+"                                          "+user.getDonor_ICNUM()+"             \n");
					textArea.setText(textArea.getText()+"\n\n"); 
					textArea.setText(textArea.getText()+"                           has donated their blood by participating in      \n");
					textArea.setText(textArea.getText()+"\n");
					textArea.setText(textArea.getText()+"                           Event name: "+data[0][1]+"               \n");
					textArea.setText(textArea.getText()+"                           Date & Time: "+data[1][1]+"  "+data[2][1]+"      \n");
					textArea.setText(textArea.getText()+"                           Venue: "+data[3][1]+"                 \n");
					textArea.setText(textArea.getText()+"\n\n\n\n\n\n\n");
					textArea.setText(textArea.getText()+"******************This is  a computer generated certificate******************\n");
					
					try {
						textArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnCertificate2.setBounds(630, 275, 107, 15);
			contentPane.add(btnCertificate2);
		}
		
		if(data[0][2]!=null)
		{
			JButton btnCertificate3 = new JButton("Certificate");
			btnCertificate3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("                               Blood Donor Management System             \n");
					textArea.setText(textArea.getText()+"\n\n\n");
					textArea.setText(textArea.getText()+"                                   Certificate of Appreciation              \n");
					textArea.setText(textArea.getText()+"\n\n");
					textArea.setText(textArea.getText()+"                                      "+user.getDonor_NAME()+"               \n");
					textArea.setText(textArea.getText()+"                                          "+user.getDonor_ICNUM()+"             \n");
					textArea.setText(textArea.getText()+"\n\n"); 
					textArea.setText(textArea.getText()+"                           has donated their blood by participating in      \n");
					textArea.setText(textArea.getText()+"\n");
					textArea.setText(textArea.getText()+"                           Event name: "+data[0][2]+"               \n");
					textArea.setText(textArea.getText()+"                           Date & Time: "+data[1][2]+"  "+data[2][2]+"      \n");
					textArea.setText(textArea.getText()+"                           Venue: "+data[3][2]+"                 \n");
					textArea.setText(textArea.getText()+"\n\n\n\n\n\n\n");
					textArea.setText(textArea.getText()+"******************This is  a computer generated certificate******************\n");
					
					try {
						textArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnCertificate3.setBounds(630, 295, 107, 15);
			contentPane.add(btnCertificate3);
		}
		
	}
}
