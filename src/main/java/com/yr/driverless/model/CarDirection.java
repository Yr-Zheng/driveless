package com.yr.driverless.model;
/**
 * 
 * @author yr
 * @Date 2010-03-24
 * @Description 汽车方向
 */
public enum CarDirection {
	NORTH("North"),
	EAST("East"),
	SOUTH("South"),
	WEST("West");
	
	private String direction;
	
	private CarDirection(String direction) {
		this.direction = direction;
	}
	
	public String getDirection() {
		return direction;
	}
	
}
