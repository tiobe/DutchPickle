@GuiTest
Feature: AccountTest

  # Create an account using the [Sign Up] link (manually) and assert that the sign in is working as expected (using the credentials you created)
  @GuiTest
  Scenario: SignUp and SignIn
    When I sign up with random account data
    Then I verify user is signed in with data from context
    And I log out
    When I sign in with user from context
    Then I verify user is signed in with data from context