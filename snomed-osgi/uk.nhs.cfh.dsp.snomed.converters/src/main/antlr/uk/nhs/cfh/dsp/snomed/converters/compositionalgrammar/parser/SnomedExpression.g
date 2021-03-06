grammar SnomedExpression;
options {

    // Default language but name it anyway
    //
    language  = Java;

    // Produce an AST
    //
    output    = AST;

    // Use a superclass to implement all helper
    // methods, instance variables and overrides
    // of ANTLR default methods, such as error
    // handling.
    //
    superClass = AbstractSnomedExpressionParser;
    
        // Use the vocabulary generated by the accompanying
    // lexer. Maven knows how to work out the relationship
    // between the lexer and parser and will build the 
    // lexer before the parser. It will also rebuild the
    // parser if the lexer changes.
    //
    // tokenVocab = SnomedExpressionLexer;
}

tokens {
	SNOMED;
	EXPRESSION;
	CONCEPT;
	CONCEPT_ID;
	REFINEMENT;
	RELATIONSHIP_EXPRESSION;
	RELATIONSHIP_EXPRESSION_COLLECTION;
	ROLE_GROUP_EXPRESSION;
	PROPERTY_EXPRESSIONS;
}

   @header {
       package uk.nhs.cfh.dsp.snomed.converters.compositionalgrammar.parser;
   }
   
   @lexer::header {
       package uk.nhs.cfh.dsp.snomed.converters.compositionalgrammar.parser;
   }

snomed      : expression+ EOF! ;
expression  : concept (PLUS concept)* (COLON refinements)? -> ^(EXPRESSION concept+ refinements*);
concept     : conId=conceptId (TERM)? -> ^(CONCEPT $conId);
conceptId   : sctid=SCTID -> ^(CONCEPT_ID $sctid);
refinements : attributeSet? attributeGroup* ->^(PROPERTY_EXPRESSIONS attributeSet? attributeGroup*);
attributeGroup  : '{' attributeSet '}' -> ^(ROLE_GROUP_EXPRESSION attributeSet);
attributeSet    : attribute (',' attribute)* -> ^(RELATIONSHIP_EXPRESSION_COLLECTION attribute+);
attribute   : attrName=attributeName ASSIGN attrVal=attributeValue -> ^(RELATIONSHIP_EXPRESSION $attrName $attrVal);
attributeName   : id=attributeNameId (TERM)? -> ^(CONCEPT_ID $id);
attributeValue  : c=concept -> ^(CONCEPT $c )
        	| '(' exp=expression ')' -> ^(EXPRESSION $exp);
attributeNameId : sctid=SCTID -> ^(CONCEPT_ID $sctid);

// there seems to be problem with antlr maven plugin picking up the Lexer tokens, so they
// have been redeclared here. Ideally they should have been picked up from the SnomedExpressionLexer.g file.

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {skip();}
    |   '/*' ( options {greedy=false;} : . )* '*/' {skip();}
    ;
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;
PLUS : '+' ;
SEMI_COLON: ';' {skip(); };
COLON	:	':';
ASSIGN :	'=';
TERM: '|' (~'|')* '|' { setText(getText().replace('|', ' ').trim()); };
SCTID:INT_NON_ZERO INT INT INT INT INT+ ;

fragment 
INT_NON_ZERO   : '1'..'9' ;
INT :	'0'..'9'  ;