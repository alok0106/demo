package com.Demoblaze;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static Scenario myscenario;
	public static Boolean failedScenario = false;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		myscenario = scenario;
		
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		if (scenario.isFailed()) {
			
			failedScenario = true;
		}
		
	}
	public static void tearDown() {
		
		File currentFile = new File(".");
		String helper = currentFile.getAbsolutePath();
		String path = helper.replace(".", "");
		File outputDirectory = new File("target");
		List<String> jsonFile = new ArrayList();
		jsonFile.add(path + "target/cucumber.json" );
		
	}

}
