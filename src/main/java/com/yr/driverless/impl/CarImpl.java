package com.yr.driverless.impl;

import com.yr.driverless.model.Car;
import com.yr.driverless.model.CarLocation;
import com.yr.driverless.model.CarPark;

/**
 * 
 * @author yr
 * @Date 2010-03-24
 * @Description 汽车实现类
 */
public class CarImpl implements Car {

	private CarPark carPark;
	private CarLocation carLocation;

	public CarImpl(CarPark carPark, CarLocation carLocation) {
		if (carLocation != null && carPark != null) {
			this.carLocation = carLocation;
			this.carPark = carPark;
		} else {
			throw new RuntimeException(" carLocation and carPark not null ");
		}
	}

	// 移动
	@Override
	public void move(String command) {

		//trun 转向
		if ("trun".equals(command)) {
			carLocation.moveOrientation();
		// 前进
		} else {
			//前进距离
			int distance = 1;
			if (check()) {
				switch (carLocation.getOrientation()) {
				case NORTH:
					carLocation.setLocat_y(getPositionY() + distance);
					break;
				case EAST:
					carLocation.setLocat_x(getPositionX() + distance);
					break;
				case SOUTH:
					carLocation.setLocat_y(getPositionY() - distance);
					break;
				case WEST:
					carLocation.setLocat_x(getPositionX() - distance);
					break;
				}

			}
		}

	}

	// 检查是否越界
	public boolean check() {
		switch (carLocation.getOrientation()) {
		case NORTH:
			if (carLocation.getLocat_y() + 1 >= carPark.getHight()) {
				throw new RuntimeException("不能再向北前进了，请更换前进方向！");
			}
			break;
		case EAST:
			if (carLocation.getLocat_x() + 1 >= carPark.getWidth()) {
				throw new RuntimeException("不能再向东前进了，请更换前进方向！");
			}
			break;
		case SOUTH:
			if (carLocation.getLocat_y() - 1 < 0) {
				throw new RuntimeException("不能再向南前进了，请更换前进方向！");
			}
			break;
		case WEST:
			if (carLocation.getLocat_x() - 1 < 0) {
				throw new RuntimeException("不能再向西前进了，请更换前进方向！");
			}
			break;
		}

		return true;
	}

	// 获取当前水平位置
	@Override
	public int getPositionX() {
		return carLocation.getLocat_x();
	}

	// 获取当前垂直位置
	@Override
	public int getPositionY() {
		return carLocation.getLocat_y();
	}

	// 获取当前朝向
	@Override
	public String getOrientation() {
		return carLocation.getOrientation().getDirection();
	}
	
	//输出当前位置、朝向
	@Override
	public String toString() {
		return "当前汽车位置  [x坐标为" + getPositionX() + ", y坐标为" + getPositionY() + " ,当前朝向为 "+getOrientation()+"]";
	}
	
	

}
