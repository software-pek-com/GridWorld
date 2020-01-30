package com.example.gridworld;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionTests {

	class AnotherType {}

	@Test
	public void Position_Default_Constructor() {
		Position target = Position.getDefault();

		assertEquals(0, target.getX());
		assertEquals(0, target.getY());
	}

	@Test
	public void Position_Constructor() {
		Position target = new Position(-1,1);

		assertEquals(-1, target.getX());
		assertEquals(1, target.getY());
	}

	@Test
	public void Position_getX() {
		Position target = new Position(-1,1);

		assertEquals(-1, target.getX());
	}

	@Test
	public void Position_getY() {
		Position target = new Position(-1,1);

		assertEquals(1, target.getY());
	}

	@Test(expected = ClassCastException.class)
	public void Position_Equals_Throws_When_Comparing_To_Another_Type() {
		Position target1 = new Position(-1,1);

		target1.equals(new AnotherType());
	}

	@Test
	public void Position_Not_Equals_When_Cells_Have_Different_Coordinates() {
		Position target1 = new Position(-1,-1);
		Position target2 = new Position(-1,1);

		assertThat(target2.equals(target1), is(false));
		assertNotEquals(target1, target2);
	}

	@Test
	public void Position_Equals_When_Cells_Have_Same_Coordinates() {
		Position target1 = new Position(-1,1);
		Position target2 = new Position(-1,1);

		assertThat(target2.equals(target1), is(true));
		assertEquals(target1, target2);
	}

	@Test
	public void Position_Same_Hash_Code_With_Same_Coordinates() {
		Position target1 = new Position(-1,1);
		Position target2 = new Position(-1,1);

		assertEquals(target1.hashCode(), target2.hashCode());
	}

	@Test
	public void Position_Different_Hash_Code_With_Different_Coordinates() {
		Position target1 = new Position(-1,-1);
		Position target2 = new Position(-1,1);

		assertNotEquals(target1.hashCode(), target2.hashCode());
	}
}
