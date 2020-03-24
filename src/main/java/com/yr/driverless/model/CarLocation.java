package com.yr.driverless.model;
/**
 * 
 * @author yr
 * @Date 2010-03-24
 * @Description 汽车位置
 */
public class CarLocation {
	//当前横坐标
	private int locat_x;
	//当前纵坐标
	private int locat_y;
	//当前朝向
	private CarDirection orientation;

	public CarLocation(int x,int y,CarDirection ori) {
		this.locat_x = x;
		this.locat_y = y;
		this.orientation = ori;
	}
	
	//改变朝向 顺时针
	public void moveOrientation() {
		
		switch (getOrientation()) {
		case NORTH:
			orientation = CarDirection.EAST;
			break;
		case EAST:
			orientation = CarDirection.SOUTH;
			break;
		case SOUTH:
			orientation = CarDirection.WEST;
			break;
		case WEST:
			orientation = CarDirection.NORTH;
			break;
		}
		
	}
	
	public int getLocat_x() {
		return locat_x;
	}

	public void setLocat_x(int locat_x) {
		this.locat_x = locat_x;
	}

	public int getLocat_y() {
		return locat_y;
	}

	public void setLocat_y(int locat_y) {
		this.locat_y = locat_y;
	}

	public CarDirection getOrientation() {
		return orientation;
	}

	public void setOrientation(CarDirection orientation) {
		this.orientation = orientation;
	}
	
	
	
	
	
}
