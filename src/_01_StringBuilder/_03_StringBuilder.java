package _01_StringBuilder;

import java.util.Iterator;

public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
        StringBuilder builder = new StringBuilder(str);

        
    	return builder.append(characters).toString();
    }
    
    public static String reverse(String str) {
       StringBuilder builder = new StringBuilder(str);
    	
    	return builder.reverse().toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder builder = new StringBuilder(str);
    	
    	return builder.insert(index, newChar).toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
       StringBuilder builder = new StringBuilder(str);
    	
    	return builder.delete(startIndex, endIndex).toString();
    }
}