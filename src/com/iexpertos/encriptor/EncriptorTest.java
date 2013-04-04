package com.iexpertos.encriptor;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EncriptorTest {
	Encriptor encriptor;

	@Before
	public void initialize() {
		encriptor = new Encriptor();
	}

	@Test
	public void testCryptWordString() {
		String expected = "jqnc";
		String response = encriptor.cryptWord("hola");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void testCryptWordStringString() {
		String expected = "hqla";
		String response = encriptor.cryptWord("hola", "o");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void testCryptWordToNumbers() {
		String expected = "10611311099";
		String response = encriptor.cryptWordToNumbers("hola");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void testCryptSentence() {
		String expected = "jqnc.\"swg\"vcn\"guvcuA";
		String response = encriptor.cryptSentence("hola, que tal estas?");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void testGetWords() {
		String[] expected = {"hola,", "que", "tal", "estas?"};
		String[] response = encriptor.getWords("hola, que tal estas?");
		assertThat(expected, equalTo(response));
	}

	@Test
	public void testPrintWords() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		encriptor.printWords("hola, que tal estas?");
		String expected = "<hola,><que><tal><estas?>";
		assertThat(expected, equalTo(outContent.toString()));
	}

}
