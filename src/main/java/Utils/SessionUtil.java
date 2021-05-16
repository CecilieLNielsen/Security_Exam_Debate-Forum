package Utils;

import Models.Beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static HttpSession getSession(HttpServletRequest request) {
        // Stored userBean
        UserBean userBean = null;
        // Get the old session and invalidate
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            // Get old userBean
            userBean = (UserBean) oldSession.getAttribute("userBean");
            oldSession.invalidate();
        }
        // Generate a new session
        HttpSession newSession = request.getSession(true);
        // Store old userBean on new session
        newSession.setAttribute("userBean", userBean);

        // Setting the session to expiry in 15 mins
        newSession.setMaxInactiveInterval(15*60);

        return newSession;
    }
}
