grammar Gherkin;

@header{package com.tiobe.antlr;}

// PARSER

// TODO

// implement all rules in Philips backlog (4 to go), except for 249331 (cross file borders)
// improve command line options
// use the DutchPickle logo in some way, see website & house style
// being able to distribute DutchPickle without TiCS
// go public: github
// marco.ortelee@philips.com: TICS client for DutchPickle should work and should be super fast
// marco.ortelee@philips.com: check difference with gherkin linter and ask community whether these rules are also interesting
// john.de.bot@philips.com: Use unique scenario names, preferably starting with an ID to map the test scenario to a test specification. To be able to run a subset of all tests, each test must be uniquely named. Specflow does not enforce this across features (only within features)
// john.de.bot@philips.com: When using parameters in a scenario or step, they should be recognizable by (either single or double quotes). We have seen 3 different ways in specflow tests: no special marking (positioning), single quotes (Fixed system level) and double quotes (IAC system level).
// rename all rules with logical rule names instead of numbers
// fix problem Wouter van de Molengraft 11/06/2021 08:21 Vanderlande Re: TICS for Gherkin
// make one improvement to make it easier to integrate DutchPickle in the software process, e.g. npm package, market place etc ask community
// Extend rule: "A comment should not start with a Step keyword" to all keywords or at least Scenario, tags, etc
// Switch on TiCS AI and security check for this project
// roll out within TIOBE customer base
// make one improvement to make it easier to integrate DutchPickle in the software process, e.g. npm package, market place etc ask community
// marco.ortelee@philips.com: no duplicate feature names across file borders
// marco.ortelee@philips.com: no duplicate scenario names across file borders
// all violations should be printed at the moment they are found, not collected till the end
// integrate with C# code and add following 3 new rules:
// C# related rule: Don't use punctiation in the steps (no '.' nor ',', escpcially inline, that could mean abbreviations) 
// C# related rule: Don't use camelCasing nor PascalCasing (in fact all capitals should be avoided), excluding parameters
// C# related rule: No comma separated values in table cells (use multiple cells for multiple values)
// make one improvement to make it easier to integrate DutchPickle in the software process, e.g. npm package, market place etc ask community
// nice integration in 2nd most common IDE
// support Robot Framework Gherkin as well
// remi-christiaan.cool@philips.com: just like integration with C# also integrate with C++
// nice integration in 3rd most common IDE
// rules in a separate directory with .class files to allow dynamic patching
// enable JSON output
// as-you-type
// Tobias.Flossmann@philips.com: rule about boolean tags, see Philips Hamburg 8-sept-2021
// make sure other charsets are handled correctly as well, see example file
// automated refactoring
// language dependent keywords
// Martijn.Govers@philips.com: support for Catch2 BDD style cc: https://github.com/catchorg/Catch2/blob/devel/docs/tutorial.md#bdd-style

main
    // start comment needed because each comment should start on a new line except for the start comment
    : STARTCOMMENT? feature description* instructionLine* NL* EOF
    ;

feature
    : (NL* tagline)* NL* FEATURE?
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
instructionDescription: text | PARAMETER | AND | ANYSTEP | BUT | GIVEN | THEN | WHEN | SCENARIO ; // We have to deal with overlaps with keywords
stepDescription: text | PARAMETER ; // We have to deal with overlaps with keywords
description: text | PARAMETER | TAG | AND | ANYSTEP | BUT | DATATABLE | GIVEN | THEN | WHEN | SCENARIO | SCENARIOOUTLINE | STARTCOMMENT ; // We have to deal with overlaps with keywords

text: TOKEN+ ;

// LEXER

// skipped

BOMUTF8 : '\u00EF\u00BB\u00BF' -> skip ;

BOMUTF16 : '\uFEFF' -> skip ;

WHITESPACE: [ \t]+ -> channel(1) ;

COMMENT: '\r'?'\n' [ \t]* '#' ~[\r\n]* -> channel(2) ;

STARTCOMMENT: '#' ~[\r\n]* ;

DOCSTRING1
    : '"""' .*? '"""' -> channel(2) ;

DOCSTRING2
    : '```' .*? '```' -> channel(2) ;

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

TAG: '@' ELEMENT+ ;
PARAMETER: '<' PARID '>' | '"' '<' PARID '>' '"' | '\'' '<' PARID '>' '\'';
fragment PARID: [A-Za-z0-9] ([!-=?-~ ]* [!-=?-~])?; // start with an alpha numerical and then all printable characters and end with a non-space
fragment ID: (IDELEMENT | ' ')* IDELEMENT (IDELEMENT | ' ')*; // ID should contain at least one non-whitespace character otherwise the trailing | with a trailing space will match
fragment DATATABLEID: (DATATABLEELEMENT | ' ')* DATATABLEELEMENT (DATATABLEELEMENT | ' ')*; // ID should contain at least one non-whitespace character otherwise the trailing | with a trailing space will match
fragment DATATABLEELEMENT: ELEMENT | '<' | '>' | '"' | '\'' | '\\|' ;
fragment IDELEMENT: ELEMENT | '|' ;
fragment ELEMENT: [!-&(-;=?-{}~\u00A0-\uFFFF] ;

NL: '\r'? '\n' ;
TOKEN: [!-{}-~\u00A0-\uFFFF] ; // match everything that isn't matched yet


