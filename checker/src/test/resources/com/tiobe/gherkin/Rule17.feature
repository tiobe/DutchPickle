Feature: bla
Scenario: yes
Given something
| bla | bla | blaeeee | # OK
| bla | bla | xasd    |

Then bla

| bla | bla | blaeeee |
| bla | bla | xasd | # Violation

Examples:
| thats OK | but this    | # OK
| thats OK | but this not| # Violation

Examples:
| thats OK | but this     | # OK
| thats OK | but this not |

Examples:
| thats OK | but this     |
| thats | but this not | # Violation

Examples:
|this is wrong        | bla | # Violation
| this is OK          | bla | # OK
|       this is not OK| bla | # Violation
| this is also not OK |  bla| # Violation

