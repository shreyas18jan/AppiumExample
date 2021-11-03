Feature: Appium Automation Intro FeatureMultipleOf10

  @Regression @FeatureMultipleOf10
  Scenario: MultipleOf10 - Check and Assert Line Number 10 in Example Page 2
    Given open the App in emulator-5556
    When click on Example Page 2 button
    Then assert Line number 10
    And close the App

  @Regression @FeatureMultipleOf10
  Scenario: MultipleOf10 - Check and Assert Line Number 20 in Example Page 2
    Given open the App in emulator-5556
    When click on Example Page 2 button
    Then assert Line number 20
    And close the App

  @Regression @FeatureMultipleOf10
  Scenario: MultipleOf10 - Check and Assert Line Number 30 in Example Page 2
    Given open the App in emulator-5556
    When click on Example Page 2 button
    Then assert Line number 30
    And close the App