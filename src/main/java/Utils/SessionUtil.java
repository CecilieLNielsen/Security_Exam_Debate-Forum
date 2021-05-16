package Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (!session.isNew()) {
            session.invalidate();
            session = request.getSession(true);
        }
        return session;
    }
}
