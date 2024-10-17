package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	  public static List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

	        //conver json file content to json string
	        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),
	                StandardCharsets.UTF_8);

	        ObjectMapper mapper = new ObjectMapper();
	        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	        });

	        return data;


	    }
	  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Convert json file into String
		
		String jsonData = FileUtils.readFileToString(new File("D:\\Automation\\TestAutomation\\test.json"),StandardCharsets.UTF_8);
		System.out.println(jsonData);
		ObjectMapper objectMapper =new ObjectMapper();
		
		  List<HashMap<String,String>> data = objectMapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {
	        });
		 // List<HashMap<String,String>> d= getJsonData("D:\\Automation\\TestAutomation\\test.json");
		  System.out.println(data);
		 
		

	}

}
