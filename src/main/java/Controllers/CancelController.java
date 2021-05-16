package Controllers;

import Utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "Cancel")
public class CancelController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = SessionUtil.getSession(request);
        if(!SessionUtil.isLoggedIn(session)) {
            request.setAttribute("errMessage", "Invalid session! Please login again.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/allThreads.jsp").forward(request, response);
    }
}
