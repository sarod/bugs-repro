grammar Tree;

@header {
package antlr.bugs;
}

node: nonLeaf | leaf;
nonLeaf: L node COMMA node R;
leaf: ID;


// Lexer
L: '(';
R: ')';
COMMA: ',';
ID  :	('a'..'z'|'A'..'Z')+;
WS      :  ( ' ' | '\t' | '\r' | '\n') -> channel(HIDDEN);