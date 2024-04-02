Feature: user should be able to login

  Scenario: user login with valid user name and password
    Given user open browser
    And navigate to login page

    When user enter "Admin" and "admin123"
    And click login button

    Then user redirected to dashboard page