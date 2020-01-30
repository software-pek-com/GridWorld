package com.example.gridworld;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectionTests {

	@Test
	public void Directions_There_Are_Four() {
		assertEquals(4, Direction.NESW.size());
	}

	@Test
	public void Directions_Are_In_NESW_Order() {
		assertEquals(new Vector(0,1), Direction.NESW.get(0));
		assertEquals(new Vector(1,0), Direction.NESW.get(1));
		assertEquals(new Vector(0,-1), Direction.NESW.get(2));
		assertEquals(new Vector(-1,0), Direction.NESW.get(3));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void Directions_Validates_Invalid() {
		Direction.validateAsDirection(new Vector(1,1));
	}

	@Test
	public void Directions_Validates_Valid() {
		Direction.validateAsDirection(new Vector(0,1));
	}

	@Test
	public void Directions_Gets_Default() {
		Vector target = Direction.getDefault();

		assertEquals(Direction.NESW.get(1), target);
	}
}
