# Gherkin Test File
# Synopsis: A Given should not follow a When or a Then
# Rule ID: 3

Feature: test rule 3
Scenario: 
When # OK
Then

Scenario Outline:
Then # OK

Scenario Outline:
Given this is OK # OK
Then

Scenario:
And 
Given # OK
When
And 
*
* 
Then 

Scenario: 
When do something
Given something else # Violation

Scenario Outline:
When
And
Given # Violation

Scenario: 
When
Given # Violation
Then
Given # Violation

Scenario:
When # OK
'''
extra Given
'''

