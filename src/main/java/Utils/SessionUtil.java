package Utils;

import Models.Beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static HttpSession getSession(HttpServletRequest request) {
        // Stored userBean variable
        UserBean userBean = null;
        // Get the old session
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            // Get old userBean
            userBean = (UserBean) oldSession.getAttribute("userBean");
            // Invalidate old session
            oldSession.invalidate();
        }
        // Generate a new session
        HttpSession newSession = request.getSession(true);
        // Store old userBean on new session
        newSession.setAttribute("userBean", userBean);

        // Setting the session to expiry in 15 mins
        newSession.setMaxInactiveInterval(15 * 60);

        return newSession;
    }

    public static boolean isLoggedIn(HttpSession session) {
        UserBean userBean = (UserBean) session.getAttribute("userBean");
        // If userBean is null return false else true
        return userBean != null;
    }
}
