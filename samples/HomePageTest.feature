@GuiTest @AdminSignIn
Feature: HomePageTest

  # Assert that there are [10] articles per page and [50] pages in total
  Scenario: Pages and Articles number limit
    When I navigate to Global Feed link
    Then I verify that there is 50 pages in total
    Then I verify that there is 10 articles on page

  # Assert that [test] tag exists and click it
  Scenario: Tag click
    When I click on test tag
    Then I verify test tag is shown in navigation tab
