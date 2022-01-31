Feature: Background should only contain Given steps

Background:
Given this and that
When x # Violation
Then y # Violation

Scenario Outline:
There is some scenario outline here

Background:
Given this and that
| bla | bla # OK
| x   | y # OK
And x # OK
But x2 # OK
* x3 # OK
Then y # Violation

Background:
When bla # Violation