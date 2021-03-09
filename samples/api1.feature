
Feature: verify sorting hat
  Scenario: sorting hat
    Given user goes to  BaseUri
    When user sends a Get request
    Then verify status code 200
    Then  verify that the contentType is "application/json;charset=utf-8"
  Then body contains  one of "Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"


 # Verify sorting hat
  #1. Send a get request to /sortingHat. Request includes :
  #2. Verify status code 200, content type application/json; charset=utf-8
  #3. Verify that response body contains one of the following houses:
  #"Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"

