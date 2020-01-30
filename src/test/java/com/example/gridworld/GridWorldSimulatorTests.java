package com.example.gridworld;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GridWorldSimulatorTests {

	class GridWorldSimulator_Accessor extends GridWorldSimulator
	{
		public GridWorldSimulator_Accessor() {
		}

		public GridWorldSimulator_Accessor(HashSet<Position> blacklist) {
			super(blacklist);
		}

		public HashSet<Position> getBlacklist_Accessor() {
			return getBlacklist();
		}
	}

	@Test
	public void GridWorldSimulator_Default_Constructor() {
		GridWorldSimulator_Accessor target = new GridWorldSimulator_Accessor();

		assertEquals(0, target.getBlacklist_Accessor().size());
		assertEquals(Position.getDefault(), target.getMachine().getPosition());
		assertEquals(Direction.getDefault(), target.getMachine().getDirection());
	}

	@Test
	public void GridWorldSimulator_IsCellBlack_For_Black() {
		Position blackPosition = new Position(0,1);
		HashSet<Position> expectedBlacklist = new HashSet<Position>();
		expectedBlacklist.add(blackPosition);
		GridWorldSimulator target = new GridWorldSimulator_Accessor(expectedBlacklist);

		assertThat(target.isCellBlack(blackPosition), is(true));
	}

	@Test
	public void GridWorldSimulator_IsCellBlack_For_White() {
		Position whitePosition = new Position(0,1);
		GridWorldSimulator target = new GridWorldSimulator_Accessor(new HashSet<Position>());

		assertThat(target.isCellBlack(whitePosition), is(false));
	}

	@Test
	public void GridWorldSimulator_ToggleCellColour_For_Black() {
		Position blackPosition = new Position(0,1);
		HashSet<Position> expectedBlacklist = new HashSet<Position>();
		expectedBlacklist.add(blackPosition);
		GridWorldSimulator target = new GridWorldSimulator_Accessor(expectedBlacklist);

		assertThat(target.isCellBlack(blackPosition), is(true));

		target.toggleCellColour(blackPosition);

		assertThat(target.isCellBlack(blackPosition), is(false));
	}

	@Test
	public void GridWorldSimulator_ToggleCellColour_For_White() {
		Position whitePosition = new Position(0,1);
		GridWorldSimulator target = new GridWorldSimulator_Accessor(new HashSet<Position>());

		assertThat(target.isCellBlack(whitePosition), is(false));

		target.toggleCellColour(whitePosition);

		assertThat(target.isCellBlack(whitePosition), is(true));
	}

	@Test
	public void GridWorldSimulator_MoveOnce_From_Black() {
		Position blackPosition = new Position(0,0);
		HashSet<Position> expectedBlacklist = new HashSet<Position>();
		expectedBlacklist.add(blackPosition);
		GridWorldSimulator target = new GridWorldSimulator_Accessor(expectedBlacklist);

		assertThat(target.isCellBlack(blackPosition), is(true));

		target.moveMachineOnce();

		assertThat(target.isCellBlack(blackPosition), is(false));
		assertEquals(new Position(0,1), target.getMachine().getPosition());
	}

	@Test
	public void GridWorldSimulator_MoveOnce_From_White() {
		Position whitePosition = new Position(0,0);
		GridWorldSimulator target = new GridWorldSimulator();

		assertThat(target.isCellBlack(whitePosition), is(false));

		target.moveMachineOnce();

		assertThat(target.isCellBlack(whitePosition), is(true));
		assertEquals(new Position(0,-1), target.getMachine().getPosition());
	}

	@Test
	public void GridWorldSimulator_Move_Five_Times_From_Defaults() {
		GridWorldSimulator_Accessor target = new GridWorldSimulator_Accessor();

		{
			Position position = target.getMachine().getPosition();
			assertThat(target.isCellBlack(position), is(false));

			target.moveMachineOnce();

			assertThat(target.isCellBlack(position), is(true));
			assertEquals(new Position(0,-1), target.getMachine().getPosition());
		}

		{
			Position position = target.getMachine().getPosition();
			assertThat(target.isCellBlack(position), is(false));

			target.moveMachineOnce();

			assertThat(target.isCellBlack(position), is(true));
			assertEquals(new Position(-1,-1), target.getMachine().getPosition());
		}

		{
			Position position = target.getMachine().getPosition();
			assertThat(target.isCellBlack(position), is(false));

			target.moveMachineOnce();

			assertThat(target.isCellBlack(position), is(true));
			assertEquals(new Position(-1,0), target.getMachine().getPosition());
		}

		{
			Position position = target.getMachine().getPosition();
			assertThat(target.isCellBlack(position), is(false));

			target.moveMachineOnce();

			assertThat(target.isCellBlack(position), is(true));
			assertEquals(new Position(0,0), target.getMachine().getPosition());
		}

		{
			Position position = target.getMachine().getPosition();
			assertThat(target.isCellBlack(position), is(true));

			target.moveMachineOnce();

			assertThat(target.isCellBlack(position), is(false)); // Was black now it is white again.
			assertEquals(new Position(0,1), target.getMachine().getPosition());
		}

		HashSet<Position> blacklist = target.getBlacklist();
		assertEquals(3, blacklist.size());
		assertThat(blacklist.contains(new Position(0,-1)), is(true));
		assertThat(blacklist.contains(new Position(-1,-1)), is(true));
		assertThat(blacklist.contains(new Position(-1,0)), is(true));
	}
}
