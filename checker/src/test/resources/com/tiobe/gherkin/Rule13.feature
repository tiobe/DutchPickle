Feature: bla bla

Background:
Given this and that
When x
Then y

Scenario:
Given this and that # Violation
When x # Violation
Then y # Violation
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
