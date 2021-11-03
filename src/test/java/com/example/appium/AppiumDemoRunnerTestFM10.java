package com.example.appium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/example/appium/",
        tags = "@FeatureMultipleOf10",
        glue={"com.example.appium.stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports-FM10.html"})
public class AppiumDemoRunnerTestFM10 {
}
