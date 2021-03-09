Feature: Verify number of character id and house
  @conid
  Scenario: number of character id and house
    Given set URI
    When send get request with key and "character" endPoints
    When Verify status code is 200 and contentType is "application/json; charset=utf-8"
    When Verify all characters in the response have "_id" field which is not empty
    And Verify that value type of the field dumbledoresArmy is a boolean in all characters in the response
    Then Verify value of the house in all characters in the response is one of the following
           |"Gryffindor"| "Ravenclaw"|"Slytherin"| "Hufflepuff"|