package org.dave;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

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
}
