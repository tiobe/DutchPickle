Feature: Sorting Hats

  Scenario: Sorting Hats
    Given set URI
    When the user send get request
    Then Verify the statusCode is 200
    Then Verify the Content Type is is "application/json; charset=utf-8"
    Then Rensponse body contains  one of
     |"Gryffindor"|"Ravenclaw"|"Slytherin"|"Hufflepuff"|
