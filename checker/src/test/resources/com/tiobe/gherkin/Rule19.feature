Feature: A comment should not start with a Gherkin keyword
Scenario: here it probably won't happen
Given blabla
#    Given this one I don't want to see # Violation
# Zen this is OK
But what now?
# | should not match # OK
Then do something
""" Given another problem # Violation


"""
# And this is also wrong # Violation