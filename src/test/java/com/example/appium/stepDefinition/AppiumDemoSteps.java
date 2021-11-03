package com.example.appium.stepDefinition;

import com.example.appium.AppiumDemoUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AppiumDemoSteps {
    AppiumDemoUtils appiumDemoUtils = new AppiumDemoUtils();

    @Given("open the App in (.*)$")
    public void openTheApp(String udid) throws Exception {
        System.out.println(" Current ThreadID - " + Thread.currentThread().getId());
        int serverPort = 0;
        int port = 0;

        if(udid.trim().equals("emulator-5556")) {
            serverPort = 4726;
            port = 8226;
        }
        else if(udid.trim().equals("emulator-5554"))
        {
            serverPort = 4724;
            port = 8224;
        }
        else
            throw new Exception("Device Details not present!");

        appiumDemoUtils.initiateDriver(udid, serverPort, port);
    }

    @When("click on Example Page 1 button")
    public void clickExamplePage1Button() {
        MobileElement examplePage1Button = appiumDemoUtils.getDriver().findElementById("ButtonLabel");
        if(!examplePage1Button.isEnabled()) {
            System.out.println(" Button Not Enabled yet!");
        }
        examplePage1Button.click();
    }

    @Then("assert Label Text")
    public void assertLabelText() throws InterruptedException {
        MobileElement labelCheck = appiumDemoUtils.getDriver().findElementById("labelPageId");
        Assert.assertEquals("Label Data Mismatch", labelCheck.getText().trim(), "DEMO EXAMPLE FOR LABEL");
    }

    @When("click on Example Page 2 button")
    public void clickExamplePage2Button() {
        MobileElement examplePage2Button = appiumDemoUtils.getDriver().findElementById("ButtonText");
        if(!examplePage2Button.isEnabled()) {
            System.out.println(" Button Not Enabled yet!");
        }
        examplePage2Button.click();
    }

    @Then("assert Line number (.*?)$")
    public void assertLineNumber(int lineNumber) {
        MobileElement textCheck = appiumDemoUtils.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + lineNumber + "\"))"));
        Assert.assertEquals("Label Data Mismatch", "This is Line Number - " + lineNumber, textCheck.getText().trim());
    }

    @And("close the App")
    public void closeTheApp() {
        appiumDemoUtils.closeDriver();
    }
}
