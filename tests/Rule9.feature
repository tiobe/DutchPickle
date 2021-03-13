Feature: 

Scenario Outline:

| bla | bla | bla | # OK
| bla | bla | bla | # OK

Given
Examples:
| bla | bla | bla | # OK
| bla | bla | bla | # OK


Scenario Outline:

| bla | | bla | # Violation
| bla | bla | bla | # OK

Examples:
Examples:
| bla | bla | | # Violation
|                                 | bla | bla | # Violation




