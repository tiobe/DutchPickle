Feature: Variable should have more than 1 different value in the example tables

  Scenario Outline:
    Given

  | foo | y | z |
  | foo | bla | foo |
  | x | zwa | foooo |

    And
  | foo | y | z |
  | foo | bla |
  | x | bla     | foooo |

    Examples:
    | x | y | z |
    | x | bla | foo |
    | x | zwa | foooo |

    Scenario Outline:

      Scenarios:
    | foo | y | z | # Violation
    | foo | bla |
    | x | bla     | foooo |


      Scenario Outline:

        Scenarios:
          | x | y | z | # Violation
          | x | bla | foo |
          | x | bla | foooo |

        Scenarios:
          | x | y | z |
          | x | bla | foo |
          | x | zwa | foooo |
