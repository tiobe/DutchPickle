Feature: Scenario outline should not contain multiple instances of same scenarios

  Scenario Outline:
    Given bla
    | bla | bla |
    And bla
    | bla | bla |
    And bla
    | bla | bla |
    | bla | bla | # Violation
    |   bla |  bla  | # Violation

    Examples:
    | true | false | something |
    | true | false | else |
    | true | else | something |
    | true | false | else    | # Violation