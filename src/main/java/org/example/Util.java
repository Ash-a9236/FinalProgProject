package org.example;
/*
A class `Util` locates in a new package `util` which contains
- Methods:

1. `static String toTitleCase(String strIn)` // converts each word in a string to title case,
such as `Yi Wang`, `Computer Science`. You can
   1. simply assume the string `strIn` only contains two words with one space in between,
   2. or you can implement the method for general situation, in this case, `str.split()` method will be used.
   3. All `studentName`, `departmentName`, `courseName` needs to be in title case.
*/

public class Util {

    /**
     * converts each word in a string to title case
     * @param strIn the input string
     * @return the string with the first letter of both words capitalized
     */
    public static String toTitleCase(String strIn) {
        int spaceIdx = strIn.indexOf(' ');

        String fWord = strIn.substring(0, spaceIdx);
        String capLetter = fWord.substring(0, 1).toUpperCase();
        String restLetters = fWord.substring(1).toLowerCase();
        fWord = capLetter + restLetters;

        String lWord = strIn.substring(spaceIdx + 1);
        String capLetter2 = lWord.substring(0, 1).toUpperCase();
        String restLetter2 = lWord.substring(1).toLowerCase();
        lWord = capLetter2 + restLetter2;
        return fWord + " " + lWord;
    }
}
