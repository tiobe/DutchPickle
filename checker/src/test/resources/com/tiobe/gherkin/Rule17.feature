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

  # PR28673
  Examples:
  | sometext |
  | x !? y   |

  # PR28806
  Examples:
    | Event name                                       | Details                                |
    | Waste - TR BAND Radial Artery Compression Device |                                        |
    | Apply - TR BAND Radial Artery Compression Device | Success:No\|Right radial artery\|10m^3 |
    | Waste - TR BAND Radial Artery Compression Device |                                        |
