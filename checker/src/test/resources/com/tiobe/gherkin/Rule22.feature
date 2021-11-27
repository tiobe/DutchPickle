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

    Examples: # Violation+1
    | x | y | z |
    | x | bla | foo |
    | x | zwa | foooo |

    Scenario Outline:

      Scenarios: # Violation+1
    | foo | y | z |
    | foo | bla |
    | x | bla     | foooo |


      Scenario Outline:

        Scenarios: # Violation+1
          | x | y | z |
          | x | bla | foo |
          | x | bla | foooo |

        Scenarios:
          | x | y | z |
          | x | bla | foo |
          | x | zwa | foooo |

  Scenario Outline:

    Scenarios:
      | x | y | z |
      | x | bla | foo |
      | x | bla | foooo |

    Scenarios:
      | x | y | z |
      | x | bla | foo |
      | t | zwa | foooo |

        Scenario Outline: # CR28804
        | foo | y | z |
        | foo | bla |
        | x | bla     | foooo |

