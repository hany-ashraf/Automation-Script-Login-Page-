package com.tau.Runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.tau.steps"}, features = "src/test/resources/Login.feature", plugin = { "pretty", "html:target/site/cucumber-pretty",
		"json:target/cucumber.json" })

public class runnercucumbertest {
	
}