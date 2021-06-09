grammar Gherkin;

@header{package com.tiobe.antlr;}

// PARSER

// TODO

// [Waiting for Ramon] Organize demo with SCoE
// [Wait for CCB] roll out within Philips worldwide (inform Ramon, go to all projects)
// Check failing feature files in IGTS environment
// New rule: Backgrounds should only contain givens and no parameters
// New rule: Scenario outline should not contain multiple instances of same scenarios (so all variables are same between two rows)   
// New rule: Variable should have more than 1 value in the example tables (if it’s the same for all scenarios it’s not a variable anymore)   
// rename all rules with logical rule names instead of numbers
// number of tests run is hardcoded now, should be done automatically
// Extend rule: "A comment should not start with a Step keyword" to all keywords or at least Scenario, tags, etc
// integrate with C# code and add following 3 new rules:
// C# related rule: Don't use punctiation in the steps (no '.' nor ',', escpcially inline, that could mean abbreviations) 
// C# related rule: Don't use camelCasing nor PascalCasing (in fact all capitals should be avoided), excluding parameters
// C# related rule: No comma separated values in table cells (use multiple cells for multiple values)
// nice integration in 2nd most common IDE
// all violations should be printed at the moment they are found, not collected till the end
// think about a logo (Dutch pickle on wooden shoes and wind mill on its head)
// nice integration in 3rd most common IDE
// roll out within TIOBE customer base
// rules in a separate directory with .class files to allow dynamic patching
// enable JSON output
// make sure other charsets are handled correctly as well, see example file
// as-you-type
// being able to distribute DutchPickle without TiCS
// go public
// automated refactoring
// language dependent keywords

main
    : feature description* instructionLine* NL* EOF
    ;

feature
    : (NL* tagline)* NL* FEATURE
    ;

instructionLine
    : NL+ (instruction | datatable)
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

WHITESPACE: [ \t]+ -> channel(HIDDEN) ;

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
fragment DATATABLEID: [A-Za-z0-9/\-_.:;=+()[\],<>@\\?{}%&"' ]* [A-Za-z0-9/\-_.:;=+()[\],<>@\\?{}%&"'] [A-Za-z0-9/\-_.:;=+()[\],<>@\\?{}%&"' ]*; // ID should contain at least one non-whitespace character otherwise the trailing | with a trailing space will match

NL: '\r'? '\n' ;

TEXT: TOKEN+ ;
fragment TOKEN: [!-;=-{}-~\u00A0-\u00FF] ;


