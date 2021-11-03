Feature: Appium Automation Intro FeatureMultipleOf3

  @Regression @FeatureMultipleOf3
  Scenario: MultipleOf3 - Check and Assert Line Number 3 in Example Page 2
    Given open the App in emulator-5554
    When click on Example Page 2 button
    Then assert Line number 3
    And close the App

  @Regression @FeatureMultipleOf3
  Scenario: MultipleOf3 - Check and Assert Line Number 6 in Example Page 2
    Given open the App in emulator-5554
    When click on Example Page 2 button
    Then assert Line number 6
    And close the App

  @Regression @FeatureMultipleOf3
  Scenario: MultipleOf3 - Check and Assert Line Number 9 in Example Page 2
    Given open the App in emulator-5554
    When click on Example Page 2 button
    Then assert Line number 9
    And close the App

  @Regression @FeatureMultipleOf3
  Scenario: MultipleOf3 - Check and Assert Line Number 12 in Example Page 2
    Given open the App in emulator-5554
    When click on Example Page 2 button
    Then assert Line number 12
    And close the App

  @Regression @FeatureMultipleOf3
  Scenario: MultipleOf3 - Check and Assert Line Number 15 in Example Page 2
    Given open the App in emulator-5554
    When click on Example Page 2 button
    Then assert Line number 15
    And close the App