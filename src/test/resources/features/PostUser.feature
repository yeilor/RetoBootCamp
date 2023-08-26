Feature: Create user

  @PostUser
  Scenario: Create user successfully.
    When I consume the service and I send the user information
    Then I can validate the code status



