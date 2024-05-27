package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
            this.country = country;
        } else {
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    /**
     * checks if a postcode is valid or not
     * @param postalCode the input postal code
     * @return if a postal code has a length of 6 && is under the format CDCDCD or has a length of 7 && is under the
     * format CDC DCD
     */
    public static boolean isPostalCodeValid(String postalCode) {

        if (postalCode == null) {
            System.out.println("The postal code is null");
            return false;
        } else if (postalCode.length() < 6 || postalCode.length() >7) {
            System.out.println("The postal code is not valid");
            return false;
        }

        if (postalCode.length() == 6) {
            return Character.isLetter(postalCode.charAt(0)) &&
                    Character.isDigit(postalCode.charAt(1)) &&
                    Character.isLetter(postalCode.charAt(2)) &&
                    Character.isDigit(postalCode.charAt(3)) &&
                    Character.isLetter(postalCode.charAt(4)) &&
                    Character.isDigit(postalCode.charAt(5));
            }
        if (postalCode.length() == 7) {
            return Character.isLetter(postalCode.charAt(0)) &&
                    Character.isDigit(postalCode.charAt(1)) &&
                    Character.isLetter(postalCode.charAt(2)) &&
                    postalCode.charAt(3) == ' ' &&
                    Character.isDigit(postalCode.charAt(3)) &&
                    Character.isLetter(postalCode.charAt(4)) &&
                    Character.isDigit(postalCode.charAt(5)) &&
                    Character.isDigit(postalCode.charAt(6));
        }

        System.out.println("The postal code is not valid");
        return false;
    }

    public void setPostalCode(String postalCode) {
    this.postalCode = isPostalCodeValid(postalCode) ? postalCode : null;
    }

}
