Feature: new line needed
| x | z | # OK
| y | x | # OK
Scenario Outline: fine # OK

@thisisOK
Scenario Outline: less fine # OK
Given bla
Scenario Outline: blub # Violation
| x | z |
| y | x |



Scenario: # OK
Background: # Violation

Scenario: # OK
# some comment
Scenario: # Violation
Scenario: # Violation

@thisisOK
@thisisOK
Scenario Outline: less fine # OK
