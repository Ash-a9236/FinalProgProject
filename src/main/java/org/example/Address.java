package org.example;
/*

- Methods

  1. `static boolean isPostalCodeValid(String postalCode)` // checks if a postcode is valid or not.
  The length of a postal code can either be `6` or `7`,

     1. if the length is `6`, then it must follow the format: `CDCDCD`,
     2. if the length is `7`, then it must follow the format: `CDC DCD`.
     3. where `C` is a character, while `D` is a digit. Case-insensitive;
     4. Note: this method is a static method, which means it requires a parameter of `postalCode` instead of using
     the field `postalCode`, the reason of this is because this method should be called in the constructor,
     before assigning the input `postalCode` to the field `postalCode`,
     only valid `postalCode` will be assigned to fields, or `null` will be assigned

  2. All argument Constructor, in which the method `isPostalCodeValid()` will first be called to check if the
  parameter `postalCode` is valid or not, if it is valid, then set all fields, while postal code with all character
  uppercase to the field, else set everything as `null`.

  3. toString
  4. equals
  5. getter
  6. setter
 */
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    /**
     * checks if a postcode is valid or not
     * @param postalCode the input postal code
     * @return if a postal code has a length of 6 && is under the format CDCDCD or has a length of 7 && is under the
     * format CDC DCD
     */
    public static boolean isPostalCodeValid(String postalCode) {
        postalCode.toLowerCase();
        boolean isValid = false;

        if (postalCode == null) {
            isValid = false;
        } else if (postalCode.length() < 6 || postalCode.length() >7)) {
            isValid = false;
        }

       

        return isValid;
    }

    /*

    /**
     * Formats a postal code to be CDCDCD if it has a length of 6
     * @param postalCode the input string
     * @return the postal code in CDCDCD format
     */
  /*  public static boolean isValid6(String postalCode) {
        return Character.isLetter(postalCode.charAt(0)) &&
                Character.isDigit(postalCode.charAt(1)) &&
                Character.isLetter(postalCode.charAt(2)) &&
                Character.isDigit(postalCode.charAt(3)) &&
                Character.isLetter(postalCode.charAt(4)) &&
                Character.isDigit(postalCode.charAt(5));
    }

    /**
     * Formats a postal code to be CDC DCD if it has a length of 7
     * @param postalCode the input string
     * @return the postal code in CDC DCD format
     */
  /*  public static boolean isValid7(String postalCode) {
        return Character.isLetter(postalCode.charAt(0)) &&
                Character.isDigit(postalCode.charAt(1)) &&
                Character.isLetter(postalCode.charAt(2)) &&
                postalCode.charAt(3) == ' ' &&
                Character.isDigit(postalCode.charAt(4)) &&
                Character.isLetter(postalCode.charAt(5)) &&
                Character.isDigit(postalCode.charAt(6));
    }
/*
    /**
     * Checks if a postal code is valid or not and formats it according to its length
     * @param postalCode the input string
     * @return the postal code in the correct format
     */
  /*  public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() == 6) {
            return isValid6(postalCode);
        } else if (postalCode.length() == 7) {
            return isValid7(postalCode);
        }
        return false;
    }
     */
}
