package com.example.gridworld;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineStateTests {

	@Test
	public void MachineState_Default_Constructor() {
		MachineState target = new MachineState();

		assertEquals(Position.getDefault(), target.getPosition());
		assertEquals(Direction.getDefault(), target.getDirection());
	}

	@Test
	public void MachineState_Constructor() {
		Position expectedPosition = new Position(1,2);
		Vector expectedDirection = Direction.NESW.get(3);
		MachineState target = new MachineState(expectedPosition, expectedDirection);

		assertEquals(expectedPosition, target.getPosition());
		assertEquals(expectedDirection, target.getDirection());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void MachineState_Constructor_With_Invalid_Direction() {
		new MachineState(new Position(1,2), new Vector(1, 1));
	}

	@Test
	public void MachineState_Clockwise_Move_Rotates_Right_And_Steps() {

		// Default position is CellRef(0,0).
		// Default direction is east/right.
		MachineState target = new MachineState();

		target.clockwiseMove();

		assertEquals(new Position(0,-1), target.getPosition());
		assertEquals(Direction.rotateClockwise(Direction.getDefault()), target.getDirection());
	}

	@Test
	public void MachineState_Counter_Clockwise_Move_Rotates_Left_And_Steps() {

		// Default position is CellRef(0,0).
		// Default direction is east/right.
		MachineState target = new MachineState();

		target.counterClockwiseMove();

		assertEquals(new Position(0,1), target.getPosition());
		assertEquals(Direction.rotateCounterClockwise(Direction.getDefault()), target.getDirection());
	}
}
