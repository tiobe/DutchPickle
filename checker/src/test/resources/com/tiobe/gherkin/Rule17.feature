Feature: bla
Scenario: yes
Given something
| bla | bla | blaeeee | # OK
| bla | bla | xasd    |

Then bla

| bla | bla | blaeeee | # not yet Violation
| bla | bla | xasd |

Examples:
| that's OK | but this    | # OK
| that's OK | but this not|

Examples:
| that's OK | but this     | # OK
| that's OK | but this not |

Examples:
| that's OK | but this     | # not yet Violation
| that's | but this not |

