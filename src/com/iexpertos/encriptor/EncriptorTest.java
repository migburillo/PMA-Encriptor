package com.iexpertos.encriptor;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.security.InvalidParameterException;

public class EncriptorTest {
	Encriptor encriptor;

	@Before
	public void initialize() {
		encriptor = new Encriptor();
	}

	@Test
	public void crypt_word_hola() {
		String expected = "jqnc";
		String response = encriptor.cryptWord("hola");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void crypt_word_hola_one_char_only() {
		String expected = "hqla";
		String response = encriptor.cryptWord("hola", "o");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void crypt_word_hola_to_numbers() {
		String expected = "10611311099";
		String response = encriptor.cryptWordToNumbers("hola");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void crypt_sentence() {
		String expected = "jqnc.\"swg\"vcn\"guvcuA";
		String response = encriptor.cryptSentence("hola, que tal estas?");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void get_words() {
		String[] expected = { "hola,", "que", "tal", "estas?" };
		String[] response = encriptor.getWords("hola, que tal estas?");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void print_words() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		encriptor.printWords("hola, que tal estas?");
		String expected = "<hola,><que><tal><estas?>";
		assertThat(expected, equalTo(outContent.toString()));
	}

	@Test(expected = InvalidParameterException.class)
	public void crypt_word_invalid_input() {
		encriptor.cryptWord(" ");
	}

	@Test(expected = InvalidParameterException.class)
	public void crypt_word_hola_to_numbers_invalid_input() {
		encriptor.cryptWord(" ");
	}

	@Test(expected = InvalidParameterException.class)
	public void crypt_word_hola_one_char_only_invalid_input() {
		encriptor.cryptWord(" ", "a");
	}
}
