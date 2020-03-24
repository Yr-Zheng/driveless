package com.yr.driverless;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.yr.driverless.impl.CarImpl;
import com.yr.driverless.model.Car;
import com.yr.driverless.model.CarDirection;
import com.yr.driverless.model.CarLocation;
import com.yr.driverless.model.CarPark;

/**
 * 
 * @author yr
 * @Date 2010-03-24
 * @Description 汽车自动化测试
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {

	private CarPark carPark;
	private CarLocation carLocation;
	private Car car;

	// 初始化
	@Before
	public void setUp() {
		// 停车场大小
		carPark = new CarPark(4, 4);
		// 初始位置和朝向
		carLocation = new CarLocation(0, 0, CarDirection.NORTH);
		car = new CarImpl(carPark, carLocation);
	}

	// 测试转向
	@Test
	public void testACarTurn() {
		// 当前朝向 [北]
		assertEquals(CarDirection.NORTH.getDirection(), car.getOrientation());
		// 北转东
		car.move("trun");
		assertEquals(CarDirection.EAST.getDirection(), car.getOrientation());
		// 东转南
		car.move("trun");
		assertEquals(CarDirection.SOUTH.getDirection(), car.getOrientation());
		// 南转西
		car.move("trun");
		assertEquals(CarDirection.WEST.getDirection(), car.getOrientation());
		// 西转北
		car.move("trun");
		assertEquals(CarDirection.NORTH.getDirection(), car.getOrientation());
	}

	// 测试正常移动和转向
	@Test
	public void testBNormalMove() {
		// 向北移动
		car.move("forward");
		assertEquals(0, car.getPositionX());
		assertEquals(1, car.getPositionY());
		// 向东移动
		car.move("trun");
		car.move("forward");
		assertEquals(1, car.getPositionX());
		assertEquals(1, car.getPositionY());
		// 向南移动
		car.move("trun");
		car.move("forward");
		assertEquals(1, car.getPositionX());
		assertEquals(0, car.getPositionY());
		// 向西移动
		car.move("trun");
		car.move("forward");
		assertEquals(0, car.getPositionX());
		assertEquals(0, car.getPositionY());
	}

	// 测试越界移动
	@Test
	public void testCCarMove() {

		// 移动到左上边界
		for (int i = 0; i < carPark.getHight() - 1; i++) {
			car.move("forward");
		}
		assertEquals(0, car.getPositionX());
		assertEquals(carPark.getHight() - 1, car.getPositionY());
		// 再次往北移动 预期报异常
		try {
			car.move("forward");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
			assertTrue(e.getMessage().contains("不能再向北前进了，请更换前进方向"));
		}
		// 转向 移动到右上边界
		car.move("trun");
		for (int i = 0; i < carPark.getWidth() - 1; i++) {
			car.move("forward");
		}
		// 再次往东移动 预期报异常
		try {
			car.move("forward");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
			assertTrue(e.getMessage().contains("不能再向东前进了，请更换前进方向"));
		}
		// 转向 移动到右下边界
		car.move("trun");
		for (int i = 0; i < carPark.getHight() - 1; i++) {
			car.move("forward");
		}
		// 再次往东移动 预期报异常
		try {
			car.move("forward");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
			assertTrue(e.getMessage().contains("不能再向南前进了，请更换前进方向"));
		}
		// 转向 移动到左下边界
		car.move("trun");
		for (int i = 0; i < carPark.getWidth() - 1; i++) {
			car.move("forward");
		}
		// 再次往西移动 预期报异常
		try {
			car.move("forward");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
			assertTrue(e.getMessage().contains("不能再向西前进了，请更换前进方向"));
		}

	}

}
