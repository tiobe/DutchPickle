Feature: bla

Scenario: text # Violation+1 # Violation+2 # Violation+3 # Violation+4
Given bla
| DecelerationValue |
| 500               |
| 1000              |
And foo
And a step with a <param> in it doesn't count
When foo
Then true
* x

Scenario: text2 # Violation+1 # Violation+2 # Violation+3 # Violation+4
Given bla
| DecelerationValue |
| 500               |
| 1000              |
And foo
And a step with a <param> in it doesn't count
When foo
Then true2
* x

Scenario: xxyyy
#some text # Violation+1 # Violation+2 # Violation+3 # Violation+4
Given bla
| DecelerationValue |
| 500               |
| 1000              |
And foo
And a step with a <param> in it doesn't count
When foo
Examples:
| x | y |

Scenario Outline: PR27975 # Violation+1 # Violation+2 # Violation+3 # Violation+4
Given bla
| DecelerationValue |
| 500               |
| 1000              |
And foo
And a step with a <param> in it doesn't count
When foo
Then something else

Scenario Outline: CR28388 # Violation+1 # Violation+2 # Violation+3 # Violation+4
Given bla
| DecelerationValue |
| 500               |
| 1000              |
And foo
  | this table belongs to the and part |
And a step with a <param> in it doesn't count
When foo
Then something else





