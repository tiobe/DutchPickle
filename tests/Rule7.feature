Feature: TODO still open # Violation
In a description a todo is also not allowed # Violation
Scenario: this is OK todododo # OK
Given the best we can to do # OK
But this Todo is wrong # Violation
| table | not | a | todo | problem | # OK
And what about a parameter <ToDO> # OK
# A TODO in comments is also forbidden # Violation
""" # Violation
another 
problem
toDO 
"""
""" # OK
to do
yes 

"""
