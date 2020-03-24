package com.yr.driverless.model;
/**
 * 
 * @author yr
 * @Date 2010-03-24
 * @Description 停车场
 */

public class CarPark {
	//停车场宽度
	private int width;
	//停车场长度
	private int hight;
	
	public CarPark(int width, int hight) {
		this.width = width;
		this.hight = hight;
	}

	@Override
	public String toString() {
		return "CarPark [width=" + width + ", hight=" + hight + "]";
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	
	
	
	
}
