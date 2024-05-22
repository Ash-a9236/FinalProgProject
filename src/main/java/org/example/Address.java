package org.example;
/*
- Fields

  1. `int streetNo`
  2. `String street`
  3. `String city`
  4. `String province`
  5. `String postalCode`
  6. `String country`

- Methods

  1. `static boolean isPostalCodeValid(String postalCode)` // checks if a postcode is valid or not.
  The length of a postal code can either be `6` or `7`,

     1. if the length is `6`, then it must follow the format: `CDCDCD`,
     2. if the length is `7`, then it must follow the format: `CDC DCD`.
     3. where `C` is a character, while `D` is a digit. Case-insensitive;
     4. Note: this method is a static method, which means it requires a parameter of `postalCode` instead of using the field `postalCode`, the reason of this is because this method should be called in the constructor, before assigning the input `postalCode` to the field `postalCode`, only valid `postalCode` will be assigned to fields, or `null` will be assigned

  2. All argument Constructor, in which the method `isPostalCodeValid()` will first be called to check if the
  parameter `postalCode` is valid or not, if it is valid, then set all fields, while postal code with all character
  uppercase to the field, else set everything as `null`.

  3. toString
  4. equals
  5. getter
  6. setter
 */
public class Address {

}
