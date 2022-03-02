# hello # Violation
@ignore
#VADB-294 #OK
@stopignore

# comment before # Violation
# comment again # Violation

# Copyright TIOBE # OK
# (c) TIOBE # OK

@tag
""" # Violation
another comment before
multi line
"""
@blabla

@sometag:433
@sometag:11123
# sometag:11123 - this is OK because it starts with a tag name
# sometag:111234 - this is NOK because it starts not with a tag name # Violation
# sometag:433 - still OK

# comment # Violation
Feature: feature with comment before
  # another comment # Violation
# and another one # Violation
  #//TICS some TiCS suppression that is perfectly OK
  some description
  # and another one # Violation
  but this is the last one
  # this is OK because it belongs to the next Scenario

Scenario:
  # this comment should not be flagged
  bla bla

