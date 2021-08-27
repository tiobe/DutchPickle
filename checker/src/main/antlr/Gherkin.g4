grammar Gherkin;

@header{package com.tiobe.antlr;}

// PARSER

// TODO

// improve DATATABLEELEMENT to include all ascii characters and also base ID on this
// marco.ortelee@philips.com: solve bug table outlining non-ascii characters
// marco.ortelee@philips.com: solve bug word spacing for non-ascii characters
// marco.ortelee@philips.com: discuss removal of empty cell rule with DutchPickle board
// marco.ortelee@philips.com: TICS client for DutchPickle should work and should be super fast
// marco.ortelee@philips.com: New rule: comments below tags are allowed if they start with the tag name
// New rule: Check for copyright statement in the top comment, Eric van der Ven Philips CI
// think about a logo (Dutch pickle on wooden shoes and wind mill on its head)
// marco.ortelee@philips.com: check difference with gherkin linter and ask community whether these rules are also interesting
// rename all rules with logical rule names instead of numbers
// fix problem Wouter van de Molengraft 11/06/2021 08:21 Vanderlande Re: TICS for Gherkin
// make one improvement to make it easier to integrate DutchPickle in the software process, e.g. npm package, market place etc ask community
// Extend rule: "A comment should not start with a Step keyword" to all keywords or at least Scenario, tags, etc
// Switch on TiCS AI and security check for this project
// roll out within TIOBE customer base
// make one improvement to make it easier to integrate DutchPickle in the software process, e.g. npm package, market place etc ask community
// marco.ortelee@philips.com: no duplicate feature names across file borders
// marco.ortelee@philips.com: no duplicate scenario names across file borders
// integrate with C# code and add following 3 new rules:
// C# related rule: Don't use punctiation in the steps (no '.' nor ',', escpcially inline, that could mean abbreviations) 
// C# related rule: Don't use camelCasing nor PascalCasing (in fact all capitals should be avoided), excluding parameters
// C# related rule: No comma separated values in table cells (use multiple cells for multiple values)
// make one improvement to make it easier to integrate DutchPickle in the software process, e.g. npm package, market place etc ask community
// go public
// nice integration in 2nd most common IDE
// all violations should be printed at the moment they are found, not collected till the end
// nice integration in 3rd most common IDE
// rules in a separate directory with .class files to allow dynamic patching
// enable JSON output
// as-you-type
// make sure other charsets are handled correctly as well, see example file
// being able to distribute DutchPickle without TiCS
// automated refactoring
// language dependent keywords
// Martijn.Govers@philips.com: support for Catch2 BDD style cc: https://github.com/catchorg/Catch2/blob/devel/docs/tutorial.md#bdd-style

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
fragment DATATABLEID: (DATATABLEELEMENT | ' ')* DATATABLEELEMENT (DATATABLEELEMENT | ' ')*; // ID should contain at least one non-whitespace character otherwise the trailing | with a trailing space will match
fragment DATATABLEELEMENT: [A-Za-z0-9/\-_.:;^=+()[\],<>@!\\?{}%&"'] | '\\|' ;

NL: '\r'? '\n' ;

TEXT: TOKEN+ ;
fragment TOKEN: [!-;=-{}-~\u00A0-\u00FF] ;


