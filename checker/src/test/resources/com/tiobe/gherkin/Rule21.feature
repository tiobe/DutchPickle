Feature: Scenario outline should not contain multiple instances of same scenarios

  Scenario Outline:
    Given bla
    | bla | bla |
    And bla
    | bla | bla |
    And bla # Violation+2 # Violation+3
    | bla | bla |
    | bla | bla |
    |   bla |  bla  |

    Examples: # Violation+4
    | true | false | something |
    | true | false | else |
    | true | else | something |
    | true | false | else    |