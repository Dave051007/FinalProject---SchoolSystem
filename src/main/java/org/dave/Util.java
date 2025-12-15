package org.dave;

public class Util {

    /**
     * Converts each word in a string to title case --> Xxxxxx
     * @param str the string to be converted to title case
     * @return the string in title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String strInTitleCase = "";
        String[] strArray = str.split(" ");
        for (String word : strArray) {
            strInTitleCase += word.substring(0, 1).toUpperCase() +
                              word.substring(1).toLowerCase() +
                              " ";
        }

        return strInTitleCase.trim();
    }
}
