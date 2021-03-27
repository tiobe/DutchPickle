Feature: don't use punctuation in Steps, here it is allowed # OK
Scenario: blabla.blabla # OK
Given some punctuaction, we have a problem # Violation
# In comments. perfectly allowed # OK
When I do something: # OK
Then we.might.be.in.trouble , and another one # Violation # Violation
| ooo, in a datatable | # Violation
| this one is OK |