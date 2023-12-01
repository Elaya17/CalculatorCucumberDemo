Feature: AndroidApp Calculator validation

Scenario: Verify User able to change the theme
Given Launch the app
When Click on moreoptions button in the top right corner
And Click on choose theme button
When Click on Light button
And Click on OK button
Then Verify user is in calculation page 


Scenario Outline: Verify History section after performing multiplication operation
When Enter the value"<digit>" in the calculator
And Tap on multiplication icon
When Tap on digit nine
And Click on Equal icon
When Click on moreoptions button in the top right corner
And Click on History button
Then Verify input and results
And Close App

Examples:
|digit|
|6|
