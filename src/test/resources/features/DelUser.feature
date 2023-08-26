Feature: Delete user

  @DelUser
  Scenario: Delete user successfully.
    When I consume the endpoint "<endpoint>" and I send the user information username "<username>"
    Then I can validate the phone "<phone>"