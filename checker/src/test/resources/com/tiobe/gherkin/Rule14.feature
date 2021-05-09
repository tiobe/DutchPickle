Feature: bla

Scenario: text
Given bla # Violation
And foo # Violation
And a step with a <param> in it doesn't count
When foo
Then true
* x

Scenario: text2
Given bla # Violation
And foo # Violation
And a step with a <param> in it doesn't count
When foo
Then true2
* x

Scenario: xxyyy
#some text
Given bla # Violation
And foo # Violation
And a step with a <param> in it doesn't count
When foo
Examples:
| x | y |

Scenario Outline: PR27975
Given bla # Violation
And foo # Violation
And a step with a <param> in it doesn't count
When foo
Then something else



