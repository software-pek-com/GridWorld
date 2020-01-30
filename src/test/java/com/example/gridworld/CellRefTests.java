package com.example.gridworld;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CellRefTests {

	class AnotherType {}

	@Test
	public void CellRef_Default_Constructor() {
		CellRef target = CellRef.getDefault();

		assertEquals(0, target.getX());
		assertEquals(0, target.getY());
	}

	@Test
	public void CellRef_Constructor() {
		CellRef target = new CellRef(-1,1);

		assertEquals(-1, target.getX());
		assertEquals(1, target.getY());
	}

	@Test
	public void CellRef_getX() {
		CellRef target = new CellRef(-1,1);

		assertEquals(-1, target.getX());
	}

	@Test
	public void CellRef_getY() {
		CellRef target = new CellRef(-1,1);

		assertEquals(1, target.getY());
	}

	@Test(expected = ClassCastException.class)
	public void CellRef_Equals_Throws_When_Comparing_To_Another_Type() {
		CellRef target1 = new CellRef(-1,1);

		target1.equals(new AnotherType());
	}

	@Test
	public void CellRef_Not_Equals_When_Cells_Have_Different_Coordinates() {
		CellRef target1 = new CellRef(-1,-1);
		CellRef target2 = new CellRef(-1,1);

		assertThat(target2.equals(target1), is(false));
		assertNotEquals(target1, target2);
	}

	@Test
	public void CellRef_Equals_When_Cells_Have_Same_Coordinates() {
		CellRef target1 = new CellRef(-1,1);
		CellRef target2 = new CellRef(-1,1);

		assertThat(target2.equals(target1), is(true));
		assertEquals(target1, target2);
	}

	@Test
	public void CellRef_Same_Hash_Code_With_Same_Coordinates() {
		CellRef target1 = new CellRef(-1,1);
		CellRef target2 = new CellRef(-1,1);

		assertEquals(target1.hashCode(), target2.hashCode());
	}

	@Test
	public void CellRef_Different_Hash_Code_With_Different_Coordinates() {
		CellRef target1 = new CellRef(-1,-1);
		CellRef target2 = new CellRef(-1,1);

		assertNotEquals(target1.hashCode(), target2.hashCode());
	}
}
