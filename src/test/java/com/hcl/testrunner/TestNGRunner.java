package com.hcl.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "@Smoke", 
				 features = {"features"}, 
				 glue = {"com.hcl.stepdef"},
				 plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
				 //plugin = { "pretty", "html:target/cucumber-reports.html" },
				 monochrome = true
				)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    
}