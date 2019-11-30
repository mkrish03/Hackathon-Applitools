#Author: Krishna Kumar Mohan
#Keywords Summary : Automation using Visual AI

#@VisualAI
Feature: Visual AI Test Suite

  @VisualAI
  Scenario: Verify the Demo APP
    Given Launch the Demo APP version2
    Then Verify login page
    And Click on the  login button
    Then Verify the no credentials warning message
    When Enter Username
    And Click on the  login button
    Then Verify the Password warning message
    And Clear Username field
    And Enter Password
    And Click on Login
    Then Verify the Username warning message
    And Enter Username
    And Enter Password
    And Click on Login
    Then Verify the Home page
    And Click on Amount
    Then Verify the Amount sorting
    And Click on Compare Expenses
    Then Verify the Canvas chart page
    And Launch the Demo GIF APP version
    And Enter Username
    And Enter Password
    And Click on Login
    Then Verify the GIF Image


