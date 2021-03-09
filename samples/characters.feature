Feature: Bad Key
  @wip
  Scenario: Wrong Key
    Given set URI
    When the user send get request with "characters" end point and headers
    Then Verify the statusCode is 401
    Then Verify the Content Type is is "application/json; charset=utf-8"
    Then Verify the response status message is "Unauthorized"
    Then Verify the response is following
         |error| API Key Not Found|
