package com.grcp.cucumber.component;

//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;
//
//import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
//
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("component/feature")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.grcp.cucumber")

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:component/feature")
public class CucumberRunnerIT {

}
