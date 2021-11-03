package com.example.appium.stepDefinition;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AppiumDemoSteps {

    @Given("open the App in (.*)$")
    public void openTheApp(String udid) throws Exception {
        System.out.println(" Current ThreadID - " + Thread.currentThread().getId());
        int port = 0;

        if(udid.trim().equals("emulator-5556"))
            port = 8226;
        else if(udid.trim().equals("emulator-5554"))
            port = 8224;
        else
            throw new Exception("Device Details not present!");

        AppiumDemoUtils.preRequisite(udid, port);
    }

    @When("click on Example Page 1 button")
    public void clickExamplePage1Button() {
        MobileElement examplePage1Button = AppiumDemoUtils.getDriver().findElementById("ButtonLabel");
        if(!examplePage1Button.isEnabled()) {
            System.out.println(" Button Not Enabled yet!");
        }
        examplePage1Button.click();
    }

    @Then("assert Label Text")
    public void assertLabelText() throws InterruptedException {
        MobileElement labelCheck = AppiumDemoUtils.getDriver().findElementById("labelPageId");
        Assert.assertEquals("Label Data Mismatch", labelCheck.getText().trim(), "DEMO EXAMPLE FOR LABEL");
    }

    @When("click on Example Page 2 button")
    public void clickExamplePage2Button() {
        MobileElement examplePage2Button = AppiumDemoUtils.getDriver().findElementById("ButtonText");
        if(!examplePage2Button.isEnabled()) {
            System.out.println(" Button Not Enabled yet!");
        }
        examplePage2Button.click();
    }

    @Then("assert Line number (.*?)$")
    public void assertLineNumber(int lineNumber) {
        MobileElement textCheck = AppiumDemoUtils.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + lineNumber + "\"))"));
        Assert.assertEquals("Label Data Mismatch", "This is Line Number - " + lineNumber, textCheck.getText().trim());
    }

    @After
    @And("close the App")
    public void closeTheApp() {
        AppiumDemoUtils.getDriver().quit();
    }
}
