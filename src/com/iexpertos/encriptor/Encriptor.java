package com.iexpertos.encriptor;

import java.security.InvalidParameterException;

public class Encriptor {
	
	public String cryptWord(String word)
	{
		checkValidInput(word);		
		return cryptChars(word, false, "");		
	}
	
	public String cryptWordToNumbers(String word)
	{
		checkValidInput(word);		
		return cryptChars(word, true, "");	
	}

	public String cryptWord(String word, String charsToReplace)
	{
		checkValidInput(word);
		if(charsToReplace.length() >0){
			return cryptChars(word, false, charsToReplace);
		}
		return word;
	}
	
	public String cryptSentence(String sentence)
	{
		return cryptChars(sentence, false, "");		
	}
	
	public String[] getWords(String sentence)
	{
		return sentence.split(" ");
	}
	
	public void printWords(String sentence)
	{
		String[] words = getWords(sentence);
		for (String word : words)
		{
			System.out.print("<" + word + ">");
		}
	}
	
	private String cryptChars(String chars, Boolean toNumbers, String charsToReplace)
	{
		char[] charArray = chars.toCharArray();
		String newWord = "";
		for (char character : charArray) {
			if (charsToReplace.length() > 0) {
				newWord += String.valueOf(getCryptChar(character,
						charsToReplace));
			} else if (toNumbers) {
				newWord += String.valueOf(getAsciiModified(character));
			} else {
				newWord += String.valueOf((char) getAsciiModified(character));
			}
		}
		
		return newWord;		
	}
	
	private char getCryptChar(char character, String charsToReplace)
	{
		if (charsToReplace.contains(String.valueOf(character))) {
			return (char) getAsciiModified(character);
		}
		return character;
	}
	
	private int getAsciiModified(char character)
	{
		int charValue = character;
		return charValue + 2;
	}
	
	private void checkValidInput(String word) 
	{
		if (word.contains(" "))
			throw new InvalidParameterException();
	}
}
