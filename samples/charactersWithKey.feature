Feature:Verify number of characters
  @conkey
  Scenario: Verify number of characters
    Given set URI
    When send get request with key and "character" endPoints
    When Verify status code is 200 and contentType is "application/json; charset=utf-8"
    Then Verify response contains 195 characters