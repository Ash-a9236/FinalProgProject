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
/*
 public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        String[] words = strIn.split(" ");
        StringBuilder titleCased = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCased.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return titleCased.toString().trim();
    }
 */

public class Util {


    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        String[] words = strIn.split(" ");
        StringBuilder titleCased


        return strOut;
    }
}
