package Controllers;

import Models.Beans.LoginBean;
import Service.Interfaces.ILoginService;
import Service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginBean loginCredentials = new LoginBean(email, password);
        ILoginService loginService = LoginService.getInstance();
        boolean isValid = loginService.verifyCredentials(loginCredentials);

        // TODO: Retrieve correct user
        // TODO: Create token or something like

        if (isValid) {
            request.getRequestDispatcher("/allThreads.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}