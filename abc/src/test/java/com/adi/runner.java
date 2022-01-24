package com.adi;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
						monochrome = true,
                     	features = "src/test/java/resources/",
                        plugin = { "pretty","html:target/cucumber-html-reports.html", "json: target/cucumber/cucumber.json" },
						glue = "com.adi",
						tags = "@test1"
						
						)

public class runner extends AbstractTestNGCucumberTests {
	
	@After
	public static void tearDown( ) {
		hooks.tearDown();
	}

}

