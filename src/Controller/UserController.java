package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Database.MyDatabase;
import Model.Donor;
import Model.Event;
import Model.Staff;

public class UserController {

	

	public boolean findEvent(String referid) throws ClassNotFoundException, SQLException
	{
		int x=0;
		String sql = "select EVENT_NAME from event where EVENT_REFERID = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, referid);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			x=1;
		}
		conn.close();
		if(x==1)
			return false;
		return true;
	}
	
	public void insertEvent(Event event) throws ClassNotFoundException, SQLException
	{
		String sql = "insert into event (EVENT_NAME,EVENT_DATE,EVENT_VENUE,EVENT_TIME,EVENT_REFERID,EVENT_CONTACT) values (?,?,?,?,?,?)";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, event.getEvent_NAME());
		preparedStatement.setString(2, event.getEvent_DATE());
		preparedStatement.setString(3, event.getEvent_VENUE());
		preparedStatement.setString(4, event.getEvent_TIME());
		preparedStatement.setString(5, event.getEvent_REFERID());
		preparedStatement.setString(6, event.getEvent_CONTACT());
		preparedStatement.executeUpdate();
		conn.close();
	}
	
	public Event upcomingEvent() throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT EVENT_NAME,EVENT_DATE,EVENT_VENUE,EVENT_TIME,EVENT_REFERID,EVENT_CONTACT FROM `event` WHERE EVENT_REFERID != ALL (SELECT EVENT_REFERID from eventattendance) ORDER BY EVENT_REFERID";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Event event1 = new Event();
		if(resultSet.next())
		{
				event1.setEvent_NAME(resultSet.getString(1));
				event1.setEvent_DATE(resultSet.getString(2));
				event1.setEvent_VENUE(resultSet.getString(3));
				event1.setEvent_TIME(resultSet.getString(4));
				event1.setEvent_REFERID(resultSet.getString(5));
				event1.setEvent_CONTACT(resultSet.getString(6));
		}
		conn.close();
		return event1;
	}

	
	public Event attendedEvent(String ic, int i) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * FROM (select e.EVENT_NAME, e.EVENT_DATE, e.EVENT_REFERID,e.EVENT_TIME,e.EVENT_VENUE,ROW_NUMBER() OVER (ORDER BY a.EVENT_REFERID DESC) AS rownumber FROM eventattendance a, event e WHERE e.EVENT_REFERID=a.EVENT_REFERID and a.DONOR_ICNUM = ?) as Sample where rownumber = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, ic);
		preparedStatement.setString(2, Integer.toString(i));
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Event event1 = new Event();
		if(resultSet.next())
		{
				event1.setEvent_NAME(resultSet.getString(1));
				event1.setEvent_DATE(resultSet.getString(2));
				event1.setEvent_REFERID(resultSet.getString(3));
				event1.setEvent_TIME(resultSet.getString(4));
				event1.setEvent_VENUE(resultSet.getString(5));
		}
		conn.close();
		return event1;
	}
	
	public Event recentEvent(int i) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * FROM (select e.EVENT_NAME,e.EVENT_DATE,COUNT(a.DONOR_ICNUM),a.EVENT_REFERID,ROW_NUMBER() OVER (ORDER BY a.EVENT_REFERID DESC) AS rownumber FROM eventattendance a, event e WHERE e.EVENT_REFERID=a.EVENT_REFERID GROUP BY EVENT_REFERID) as Sample where rownumber = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, Integer.toString(i));
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Event event1 = new Event();
		if(resultSet.next())
		{
				event1.setEvent_NAME(resultSet.getString(1));
				event1.setEvent_DATE(resultSet.getString(2));
				event1.setEvent_CONTACT(resultSet.getString(3));
		}
		conn.close();
		return event1;
	}
	
	public boolean findDonor(String icnum) throws ClassNotFoundException, SQLException
	{
		int x=0;
		String sql = "SELECT DONOR_NAME FROM donor WHERE DONOR_ICNUM =?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, icnum);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			x=1;
		}
		conn.close();
		if(x==1)
			return true;
		return false;
	}
	
	public void insertDonor(Donor user) throws ClassNotFoundException, SQLException
	{
		String sql = "insert into donor (DONOR_NAME,DONOR_EMAIL,DONOR_PHONE,DONOR_ADDRESS,DONOR_BLOODGROUP,DONOR_PASSWORD,DONOR_ICNUM) values (?,?,?,?,?,?,?)";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getDonor_NAME());
		preparedStatement.setString(2, user.getDonor_EMAIL());
		preparedStatement.setString(3, user.getDonor_PHONE());
		preparedStatement.setString(4, user.getDonor_ADDRESS());
		preparedStatement.setString(5, user.getDonor_BLOODGROUP());
		preparedStatement.setString(6, user.getDonor_PASSWORD());
		preparedStatement.setString(7, user.getDonor_ICNUM());
		preparedStatement.executeUpdate();
		conn.close();
	}

	public void updateDonor(Donor user) throws ClassNotFoundException, SQLException 
	{
		String sql = "update donor set  DONOR_NAME = ?,DONOR_EMAIL = ?,DONOR_PHONE = ?,DONOR_ADDRESS = ?,DONOR_BLOODGROUP = ?,DONOR_PASSWORD = ? where DONOR_ICNUM = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getDonor_NAME());
		preparedStatement.setString(2, user.getDonor_EMAIL());
		preparedStatement.setString(3, user.getDonor_PHONE());
		preparedStatement.setString(4, user.getDonor_ADDRESS());
		preparedStatement.setString(5, user.getDonor_BLOODGROUP());
		preparedStatement.setString(6, user.getDonor_PASSWORD());
		preparedStatement.setString(7, user.getDonor_ICNUM());
		preparedStatement.executeUpdate();
		conn.close();
	}

	public boolean doLogin(Donor user) throws ClassNotFoundException, SQLException 
	{
		int x = 0;
		String sql = "select DONOR_NAME,DONOR_EMAIL,DONOR_PHONE,DONOR_ADDRESS,DONOR_BLOODGROUP from donor where DONOR_ICNUM = ? and DONOR_PASSWORD =?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getDonor_ICNUM());
		preparedStatement.setString(2, user.getDonor_PASSWORD());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			x=1;
			user.setDonor_NAME(resultSet.getString(1));
			user.setDonor_EMAIL(resultSet.getString(2));
			user.setDonor_PHONE(resultSet.getString(3));
			user.setDonor_ADDRESS(resultSet.getString(4));
			user.setDonor_BLOODGROUP(resultSet.getString(5));
		}
		conn.close();
		if(x==1)
			return true;
		return false;
		
	}
	
	
	public boolean doStaffLogin(Staff user) throws ClassNotFoundException, SQLException 
	{
		int x = 0;
		String sql = "select STAFF_NAME,STAFF_EMAIL,STAFF_PHONENUM,STAFF_ADDRESS from staff where STAFF_ICNUM = ? and STAFF_PASSWORD = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getStaff_ICNUM());
		preparedStatement.setString(2, user.getStaff_PASSWORD());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			x=1;
			user.setStaff_NAME(resultSet.getString(1));
			user.setStaff_EMAIL(resultSet.getString(2));
			user.setStaff_PHONE(resultSet.getString(3));
			user.setStaff_ADDRESS(resultSet.getString(4));
		}
		conn.close();
		if(x==1)
			return true;
		return false;
		
	}
	
	
	public void updateStaff(Staff user) throws ClassNotFoundException, SQLException 
	{
		String sql = "update staff set  STAFF_NAME = ?,STAFF_EMAIL = ?,STAFF_PHONENUM = ?,STAFF_ADDRESS = ?,STAFF_PASSWORD = ? where STAFF_ICNUM = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getStaff_NAME());
		preparedStatement.setString(2, user.getStaff_EMAIL());
		preparedStatement.setString(3, user.getStaff_PHONE());
		preparedStatement.setString(4, user.getStaff_ADDRESS());
		preparedStatement.setString(5, user.getStaff_PASSWORD());
		preparedStatement.setString(6, user.getStaff_ICNUM());
		preparedStatement.executeUpdate();
		conn.close();
	}
	
	
	public boolean doSearchDonor(Donor user) throws ClassNotFoundException, SQLException 
	{
		int x = 0;
		String sql = "select DONOR_NAME,DONOR_EMAIL,DONOR_PHONE,DONOR_ADDRESS,DONOR_BLOODGROUP from donor where DONOR_ICNUM = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getDonor_ICNUM());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			x=1;
			user.setDonor_NAME(resultSet.getString(1));
			user.setDonor_EMAIL(resultSet.getString(2));
			user.setDonor_PHONE(resultSet.getString(3));
			user.setDonor_ADDRESS(resultSet.getString(4));
			user.setDonor_BLOODGROUP(resultSet.getString(5));
		}
		conn.close();
		if(x==1)
			return true;
		return false;
		
	}
	
	public boolean doSearchAttendance(String donorIC, String eventID) throws ClassNotFoundException, SQLException 
	{
		int x = 0;
		String sql = "select ATTENDANCE_COUNT from eventattendance where DONOR_ICNUM = ? and EVENT_REFERID = ?";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, donorIC);
		preparedStatement.setString(2, eventID);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			x=1;
		}
		conn.close();
		if(x==1)
			return false;
		return true;
	}
	
	public int insertAttendance(String donorIC, String eventID) throws ClassNotFoundException, SQLException
	{
		int x=-1;
		String sql = "insert into eventattendance (DONOR_ICNUM,EVENT_REFERID) values (?,?)";
		Connection conn = MyDatabase.doConnection();
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, donorIC);
		preparedStatement.setString(2, eventID);
		x=preparedStatement.executeUpdate();
		conn.close();
		return x;
	}
	
	public static void main(String[] args) {
		
		UserController userController = new UserController();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
