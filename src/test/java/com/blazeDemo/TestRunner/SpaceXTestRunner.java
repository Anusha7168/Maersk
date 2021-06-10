package com.blazeDemo.TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions( 
		monochrome=false,
		plugin= {"pretty", "html:target/cucumber-reports.html"},
        glue = {"com.blazeDemo.stepDefinitions"},
	    features = {"src/test/java/com/blazeDemo/features/spaceX.feature"},
	    tags= "@spaceX"
        )
public class SpaceXTestRunner  {

}
