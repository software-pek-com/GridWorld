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

		assertEquals(new CellRef(), target.getPosition());
		assertEquals(Direction.NESW.get(1), target.getDirection());
	}

	@Test
	public void MachineState_Constructor() {
		CellRef expectedPosition = new CellRef(1,2);
		Vector expectedDirection = Direction.NESW.get(3);
		MachineState target = new MachineState(expectedPosition, expectedDirection);

		assertEquals(expectedPosition, target.getPosition());
		assertEquals(expectedDirection, target.getDirection());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void MachineState_Constructor_With_Invalid_Direction() {
		new MachineState(new CellRef(1,2), new Vector(1, 1));
	}

	@Test
	public void MachineState_Set_Direction() {

		MachineState target = new MachineState();

		Vector expectedDirection = Direction.NESW.get(3);
		target.setDirection(expectedDirection);

		assertEquals(expectedDirection, target.getDirection());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void MachineState_Set_Direction_Invalid() {

		MachineState target = new MachineState();
		target.setDirection(new Vector(1, 1));
	}

	@Test
	public void MachineState_Moves_In_Direction_1() {
		
		MachineState target = new MachineState(new CellRef(), Direction.NESW.get(0));

		CellRef position = target.getPosition();
		Vector direction = target.getDirection();
		
		target.moveInDirection();

		CellRef expectedPosition = new CellRef(
			position.getX() + direction.getX(), position.getY() + direction.getY()
		);

		assertEquals(expectedPosition, target.getPosition());
		assertEquals(direction, target.getDirection());
	}

	@Test
	public void MachineState_Moves_In_Direction_2() {
		
		MachineState target = new MachineState(new CellRef(), Direction.NESW.get(1));

		CellRef position = target.getPosition();
		Vector direction = target.getDirection();
		
		target.moveInDirection();

		CellRef expectedPosition = new CellRef(
			position.getX() + direction.getX(), position.getY() + direction.getY()
		);

		assertEquals(expectedPosition, target.getPosition());
		assertEquals(direction, target.getDirection());
	}

	@Test
	public void MachineState_Moves_In_Direction_3() {
		
		MachineState target = new MachineState(new CellRef(), Direction.NESW.get(2));

		CellRef position = target.getPosition();
		Vector direction = target.getDirection();
		
		target.moveInDirection();

		CellRef expectedPosition = new CellRef(
			position.getX() + direction.getX(), position.getY() + direction.getY()
		);

		assertEquals(expectedPosition, target.getPosition());
		assertEquals(direction, target.getDirection());
	}

	@Test
	public void MachineState_Moves_In_Direction_4() {
		
		MachineState target = new MachineState(new CellRef(), Direction.NESW.get(3));

		CellRef position = target.getPosition();
		Vector direction = target.getDirection();
		
		target.moveInDirection();

		CellRef expectedPosition = new CellRef(
			position.getX() + direction.getX(), position.getY() + direction.getY()
		);

		assertEquals(expectedPosition, target.getPosition());
		assertEquals(direction, target.getDirection());
	}
}
