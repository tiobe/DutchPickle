Feature: Verify number of character id and house
  @conid
  Scenario: number of character id and house
    Given set URI
    When send get request with key and "character" endPoints
    When Verify status code is 200 and contentType is "application/json; charset=utf-8"
    Then the user send get request with name
    Then verify the both response are the same