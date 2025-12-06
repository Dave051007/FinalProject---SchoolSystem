package org.dave;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Address {
    @Setter private int streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
        } else  {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            System.out.println("Invalid postal code");
        }
    }

    /**
     * Checks if the postal code is valid
     * @param postalCode the postal code to be checked
     * @return true if the postal code is valid, otherwise false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            return false;
        }

        if (postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < postalCode.length(); i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0) {
                if (!(Character.isLetter(c))) {
                    return false;
                }
            }  else {
                if (!(Character.isDigit(c))) {
                    return false;
                }
            }
        }

        return true;
    }


    public enum Province {
        AB, BC, MB, NB, NL, NS, ON, PE, QC, SK
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode;
        }  else {
            this.postalCode = null;
            System.out.println("Invalid postal code");
        }
    }
}
