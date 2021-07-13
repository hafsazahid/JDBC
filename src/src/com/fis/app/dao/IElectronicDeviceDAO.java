package src.com.fis.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.fis.app.exce.NoDeviceFoundException;
import com.fis.app.model.ElectrnoicDevice;

public interface IElectronicDeviceDAO<ElectrnoicDevice> {

	
	public boolean addDevice1(ElectrnoicDevice device);
	public List<ElectrnoicDevice> getAllDevices() throws SQLException;
	
	public ElectrnoicDevice changeDevicePrice(int deviceId,int newPrice)throws NoDeviceFoundException;
	public ElectrnoicDevice changeDeviceRating(int deviceId,int newRating)throws NoDeviceFoundException;
	
	public boolean deleteDevice(int deviceId)throws NoDeviceFoundException, SQLException;
	
	public List<ElectrnoicDevice> geDevicesBasedOnBrandNameAndType(String brandName,String type) throws SQLException;
	public int countDeviceType(String type) throws SQLException;
	public List getSumofPriceBasedOnType(String type);
	
	public List<ElectrnoicDevice> getDevicesBasedOnPriceRangeandType(int range1, int range2,String type, List<ElectrnoicDevice>ls) throws SQLException;
	boolean addDevice(ElectrnoicDevice device) throws SQLException;
	
}
