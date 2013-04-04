package com.iexpertos.encriptor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Encriptor encriptor = new Encriptor();
		System.out.println("1:" + encriptor.cryptWord("hola"));
		System.out.println("2:" + encriptor.cryptWordToNumbers("hola"));
		System.out.println("3:" + encriptor.cryptWord("hola", "o"));
		System.out.println("4:" + encriptor.cryptSentence("hola, que tal estas?"));
		encriptor.printWords("hola, que tal estas?");

	}

}
