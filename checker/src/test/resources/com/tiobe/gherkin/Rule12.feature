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
  bla bla
