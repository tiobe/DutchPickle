# Gherkin Test File
# Synopsis: After a When a Then should follow
# Rule ID: 2

Feature: test rule 2
Scenario: 
When
Then # OK

Scenario Outline:
Then # OK

Scenario Outline:
Given this is OK
Then # OK

Scenario: 
When
And 
*
* 
Then # OK

Scenario: 
When # Violation

Scenario Outline:
Given
When # Violation
And

Scenario: 
When # Violation
Given
Then

Scenario:
When # Violation
And
*
*
* 

Scenario: nothing wrong with a table between when and then

When there is a table

| some | table |

Then the rule should not fire

