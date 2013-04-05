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
				if (charsToReplace.contains(String.valueOf(character))) {
					int charValue = character;
					newWord += String.valueOf((char) (charValue + 2));
				} else {
					newWord += String.valueOf(character);
				}
			} else {
				int charValue = character;
				if (toNumbers) {
					newWord += String.valueOf(charValue + 2);
				} else {
					newWord += String.valueOf((char) (charValue + 2));
				}
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
