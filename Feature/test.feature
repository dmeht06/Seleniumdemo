Feature: Testing Google Search page

Scenario: Verification of string search

Given Open "https://www.google.com/" in chrome

When User enters "selenium" in search box and selects option no. 1

Then user should see result page 
