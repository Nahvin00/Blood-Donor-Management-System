package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

import Model.Event;
import Model.Staff;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class event_Staff extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					event_Staff frame = new event_Staff(null);
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
	public event_Staff(Staff user) {
		
		Event event=new Event();
		String[][] data = new String[3][5];
		Controller.UserController userController = new Controller.UserController();
		try {
			for(int i=0;i<5;i++)
			{
				event = userController.recentEvent(i+1);
				for(int j=0;j<3;j++)
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
						data[j][i]=event.getEvent_CONTACT();
					}
				}
			}
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
		
		JLabel lblNewLabel = new JLabel("View Event Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(-36, 100, 862, 69);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 195, 621, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 23));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{data[0][0], data[1][0], data[2][0]},
				{data[0][1], data[1][1], data[2][1]},
				{data[0][2], data[1][2], data[2][2]},
				{data[0][3], data[1][3], data[2][3]},
				{data[0][4], data[1][4], data[2][4]},
			},
			new String[] {
				"Event Name", "Date", "Number of Participants"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(138);
		table.getColumnModel().getColumn(0).setMinWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(147);
		table.getColumnModel().getColumn(2).setPreferredWidth(165);
		scrollPane.setViewportView(table);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addevent_Staff frame = new addevent_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAddEvent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddEvent.setBounds(355, 446, 169, 54);
		contentPane.add(btnAddEvent);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard_Staff frame = new dashboard_Staff(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBack.setBounds(556, 446, 169, 54);
		contentPane.add(btnBack);
		
		JButton btnGraph = new JButton("Generate Graph");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BarChart_AWT chart = new BarChart_AWT("Event Attendance Statisics", 
				         "Number of participants across events", data);
				      chart.pack( );        
				      RefineryUtilities.centerFrameOnScreen( chart );        
				      chart.setVisible( true ); 
			}
		});
		btnGraph.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGraph.setBounds(84, 446, 224, 54);
		contentPane.add(btnGraph);
	}
}
