package com.example.gridworld;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VectorTests {

	class AnotherType {}

	@Test
	public void Vector_Default_Constructor() {
		Position target = Position.getDefault();

		assertEquals(0, target.getX());
		assertEquals(0, target.getY());
	}

	@Test
	public void Vector_Constructor() {
		Position target = new Position(-1,1);

		assertEquals(-1, target.getX());
		assertEquals(1, target.getY());
	}

	@Test
	public void Vector_getX() {
		Position target = new Position(-1,1);

		assertEquals(-1, target.getX());
	}

	@Test
	public void Vector_getY() {
		Position target = new Position(-1,1);

		assertEquals(1, target.getY());
	}

	@Test(expected = ClassCastException.class)
	public void Vector_Equals_Throws_When_Comparing_To_Another_Type() {
		Position target1 = new Position(-1,1);

		target1.equals((Object)new AnotherType());
	}

	@Test
	public void Vector_Not_Equals() {
		Position target1 = new Position(-1,-1);
		Position target2 = new Position(-1,1);

		assertThat(target2.equals(target1), is(false));
		assertNotEquals(target1, target2);
	}

	@Test
	public void Vector_Equals() {
		Position target1 = new Position(-1,1);
		Position target2 = new Position(-1,1);

		assertThat(target2.equals(target1), is(true));
		assertEquals(target1, target2);
	}

	@Test
	public void Vector_Same_Hash() {
		Position target1 = new Position(-1,1);
		Position target2 = new Position(-1,1);

		assertEquals(target1.hashCode(), target2.hashCode());
	}

	@Test
	public void Vector_Different_Hash() {
		Position target1 = new Position(-1,-1);
		Position target2 = new Position(-1,1);

		assertNotEquals(target1.hashCode(), target2.hashCode());
	}
}
