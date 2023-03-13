package com.code.Asgmnt1;

import com.code.Asgmnt1.Grammar.TokenType;

public class LexicalAnalyzer {

	  private int pos;
	  private String text;

	  LexicalAnalyzer(String text) {
	    this.text = text;
	    this.pos = 0;
	  }

	  private String getNum() {
	    int start = pos;
	    while (pos < text.length() && (Character.isDigit(text.charAt(pos))||text.charAt(pos)=='.')) {
	      pos++;
	    }
	    return text.substring(start, pos);
	  }

	  private void ignoreWhitespace() {
	    while (pos < text.length() && Character.isWhitespace(text.charAt(pos))) {
	      pos++;
	    }
	  }

	  Token getToken() throws Exception {
	    while (pos < text.length()) {
	      char currentChar = text.charAt(pos);
	      if (Character.isWhitespace(currentChar)) {
	    	ignoreWhitespace();
	        continue;
	      }

	      if (Character.isDigit(currentChar)) {
	    	String num = getNum();
	    	if(num.contains("."))
	    		return new Token(TokenType.FLOATLIT,num);
	    	else
	    		return new Token(TokenType.INTLIT,num );
	      }

	      if (currentChar == '+') {
	        pos++;
	        return new Token(TokenType.PLUS,"+");
	      }

	      if (currentChar == '-') {
	        pos++;
	        return new Token(TokenType.MINUS, "-");
	      }

	      if (currentChar == '*') {
	        pos++;
	        return new Token(TokenType.TIMES, "*");
	      }

	      if (currentChar == '/') {
	        pos++;
	        return new Token(TokenType.DIVIDE, "/");
	      }
	      
	      if (currentChar == '^') {
		        pos++;
		        return new Token(TokenType.EXPONENT, "^");
		  }

	      if (currentChar == '(') {
	        pos++;
	        return new Token(TokenType.LPAREN, "(");
	      }

	      if (currentChar == ')') {
	        pos++;
	        return new Token(TokenType.RPAREN, ")");
	      }

	      throw new IllegalStateException("wrong character found: " + currentChar);
	    }

	    return new Token(TokenType.EOF,"");
	  }

}
