grammar Gherkin;

@header{package com.tiobe.antlr;}

// PARSER

// TODO
// add other 10 checks
// make sure it is completely build via the TICS build and published on the website
// deployment
// SECOND DELIVERY

// rules in a separate directory with .class files to allow dynamic patching
// make sure other charsets are handled correctly as well, see example file
// as-you-type
// language dependent keywords

main
    : feature description* (NL+ (instruction | datatable))* NL* EOF
    ;

feature
    : (NL* tagline)* NL* FEATURE
    ;

instruction
    : rulex description* // the name "rule" is not allowed by ANTLR (used for internal usage), so calling it rulex
    | stepInstruction description* (NL+ stepDescription description*)* (NL+ step)*
    | tagline
    | instructionDescription description*
    ;

stepInstruction
    : background
    | scenario
    | scenarioOutline
    ;

background: BACKGROUND ;
rulex: RULEX ;
scenario: SCENARIO ;
scenarioOutline : SCENARIOOUTLINE ;

step : stepItem description*;

stepItem
    : and
    | anystep
    | but
    | datatable
    | given
    | then
    | when
    | (NL* tagline )* NL* examples
    ;

tagline
    : TAG+
    ;

and: AND ;
anystep: ANYSTEP ;
but: BUT ;
datatable: DATATABLE+ ;
given: GIVEN ;
then: THEN ;
when: WHEN ;
examples: EXAMPLES ;

// Descriptions
instructionDescription: TEXT | PARAMETER | AND | ANYSTEP | BUT | GIVEN | THEN | WHEN | SCENARIO ; // We have to deal with overlaps with keywords
stepDescription: TEXT | PARAMETER ; // We have to deal with overlaps with keywords
description: TEXT | PARAMETER | TAG | AND | ANYSTEP | BUT | DATATABLE | GIVEN | THEN | WHEN | SCENARIO | SCENARIOOUTLINE ; // We have to deal with overlaps with keywords

// LEXER

// skipped

BOMUTF8 : '\u00EF\u00BB\u00BF' -> skip ;

BOMUTF16 : '\uFEFF' -> skip ;

WHITESPACE: [ \t] -> skip ;

COMMENT: '#' ~[\r\n\f]* -> channel(HIDDEN) ;

DOCSTRING1
    : '"""' .*? '"""' -> channel(HIDDEN) ;

DOCSTRING2
    : '```' .*? '```' -> channel(HIDDEN) ;

// Instructions
BACKGROUND: 'Background:' ;
EXAMPLES: ('Examples:' | 'Scenarios:') ;
FEATURE: 'Feature:';
RULEX: 'Rule:' ;
SCENARIO: ('Example:' | 'Scenario:') ;
SCENARIOOUTLINE : 'Scenario ' ('Outline:' | 'Template:') ;

// Steps
AND: 'And' ;
ANYSTEP: '*' ;
BUT: 'But' ;
DATATABLE: '|' DATATABLEID? ; // must be an ID because it can contain a space
GIVEN: 'Given' ;
THEN: 'Then' ;
WHEN: 'When' ;

TAG: '@' TEXT ;
PARAMETER: '<' ID '>' | '"' '<' ID '>' '"' | '\'' '<' ID '>' '\'';
fragment ID: [A-Za-z0-9/\-_.:;=+()[\],@\\?{}%& ]* [A-Za-z0-9/\-_.:;=+()[\],@\\?{}%&] [A-Za-z0-9/\-_.:;=+()[\],@\\?{}%& ]*; // ID should contain at least one non-whitespace character otherwise the trailing | with a trailing space will match
fragment DATATABLEID: [A-Za-z0-9/\-_.:;=+()[\],<>@\\?{}%& ]* [A-Za-z0-9/\-_.:;=+()[\],<>@\\?{}%&] [A-Za-z0-9/\-_.:;=+()[\],<>@\\?{}%& ]*; // ID should contain at least one non-whitespace character otherwise the trailing | with a trailing space will match

NL: [\n\r\f] ;

TEXT: TOKEN+ ;
fragment TOKEN: [!-;=-{}-~\u00A0-\u00FF] ;

