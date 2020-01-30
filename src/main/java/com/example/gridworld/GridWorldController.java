package com.example.gridworld;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GridWorldController {

	private static String nowAsString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss'Z'");
		Date dateobj = new Date();
		return dateFormat.format(dateobj);
	}

	@RequestMapping("/hello")
	public String index() {
		String response = "Greetings from Spring Boot! Time now is ";
		return response + nowAsString();
	}

	@PutMapping("/save/{moveCount}")
	public String saveToFile(@RequestBody String message, @PathVariable Integer moveCount) 
		throws Exception {

		// Use moveCount as the 'simulation identifier' because the same
		// move number always produces the same GridWorld.
		String fileName = String.format("%s.json", moveCount);
		String timeStamp = nowAsString();
		
		String response = String.format("Saved simulation in file '%s' at %s.", fileName, timeStamp);

		File simulationOutput = new File(fileName);

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

			response = String.format("Saved simulation in file '%s' [%s].", fileName, timeStamp);
		}
		else {
			// No need to simulate and write GridWorld state to file if
			// file already exists because it means this simulation has been done.
			response = String.format("Simulation '%s' already exists [%s].", fileName, timeStamp);
		}

		return response;
	}

	@RequestMapping("/gridworld")
	public String gridWorld() {
		GridWorldSimulator gridWorld = new GridWorldSimulator();

		gridWorld.moveMachineOnce();
		gridWorld.moveMachineOnce();
		gridWorld.moveMachineOnce();
		gridWorld.moveMachineOnce();
		
		Gson gson = new Gson();
        String json = gson.toJson(gridWorld.getSnapshot());

		return json;
	}
}
