Feature: rule 6 Subsequent Givens, Whens, and/or Thens are not allowed (use And or But)

Scenario Outline: # OK 
When
Then

Scenario Outline: 
Given

| bla | bla | bla | 
And else
Given something # Violation
When something
Then something
Given # OK

Scenario Outline: 
Given
When
Then 
When # OK
And something
When something # Violation
Then # OK