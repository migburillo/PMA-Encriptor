package com.iexpertos.encriptor;

import java.security.InvalidParameterException;

public class Encriptor {
	
	public String cryptWord(String word)
	{
		checkValidInput(word);		
		return cryptChars(word, false);		
	}
	
	public String cryptWordToNumbers(String word)
	{
		checkValidInput(word);
		
		return cryptChars(word, true);	
	}

	public String cryptWord(String word, String charsToReplace)
	{
		checkValidInput(word);
		
		char[] wordArray = word.toCharArray();

		String newWord = "";
		
		for (char character : wordArray)
		{
			if (charsToReplace.contains(String.valueOf(character))) {
				int charValue = character;
				newWord += String.valueOf((char) (charValue + 2));
			} else {
				newWord += String.valueOf((char) character);
			}
		}
		return newWord;
	}
	
	public String cryptSentence(String sentence)
	{
		return cryptChars(sentence, false);		
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
	
	private String cryptChars(String chars, Boolean toNumbers)
	{
		char[] charArray = chars.toCharArray();
		String newWord = "";
		for (int i = 0; i < chars.length(); i++)
		{
			int charValue = charArray[i];
			if (toNumbers) {
				newWord += String.valueOf(charValue + 2);
			} else {
				newWord += String.valueOf((char) (charValue + 2));
			}
		}
		
		return newWord;		
	}
	
	private void checkValidInput(String word) 
	{
		if (word.contains(" "))
			throw new InvalidParameterException();
	}
}
