Feature: User Register
  Descriptio: It is verifying all tests for register page.

  Background: 
    When the user click on element having xpath "DismisLink"
    And the user click on element having xpath "MyAccountLink"
    And the user enter "hialtamiranol@@metlife.com.mx.latam.qa.super" into input field having xpath "Username"
    And the user enter "vision2020" into input field having xpath "Password"
    And the user click on element having xpath "LoginButton"

  Scenario: verify user register page functionality
  When the user enter "NiravP007" into input field having xpath "Username"
  And the user enter "Niravpanchal2047@gmail.com" into input field having xpath "EmailAddress"
  And the user enter "Automation321" into input field having xpath "RegisterPassword"
  And the user click on element having xpath "RegisterButton"
