Feature: bla bla

Background:
Given this and that
When x
Then y

Scenario: # Violation+1 # Violation+2 # Violation+3
Given this and that
When x
Then y
And z

Scenario: # OK
Given this and that
Then x
Then y
And z

Scenario: # OK
Given this and that
When x

Scenario: # OK
Given bla
Given this and that
When x
Then y
