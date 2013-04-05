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
		for (char character : charArray)
		{
			if (charsToReplace.length() > 0) {
				newWord += getCryptChar(character, charsToReplace);
			} else {
				newWord += getCryptChar(character, toNumbers);
			}
		}
		
		return newWord;		
	}
	
	private String getCryptChar(char character, String charsToReplace)
	{
		if (charsToReplace.contains(String.valueOf(character))) {
			int charValue = character;
			return String.valueOf((char) (charValue + 2));
		}
		return String.valueOf(character);
	}
	
	private String getCryptChar(char character,  Boolean toNumbers)
	{
		int charValue = character;
		if (toNumbers) {
			return String.valueOf(charValue + 2);
		}
			return String.valueOf((char) (charValue + 2));
	}
	
	private void checkValidInput(String word) 
	{
		if (word.contains(" "))
			throw new InvalidParameterException();
	}
}
