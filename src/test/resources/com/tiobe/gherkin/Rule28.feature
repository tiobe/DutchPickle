Feature: check for description
	Scenario:    # Violation
    Given this scenario
    Given another issue	# Violation
    Given I have the following books in the store
        | title                                | author 	     | # Violation
        | The Devil in the White City          | Erik Larson |
        | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
        | 	In the Garden of Beasts              | Erik Larson | # Violation
    When "there is a tab 		in a string" # Violation # Violation
    Then don't trigger anything

	# Violation
	Then do something else # Violation

"""
Let's try	this # OK
"""

```
And 	this # OK
	# OK
```
