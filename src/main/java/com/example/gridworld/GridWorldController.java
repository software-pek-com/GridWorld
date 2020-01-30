package com.example.gridworld;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Represents a REST web controller for our GridWorld simulator.
 */
@RestController
public class GridWorldController {

	private static String nowAsString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss'Z'");
		Date dateobj = new Date();
		return dateFormat.format(dateobj);
	}

	@RequestMapping("/hello")
	public String index() {
		return "Greetings from Grid World! The time now is "+ nowAsString();
	}

	/**
	 * Controller method for the GridWorld simulation. The simulation performs
	 * 'moveCount' moves of the machine in the grid. After the simulation ends
	 * the resulting GridWorld snapshot (list of black cells, position and direction
	 * of the machine) is written to a file as JSON (for readability).
	 * 
	 * REMARKS
	 * Since the GridWorldSimulator always starts from the same position the
	 * same number of moves (in different simulations) results in the same GridWorld state.
	 * For this reason an optimization has been implemented which checks first if the
	 * given 'moveCount' simulation has already been done (the output file exists) and
	 * only performs the simulation if it hasn't.
	 * The returned response string reports what happened i.e. whether a new simulation file
	 * was created or if it existed already.
	 */
	@PutMapping("/simulate/{moveCount}")
	public String simulate(@PathVariable Integer moveCount) 
		throws Exception {

		// Use moveCount as the 'simulation identifier' because the same
		// move number always produces the same GridWorld.
		String fileName = String.format("%s.json", moveCount);
		String timeStamp = nowAsString();
		
		String response = String.format("Saved simulation in file '%s' at %s.", fileName, timeStamp);

		File simulationOutput = new File(fileName);

		// Check if simulation file already exists. Only do simulation
		// if it is not already there.
		if (simulationOutput.createNewFile()) {
			GridWorldSimulator gridWorld = new GridWorldSimulator();

			// Perform machine moves 'moveCount' timees.
			for (int i = 0; i < moveCount; ++i) {
				gridWorld.moveMachineOnce();
			}

			// Write GridWorld snapshot to file.
			Gson gson = new Gson();
			String snapshotAsJson = gson.toJson(gridWorld.getSnapshot());

			FileWriter writer = new FileWriter(simulationOutput);
			writer.write(snapshotAsJson);
			writer.close();

			response = String.format("New simulation saved in file '%s' [%s].", fileName, timeStamp);
		}
		else {
			// No need to simulate and write GridWorld state to file if file
			// already exists because it means this simulation has been done before.
			response = String.format("Simulation '%s' already existed [%s].", fileName, timeStamp);
		}

		return response;
	}
}
