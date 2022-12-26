

Feature: Login
  

  
  Scenario Outline: Verification of Login Function
    Given user launch the browser
    And navigate to the "https://www.saucedemo.com/"
    When user enters the username as "standard_user"
    When user enters the password as "secret_sauce"
    And clicks on login button
    Then naviagte to the page with title "Swag Labs"
    And Quit browser


  Scenario Outline: Unsuccessful login
    Given user launch the browser
    And navigate to the "https://www.saucedemo.com/"
    When user enters the username as "standard_user"
    When user enters the password as "password"
    And clicks on login button
    Then display "Epic sadface: Username and password do not match any user in this service"
		And Quit browser
    