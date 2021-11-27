Feature: 

Scenario Outline:
When <bla>
| bla | bla | bla | # OK
| bla | bla | bla | # OK

Given
Examples:
| bla | bla | bla | # OK
| bla | bla | bla | # OK


Scenario Outline:
When <bla> # Violation+1
| bla | | bla |
| bla | bla | bla | # OK

Examples:
Examples: # Violation+1 # Violation+2
| bla | bla | |
|                                 | bla | bla |




