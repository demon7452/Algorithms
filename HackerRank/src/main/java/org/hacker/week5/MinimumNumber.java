package org.hacker.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumber {
    public static void main(String[] args) {
        System.out.println(minimumNumber2(5, "12345"));
    }


    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        Set<String> typeSet = new HashSet<>();
        for (char c : password.toCharArray()) {
            String str = String.valueOf(c);
            if (numbers.contains(str)){
                typeSet.add(numbers);
            } else if (lower_case.contains(str)) {
                typeSet.add(lower_case);
            } else if (upper_case.contains(str)) {
                typeSet.add(upper_case);
            } else if (special_characters.contains(str)) {
                typeSet.add(special_characters);
            }
        }
        int count = 4 - typeSet.size();
        if (n >= 6) {
            return count;
        } else {
            int sub = 6 - n;
            return Math.max(count, sub);
        }
    }

    public static int minimumNumber2(int n, String password) {
        int countMissing = 0;

        // Check the length of the password
        if (n < 6) {
            countMissing = Math.max(countMissing, 6 - n);
        }

        // Check for missing digit, lowercase letter, uppercase letter, and special character
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        String specialCharacters = "!@#$%^&*()-+";

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (specialCharacters.indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        if (!hasDigit) {
            countMissing++;
        }
        if (!hasLower) {
            countMissing++;
        }
        if (!hasUpper) {
            countMissing++;
        }
        if (!hasSpecial) {
            countMissing++;
        }

        return countMissing;
    }


}
