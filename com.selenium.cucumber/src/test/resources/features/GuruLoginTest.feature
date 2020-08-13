Feature: Login Test
  Descriptio: It is verifying all tests for login page.

  Background: 
    Given the user navigate to "https://latamcrm--qa.lightning.force.com" page
    When the user enter "hialtamiranol@@metlife.com.mx.latam.qa.super" into input field having xpath "Username"
    And the user enter "vision2020" into input field having xpath "Password"
    And the user click on element having xpath "LoginButton"

  Scenario: verify login page functionality
