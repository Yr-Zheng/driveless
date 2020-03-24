package com.yr.driverless.model;

/**
 * 
 * @author yr
 * @Date 2010-03-24
 * @Description 汽车接口
 */
public interface Car {
	void move(String command);

	int getPositionX();

	int getPositionY();

	String getOrientation();
}
