Feature: double space check
here double    spaces are OK # OK
Scenario: here aaa     ssss   weeelll # OK
Given there is no space here
When oops a   double space # Violation
# Comments with double   spaces all right # OK
| we have   table | here | # OK
But what about double tab       like this # Violation
And   double space at the beginning # Violation
Scenarios:
    | this works  | "this not"  | # OK, PR27961

