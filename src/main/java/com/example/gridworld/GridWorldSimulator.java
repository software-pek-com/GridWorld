package com.example.gridworld;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.*;

class GridWorldSimulator {

    public GridWorldSimulator() {
        // Check parameters.
    }

    public void writeItAll() throws IOException {
        writeToFile("test.json");
    }

    private void writeToFile(String filename) throws IOException {

        JsonObject sampleObject = new JsonObject();
        sampleObject.addProperty("name", "Stackabuser");
        sampleObject.addProperty("age", 35);

        JsonArray messages = new JsonArray();
        messages.add("Hello!");
        messages.add("What's up?!");
        messages.add("Call me maybe!");

        sampleObject.add("messages", messages);

        Gson gson = new Gson();
        Path filepath = Paths.get(filename);
        Files.write(filepath, gson.toJson(sampleObject).getBytes());
    }
}