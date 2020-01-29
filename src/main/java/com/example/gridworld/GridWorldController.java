package com.example.gridworld;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@PutMapping("/save/{magicNumber}")
	public String saveToFile(@RequestBody String message, @PathVariable Integer magicNumber) 
		throws Exception {

		String timeStamp = nowAsString();
		String response = String.format("Saved %d as '%s' [%s].", magicNumber, message, timeStamp);
		String fileName = String.format("%s-%s.bytes", message, timeStamp);
		byte[] fileBytes = response.getBytes();

		FileOutputStream file = new FileOutputStream(fileName);
		file.write(fileBytes);
		file.close();

		GridWorldSimulator simulator = new GridWorldSimulator();
		simulator.writeItAll();

		return response;
	}

	@RequestMapping("/gridworld")
	public String gridWorld() {
		return "Greetings from the grid world!";
	}
}
