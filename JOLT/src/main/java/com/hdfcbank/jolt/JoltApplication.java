package com.hdfcbank.jolt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

@SpringBootApplication
public class JoltApplication {

	public static void main(String[] args) {
		
		String inputSpecFile = "joltspec.json"; 
		String specJson = readJsonFile(inputSpecFile);
		Object spec = JsonUtils.jsonToObject(specJson);

	  // Loading input JSON data
	  String inputFilePath = "input.json"; 
	  String inputData = readJsonFile(inputFilePath);
	  Object inputJson = JsonUtils.jsonToObject(inputData);

	  // Applying JOLT transformation
	  Chainr chainr = Chainr.fromSpec(Collections.singletonList(spec));
	  Object outputJson = chainr.transform(inputJson);

	  // Output the transformed JSON
	  String outputFilePath = "output.json"; 
	  writeJsonFile(outputFilePath, JsonUtils.toJsonString(outputJson));
	}

	private static String readJsonFile(String filePath) {
	  try {
	      Path path = Paths.get(filePath);
	      return new String(Files.readAllBytes(path));
	  } catch (IOException e) {
	      e.printStackTrace();
	      return null;
	  }
	}

	private static void writeJsonFile(String filePath, String jsonContent) {
	  try {
	      Path path = Paths.get(filePath);
	      Files.write(path, jsonContent.getBytes());
	      System.out.println("Transformation result written to: " + filePath);
	  } catch (IOException e) {
	      e.printStackTrace();
	  }
	
	}
}




	
	
	
	
	
	
/*	
	
//  String specJson = "{ \"operation\": \"shift\", \"spec\": { \"name\": \"employeeName\", \"age\": \"employeeAge\", \"address\": \"employeeAddress\" } }";
	String inputSpecFile = "joltspec.json"; 
	String specJson = readJsonFile(inputSpecFile);
	Object spec = JsonUtils.jsonToObject(specJson);

  // Loading input JSON data
  String inputFilePath = "input.json"; 
  String inputData = readJsonFile(inputFilePath);
  Object inputJson = JsonUtils.jsonToObject(inputData);

  // Applying JOLT transformation
  Chainr chainr = Chainr.fromSpec(Collections.singletonList(spec));
  Object outputJson = chainr.transform(inputJson);

  // Output the transformed JSON
  String outputFilePath = "output.json"; 
  writeJsonFile(outputFilePath, JsonUtils.toJsonString(outputJson));
}

private static String readJsonFile(String filePath) {
  try {
      Path path = Paths.get(filePath);
      return new String(Files.readAllBytes(path));
  } catch (IOException e) {
      e.printStackTrace();
      return null;
  }
}

private static void writeJsonFile(String filePath, String jsonContent) {
  try {
      Path path = Paths.get(filePath);
      Files.write(path, jsonContent.getBytes());
      System.out.println("Transformation result written to: " + filePath);
  } catch (IOException e) {
      e.printStackTrace();
  }
}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
String specJson = "{ \"operation\": \"shift\", \"spec\": { \"name\": \"employeeName\", \"age\": \"employeeAge\", \"address\": \"employeeAddress\" } }";
        Object spec = JsonUtils.jsonToObject(specJson);

        // Create a Chainr instance with the specified transformation
        Chainr chainr = Chainr.fromSpec(Collections.singletonList(spec));

        // Input JSON data
        String inputData = "{ \"name\": \"John\", \"age\": 30, \"address\": \"123 Main St\" }";
        Object inputJson = JsonUtils.jsonToObject(inputData);

        // Apply the transformation
        Object outputJson = chainr.transform(inputJson);

        // Convert the output to a JSON string
        String outputData = JsonUtils.toJsonString(outputJson);
        System.out.println(outputData);
*/


/*
Chainr chainr=ChainrFactory.fromClassPath("/joltspec.json");

Object output=chainr.transform(JsonUtils.classpathToObject("/input.json"));

System.out.println("Output:\n"+JsonUtils.toPrettyJsonString(output));
*/