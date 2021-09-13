Feature: Appium Automation Intro

  Scenario: Open Android App Example And check Example Page 1
    Given open the App
    When click on Example Page 1 button
    Then assert Label Text

  Scenario: Open Android App Example And check Example Page 2
    Given open the App
    When click on Example Page 2 button
    Then assert Line number 30