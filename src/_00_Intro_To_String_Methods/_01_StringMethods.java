package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() >= s2.length()) {
			return s1;
		}
		return s2;
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		String n = "";
		if (s.contains("underscores")) {
			n = s.replace(' ', '_');
			return n;
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String n1 = s1.trim();
		String n2= s2.trim();
		String n3= s3.trim();

		String[] name1 = n1.split(" ");
		String[] name2 = n2.split(" ");
		String[] name3 = n3.split(" ");
		String last1 = name1[1];
		String last2 = name2[1];
		String last3 = name3[1];
		int n2ton3 = 0;
		int n1ton3 = 0;
		int n1ton2 = last1.compareToIgnoreCase(last2);
		if(n1ton2 > 0) {
			n2ton3 = last2.compareToIgnoreCase(last3);
			if(n2ton3 >0) {
				return n3;
			}
			else {
				return n2;
			}
		}else {
			n1ton3 = last1.compareToIgnoreCase(last3);
			if(n1ton3 >0) {
				return n3;
			}else {
				return n1;
			}
		}


	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int tot = 0;

		for (int i = 0; i < s.length(); i++) {
			int j = s.charAt(i);
			if (Character.isDigit(j) == true) {
				int r = Character.getNumericValue(j);
				tot += r;
			}
		}
		return tot;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int n =0;
		while(s.indexOf(substring)>-1) {
			n++;
			s=s.substring(s.indexOf(substring)+substring.length());
		}
		return n;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] bob = s.getBytes();
		byte bobert =(byte) key;
		String bobertson = Utilities.encrypt(bob, bobert);
		return bobertson;
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte) key);

	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		String[] array = s.split(" ");
		int charMatchCount = 0;
		int endsWithCount = 0;
		int lenSubstring = substring.length();

		for (int i = 0; i < array.length; i++) {
			int index = array[i].length()-lenSubstring;
			if(index < 0) {
				continue;
			}
			System.out.println(index);
			for (int j = 0; j < lenSubstring; j++) {
				if(array[i].charAt(index+j)==substring.charAt(j)) {
					System.out.println("true");
					charMatchCount++;
					if(charMatchCount == lenSubstring) {
						endsWithCount++;
						System.out.println("****           " + array[i]);
					}
				}
			}
			charMatchCount = 0; 
		}

		return endsWithCount;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		    int first = s.indexOf(substring);
		    int last = s.lastIndexOf(substring);
		    return last - (first + substring.length());
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		for(int i = 0, j =s.length()-1     ;   i<= j     ;       i++, j--) {
			while(Character.isAlphabetic(s.charAt(i))==false) {
				i++;
			}
			while(Character.isAlphabetic(s.charAt(j))==false) {
				j--;
			}
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase( s.charAt(j))) {

				return false;
			}


			
		}
		return true;
	}
}
	class Utilities {
		// This basic encryption scheme is called single-byte xor. It takes a
		// single byte and uses exclusive-or on every character in the String.
		public static String encrypt(byte[] plaintext, byte key) {
			for (int i = 0; i < plaintext.length; i++) {
				plaintext[i] = (byte) (plaintext[i] ^ key);
			}
			return Base64.getEncoder().encodeToString(plaintext);
		}

		public static String decrypt(String cyphertext, byte key) {
			byte[] b = Base64.getDecoder().decode(cyphertext);
			for (int i = 0; i < b.length; i++) {
				b[i] = (byte) (b[i] ^ key);
			}
			return new String(b);
		}
	}


