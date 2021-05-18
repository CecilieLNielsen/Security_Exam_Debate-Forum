package Utils;

import Utils.Exceptions.InvalidPasswordException;

public class PasswordUtil {

    private static final int MINIMAL_LENGTH = 8;
    private static final int MAXIMUM_LENGTH = 45;
    private static final boolean MUST_CONTAIN_LETTERS = true;
    private static final boolean MUST_CONTAIN_LOWERCASE = true;
    private static final boolean MUST_CONTAIN_UPPERCASE = true;
    private static final boolean MUST_CONTAIN_NUMBERS = true;
    private static final boolean MUST_CONTAIN_CHARACTERS = true;
    private static final char[] ILLEGAL_CHARACTERS = {'"', '\''};

    /**
     * Validates if password is valid by the rules in this class
     *
     * @param password1 password
     * @param password2 retyped password
     * @return validation as a boolean
     */
    public static boolean validatePassword(String password1, String password2) throws InvalidPasswordException {
        if (password1 != password2)
            throw new InvalidPasswordException("The two passwords is not equal.");
        if (password1.length() < MINIMAL_LENGTH)
            throw new InvalidPasswordException("The password is to short.");
        if (password1.length() > MAXIMUM_LENGTH)
            throw new InvalidPasswordException("The password is to long.");
        if (MUST_CONTAIN_LETTERS && !containsLetter(password1))
            throw new InvalidPasswordException("The password needs to contain a letter.");
        if (MUST_CONTAIN_LOWERCASE && !containsLowercase(password1))
            throw new InvalidPasswordException("The password needs to contain a lowercase letter.");
        if (MUST_CONTAIN_UPPERCASE && !containsUppercase(password1))
            throw new InvalidPasswordException("The password needs to contain a uppercase letter.");
        if (MUST_CONTAIN_NUMBERS && !containsNumber(password1))
            throw new InvalidPasswordException("The password needs to contain a number.");
        if (MUST_CONTAIN_CHARACTERS && !containsCharacter(password1))
            throw new InvalidPasswordException("The password needs to contain a character.");
        return true;
    }

    private static boolean containsLetter(String str) {
        for (char c : str.toCharArray()) {
            if (isUppercase(c) || isLowercase(c))
                return true;
        }
        return false;
    }

    private static boolean isUppercase(char c) {
        return (int) c >= 65 && (int) c <= 90;
    }

    private static boolean containsUppercase(String str) {
        for (char c : str.toCharArray()) {
            if (isUppercase(c))
                return true;
        }
        return false;
    }

    private static boolean isLowercase(char c) {
        return (int) c >= 97 && (int) c <= 122;
    }

    private static boolean containsLowercase(String str) {
        for (char c : str.toCharArray()) {
            if (isLowercase(c))
                return true;
        }
        return false;
    }

    private static boolean isNumber(char c) {
        return (int) c >= 48 && (int) c <= 57;
    }

    private static boolean containsNumber(String str) {
        for (char c : str.toCharArray()) {
            if (isNumber(c))
                return true;
        }
        return false;
    }

    private static boolean isCharacter(char c) throws InvalidPasswordException {
        for (char illegal : ILLEGAL_CHARACTERS) {
            if (illegal == c)
                throw new InvalidPasswordException("The password may not contain '" + c + "'.");
        }
        return !isLowercase(c) && !isUppercase(c) && !isNumber(c);
    }

    private static boolean containsCharacter(String str) throws InvalidPasswordException {
        for (char c : str.toCharArray()) {
            if (isCharacter(c))
                return true;
        }
        return false;
    }
}
