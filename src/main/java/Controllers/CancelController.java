package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Cancel")
public class CancelController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if user is logged in - if not redirect to login page
        //ILoginService loginService = new LoginService();
        //if (!loginService.isLoggedin()) {
        //    request.getRequestDispatcher("/index.jsp").forward(request, response);
        //}

        request.getRequestDispatcher("/allThreads.jsp").forward(request, response);
    }
}
