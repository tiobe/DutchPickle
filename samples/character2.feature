
Feature: Bad Key

  Scenario: Wrong Key
    Given set URI
    When the user send get request with characters end point and headers
    When the user print the response

  @con
  Scenario: No Key
    Given set URI
    When the user send get request with characters and no key
    When verify status code is 409 and contentType is "application/json; charset=utf-8"
    When verify the status message is "Conflict"
    Then verify the message is "Must pass API key for request"


