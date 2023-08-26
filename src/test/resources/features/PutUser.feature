Feature: Update user

  @PutUser
  Scenario: Update user successfully.
    When I consume the endpoint and I send the User information
    Then I can validate server response code