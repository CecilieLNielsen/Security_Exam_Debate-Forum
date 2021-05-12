package Utils;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    private static final boolean devMode = true;

    /**
     * Using BCrypt to verify password
     *
     * @param given   the password from user input
     * @param correct the password from database
     * @return boolean value of the operation
     */
    public static boolean verify(String given, String correct) {
        return BCrypt.checkpw(given, correct);
    }

    /**
     * Using BCrypt to hash password with salt
     *
     * @param password the password from user input
     * @return hashed version of password
     */
    public static String hash(String password) {
        if (!devMode && "change_me".equals(password))
            throw new RuntimeException("You should change the password");
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
