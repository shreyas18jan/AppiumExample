package com.example.appium.stepDefinition;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumDemoSteps {
    AndroidDriver<MobileElement> androidDriver = null;

    void prerequisite() throws MalformedURLException {
        if(androidDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "device");
            capabilities.setCapability("deviceOrientation", "portrait");
            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability("appPackage", "com.example.androidappexample");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appActivity", "com.example.androidappexample.MainActivity");
            androidDriver = new AndroidDriver<>(new URL("http://0.0.0.0:4720/wd/hub"), capabilities);
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    @Given("open the App")
    public void openTheApp() throws MalformedURLException {
        prerequisite();
    }

    @When("click on Example Page 1 button")
    public void clickExamplePage1Button() {
        MobileElement examplePage1Button = androidDriver.findElementById("ButtonLabel");
        if(!examplePage1Button.isEnabled()) {
            System.out.println(" Button Not Enabled yet!");
        }
        examplePage1Button.click();
    }

    @Then("assert Label Text")
    public void assertLabelText() throws InterruptedException {
        MobileElement labelCheck = androidDriver.findElementById("labelPageId");
        Assert.assertEquals("Label Data Mismatch", labelCheck.getText().trim(), "DEMO EXAMPLE FOR LABEL");
    }

    @When("click on Example Page 2 button")
    public void clickExamplePage2Button() {
        MobileElement examplePage2Button = androidDriver.findElementById("ButtonText");
        if(!examplePage2Button.isEnabled()) {
            System.out.println(" Button Not Enabled yet!");
        }
        examplePage2Button.click();
    }

    @Then("assert Line number 30")
    public void assertLineNumber() {
        MobileElement textCheck = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"30\"))"));
        Assert.assertEquals("Label Data Mismatch", textCheck.getText().trim(), "This is Line Number - 30");
    }
}
