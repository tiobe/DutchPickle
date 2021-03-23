Feature:  A Scenario is not allowed to end with comments

# hello # Violation
Scenario Outline:
bla bla
# hello # Violation
# x # Violation


Scenario Outline:

bla bla
# hello
bla bla

Scenario:

# another comment # Violation
``` # Violation
this is also a comment
```

@tagtomakeitdifficult
Scenario:


# bla
bla

@tagtomakeitdifficult
Scenario:

@tagtomakeitdifficult
# bla # Violation
# bla again # Violation
@tagtomakeitdifficult
@tagtomakeitdifficult
Scenario:
