Feature: x

Scenario: bla # OK

Scenario Outline: bla # OK

Scenario Outline: foo # OK
Given bla bla
When bla bla

Scenario Outline: blup # OK
Given bla <bla> bla

Scenario Outline: foo # OK
Examples:

Scenario Outline: wow 
Examples: # Violation+1
| hello |

Scenario Outline: wow 
Given <hello2> "<hello3>"
Examples: # Violation+1
| hello2 | hello | hello3 |

Scenario Outline: wow # OK
Given <hello2> "<hello3>"
When <hello>
Examples:
| hello2 | hello | hello3 |

Scenario Outline: wow 
Given <xxx> "<yyy>"
Examples:
| xxx | yyy |
Examples: # Violation+1
| yyy | foo |

@Config.System.Biplane
Scenario Outline: check for parentheses in parameters
   Given The user initiates the protocol to bring IGC to ReadyForAcquisition state
     And Geometry SID for '<ChannelType>' channel is set to '<SID>' (x 0.1 mm)
     And after run data 'collimatedWidth' of channel data is '<CollimatedWidthValue(mm)>' for the '<ChannelType>' channel
     And after run data 'collimatedHeight' of channel data is '<CollimatedHeightValue(mm)>' for the '<ChannelType>' channel
     And after run data 'collimatedArea' of channel data is '<CollimatedAreaValue(m2)>' for the '<ChannelType>' channel

@Config.Detector.Frontal.FD20
@Config.Detector.Lateral.FD15
Scenarios:
    | ChannelType | SID   | CollimatedWidthValue(mm) | CollimatedHeightValue(mm) | CollimatedAreaValue(m2) |
    | frontal     | 11950 | 391.96                   | 311.895                   | 0.122250                |
    | lateral     | 10700 | 277.13                   | 299.6                     | 0.083028                |

Scenario Outline: check for spaces in parameters
     And user positions lateral stand (LArc) in '<LateralStandPosition>' position
     And field service procedure '<FieldServiceProcedureName>' is started
     And geometry moves to position with name '<first maximum>'

@Config.System.All
Scenarios:
    | FieldServiceProcedureName                 | LateralStandPosition | first maximum         |
    | FlowFSCSysAirKermaRateVerificationFrontal | park                 | first maximum frontal |

@tc:131081
@flexarm
Scenario Outline: check for parameters in data tables at step level
    Given test id <TestId> is logged
        | Angulate_Frontal | Rotate_Frontal | IsoZ_Frontal | IsoY_Frontal | DetectorShift_Frontal |
        | <Ang>            | <Rot>          | <IsoZ>       | 1700         | 1195                  |
    When movement IsoZ_Frontal is requested with 100% in <Forward> direction

    # Loss of alignment during table tilt is accepted behavior for Magnus.
    @ad7
    @tabletilt
    Examples:
        | TestId | Ang | Rot  | IsoZ |
        
Scenario Outline: check with multiple parameters on one step line
    Given test id <TestId> is logged
    And movement <Movement> is moved to position <ParkPosition>
    And the <BodyGuard> bodyguard digital value is set to <ObjectCloseToBg>
    And user message <Message> will not be given

    @flexmove
    Examples:
        | TestId | Movement     | ParkPosition | BodyGuard | Message                     | ObjectCloseToBg |

@~clea2blue
Scenario Outline: Beam longitudinal movement test
    Given test id <TestId> is logged
    And the range "Minimum value is <MinPosValue>, maximum is <MaxPosValue>" is shown for StartPosInputRange
    And the range "Minimum value is <MinPosValue>, maximum is <MaxPosValue>" is shown for TargetPosInputRange
    And the range "Minimum value is 1.0, maximum is <MaxSpeedValue>" is shown for TargetSpeedInputRange
    @polyg2 @extendedrail
    Examples:
        | TestId | MinPosValue | MaxPosValue | MaxSpeedValue |
        | 1      | 479.0       | 4107.0      | 150.0         |

Scenario Outline: CR28308
    Given test id is logged
    Examples:
        | TestCaseID |
        |          2 |
        |          1 |
  