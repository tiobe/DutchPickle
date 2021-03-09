# Gherkin Test File
# Synopsis: a Scenario Outline should contain more than one Scenario
# Rule ID: 1

Feature: test rule 1
Scenario: # OK 
When
Then 
Examples:
| start | eat | left |
|    12 |   5 |    7 |

Scenario Outline: # OK
Then

Scenario Outline: # Violation
When
And 
*
* 
Then
Examples:
| start | eat | left |
|    12 |   5 |    7 |

Scenario Outline: # OK
Given
When
And
Examples:
| start | eat | left |
|    12 |   5 |    7 |
|    12 |   5 |    7 |

Scenario Template: # OK
When
Scenarios:
| start | eat | left |
|    12 |   5 |    7 |
And
*
*
Scenarios:
| start | eat | left |
|    12 |   5 |    7 |
And

Scenario Template: # Violation
When
Scenarios:
| start | eat | left |
And
*
*
Scenarios:
| start | eat | left |
|    12 |   5 |    7 |
And

