# Gherkin Test File
# Synopsis: After a Given a When should follow
# Rule ID: 5

Feature: test rule 5
Scenario: 
Given
When # OK
Then 

Scenario Outline:
When # OK

Scenario Outline:
When this is OK
Then # OK

Scenario: 
Given
And 
*
* 
When # OK

Scenario: 
Given # Violation

Scenario Outline:
Given # Violation
And

Scenario: 
Given 
Given # Violation
Then

Scenario:
Given # Violation
And
*
*
* 

Scenario: nothing wrong with a table between when and then

Given there is a table

| some | table |

When the rule should not fire

