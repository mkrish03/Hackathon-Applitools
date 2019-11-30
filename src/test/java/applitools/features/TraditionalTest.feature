#Author: Krishna Kumar Mohan
#Keywords Summary : Automation using Traditional way

#@Traditional
Feature: Traditional Test Suite

  @Traditional
  Scenario: Verify No Credentials Login Page warning message
    Given Launch the Demo APP
    When Click on Login
    Then Verify No Credentials Warning message

  @Traditional
  Scenario: Verify Password warning message
    Given Launch the Demo APP
    And Enter Username
    And Click on Login
    Then Verify Password Warning message

  @Traditional
  Scenario: Verify Username warning message
    Given Launch the Demo APP
    And Enter Password
    And Click on Login
    Then Verify Username Warning message

  @Traditional
  Scenario: Verify Login using valid credentails
    Given Launch the Demo APP
    When Enter Username
    And Enter Password
    And Click on Login
    Then Verify homepage is displayed

  @Traditional
  Scenario: Verify Amount sorting
    Given Launch the Demo APP
    When Enter Username
    And Enter Password
    And Click on Login
    And Click on Amount
    Then Verify the Sorting order of amount

  @Traditional
  Scenario: Verify the canvas chart
    Given Launch the Demo APP
    When Enter Username
    And Enter Password
    And Click on Login
    And Click on Compare Expenses
    Then Verify the Canvas chart

  @Traditional
  Scenario: Verify the gif image
    Given Launch the demo git app
    When Enter Username
    And Enter Password
    And Click on Login
    Then Verify the git image in homepage
