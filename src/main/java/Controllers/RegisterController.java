package Controllers;

import Models.Beans.RegisterBean;
import Service.Interfaces.ILoginService;
import Service.Service;
import Utils.Exceptions.InvalidPasswordException;
import Utils.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register")
public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        try {
            PasswordUtil.validatePassword(password1, password2);
        } catch (InvalidPasswordException e) {
            request.setAttribute("errMessage", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

        // TODO: Check if email or username is used.

        RegisterBean credentials = new RegisterBean(email, username, password1, password2);
        ILoginService loginService = Service.getInstance();
        loginService.register(credentials);

        request.setAttribute("errMessage", "User with " + email + " is created.");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}