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
When <bla>
| bla | | bla | # Violation
| bla | bla | bla | # OK

Examples:
Examples:
| bla | bla | | # Violation
|                                 | bla | bla | # Violation




