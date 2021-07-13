package src.com.fis.app.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fis.app.exce.NoDeviceFoundException;

public abstract class ElectronicDeviceDAOImpl implements IElectronicDeviceDAO {
	Connection con = null;
	
	String insertDevice = "insert into Employee.employee values(?,?,?,?,?)";
	String selectAllDevices = "select * from Employee.employee";
	String updateCost=" update Employee.employee set cost=?, where deviceID=?";
	String updateRating = "update Employee.employee set starRatings =? where deviceId=?";
	String deleteEntry = "delete from Employee.employee where deviceId=?";
	String displayBaesdType= "select * from Employee.employee group by brandName,deviceType";
	String countType= " select deviceType,count(deviceType) as Count from Employee.employee group by deviceType";
	String sumPrice="select deviceType,sum(cost)as Sum from Employee.employee group by deviceType";


	@Override
	public boolean addDevice(ElectrnoicDevice device) throws SQLException {
		// TODO Auto-generated method stub
		con= DatabaseUtil.getConnection();
		boolean isInserted = false;
		if(con!=null)
		{
			int id= device.getDeviceId();
			String brand=device.getBrandName();
			int cost = device.getCost();
			int power = device.getPower();
			int rating= device.getStarRatings();
			String color = device.getColor();
			
			PreparedStatement ps= con.prepareStatement(insertDevice);
			ps.setInt(1, id);
			ps.setString(2, brand);
            ps.setInt(3, cost);	
            ps.setInt(4, power);
            ps.setInt(5, rating);
            ps.setString(6, color);
            
            int i = ps.executeUpdate();
            if(i > 0)
            	isInserted = true;
		}
		return isInserted;
	}
	@Override
	public List<ElectrnoicDevice> getAllDevices() throws SQLException {
		// TODO Auto-generated method stub
		con = DatabaseUtil.getConnection();
		List<ElectrnoicDevice> electronicsList= new ArrayList<>();
		if(con != null)
		{
			PreparedStatement ps = con.prepareStatement(selectAllDevices);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ElectrnoicDevice temp= new ElectrnoicDevice();
				temp.setDeviceId(rs.getInt(1));
			    temp.getDeviceType();
				temp.setBrandName(rs.getString(3));
				temp.setCost(rs.getInt(4));
				temp.setPower(rs.getInt(5));
				temp.setStarRatings(rs.getInt(6));
				temp.setColor(rs.getString(7));
		electronicsList.add(temp);
				
			}
		}
	return electronicsList;
	}


			@Override
	public boolean changeDevicePrice(int deviceId, int newPrice)
			throws NoDeviceFoundException, SQLException {
		// TODO Auto-generated method stub
				con = DatabaseUtil.getConnection();
				boolean isUpdated = false;
				if(con!=null)
					try {
						{
							PreparedStatement ps = con.prepareStatement(updateCost);
							ps.setInt(1, deviceId);
							ps.setInt(2, newPrice);
							int i = ps.executeUpdate();
							System.out.println("i=" +i);
							if(i>0)
								isUpdated= true;
							
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return isUpdated;
	}
			
					@Override
			public boolean changeDeviceRating(int deviceId,
					int newRating) throws NoDeviceFoundException, SQLException {
				// TODO Auto-generated method stub
						con = DatabaseUtil.getConnection();
						boolean isUpdated = false;
						if(con!=null){
							PreparedStatement ps = con.prepareStatement(updateRating);
							ps.setInt(1, deviceId);
							ps.setInt(2, newRating);
							int i = ps.executeUpdate();
							System.out.println("i=" +i);
							if(i>0)
								isUpdated= true;
							
						}
							return isUpdated;
			}
	
										
	
	@Override
					public boolean deleteDevice(int deviceId) throws SQLException,
							NoDeviceFoundException {
						// TODO Auto-generated method stub
		con = DatabaseUtil.getConnection();
		boolean isUpdated = false;
		if(con!=null){
			PreparedStatement ps = con.prepareStatement(deleteEntry);
			ps.setInt(1, deviceId);
			int i = ps.executeUpdate();
			System.out.println("i=" +i);
			if(i>0)
				isUpdated= true;
			
		}
			return isUpdated;
					}
	@Override
			public List<ElectrnoicDevice> geDevicesBasedOnBrandNameAndType(
			String brandName, String type) throws SQLException
			{
		    con = DatabaseUtil.getConnection();
		    List<ElectrnoicDevice> ellectronicList = new ArrayList<>();
		    if(con!=null){
				PreparedStatement ps = con.prepareStatement(displayBaesdType);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					ElectrnoicDevice temp= new ElectrnoicDevice();
					temp.setDeviceId(rs.getInt(1));
					temp.setDeviceType(rs.getString(2));
					temp.setBrandName(rs.getString(3));
					temp.setCost(rs.getInt(4));
					temp.setPower(rs.getInt(5));
					temp.setStarRatings(rs.getInt(6));
					
					temp.setColor(rs.getString(7));
			        electronicsList.add(temp);
				}
		    
		    }
		    return ellectronicList;
			}
	@Override
	public int countDeviceType(String type) throws SQLException {
		con = DatabaseUtil.getConnection();
		int count = 0;
		if( con != null){
			PreparedStatement ps = con.prepareStatement(countType);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				count = rs.getInt("Count");
				String dtype = rs.getString("deviceType");
				System.out.println(dtype+"-"+count);
			}
		}
	return count;
	}
	
	