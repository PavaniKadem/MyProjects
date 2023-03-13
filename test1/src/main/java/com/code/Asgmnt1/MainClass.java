package com.code.Asgmnt1;

import java.util.Scanner;

import com.code.Asgmnt1.Grammar.TokenType;

public class MainClass {

	public static void main(String[] args) {
		System.out.print("enter input:");
		Scanner scanner = new Scanner(System.in);
	    String line = scanner.nextLine();
	    LexicalAnalyzer lex = new LexicalAnalyzer(line);
	    Token token;
		try {
			token = lex.getToken();
	    System.out.print("output of the lexical Analyzer: \n");
	    while (token.getTokType() != TokenType.EOF) {
	      System.out.println(token.getTokType() + "   " + token.getLexeme());
	      token = lex.getToken();
	    }
		} catch (Exception e) {
			System.out.println("~~Exception occured~~");
			e.printStackTrace();
		}
	}

}
