package com.fis.app.exce;

public class NoDeviceFoundException extends Exception {
	private int Deviceid;
	
	public NoDeviceFoundException(int DeviceId)
	{
		this.Deviceid= DeviceId;
	}
	public String toString()
	{
		return "=== Device "+Deviceid+ " Not found ===";
	}

}
