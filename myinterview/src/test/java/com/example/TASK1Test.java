package com.example;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

public class TASK1Test {

    @Test
    public void testIsPalindrome() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = TASK1.class.getDeclaredMethod("_isPalindrome", String.class);
        method.setAccessible(true);

        String palindromeWord = "arara";
        assertEquals(palindromeWord + " is a palindrome", method.invoke(null, palindromeWord));

        String noPalindromeWord = "America";
        assertEquals(noPalindromeWord + " is not a palindrome", method.invoke(null, noPalindromeWord));

        String palindromePhrase = "Ame a ema";
        assertEquals(palindromePhrase + " is a palindrome", method.invoke(null, palindromePhrase));

        String noPalindromePhrase = "This is not a palindrome";
        assertEquals(noPalindromePhrase + " is not a palindrome", method.invoke(null, noPalindromePhrase));
    }
}

