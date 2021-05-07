Feature: bla

Scenario: text
Given bla # Violation
And foo # Violation
When foo
Then true
* x

Scenario: text2
Given bla # Violation
And foo # Violation
When foo
Then true2
* x

Scenario: xxyyy
#some text
Given bla # Violation
And foo # Violation
When foo
Examples:
| x | y |

Scenario Outline: PR27975
Given bla # Violation
And foo # Violation
When foo
Then something else



