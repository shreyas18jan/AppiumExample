package com.example.appium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/example/appium/features",
        glue={"com.example.appium.stepDefinition"},
        tags = "@Regression1",
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class AppiumDemoRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
