Feature: User login

  Scenario: Successfull login
    Given the user is on login page
    When the user enters the credentials "test@gmail.com" and "test@123"
    And the user click on the login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message

  Scenario: Unsuccessfull login
    Given the user is on login page
    When the user enters the invalid credentials "test@123" and "admin123"
    And the user click on the login button
    Then the user should be redirected to the My Account page
    And the user should see the login page
