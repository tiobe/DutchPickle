
@Navigate
Feature: Navigation menu

  Scenario: Navigation Fleet -- vehicles

    Given The user in on the login page
    And The user enter the sales manager information
    When the user navigate to Fleet, Vehicles
    Then hte title should be Vehicles



    Scenario: Navigating Marketing Campaings

      Given The user in on the login page
      And The user enter the sales manager information
      When the user nagivate to Marketing, Campaigns
      Then title should be Campaigns

      @db
      Scenario: Navigating Activities -- Calendar Events
        Given The user in on the login page
        And The user enter the sales manager information
        When the user navigates to Activities,Calendar Events
        Then title should be Calendars