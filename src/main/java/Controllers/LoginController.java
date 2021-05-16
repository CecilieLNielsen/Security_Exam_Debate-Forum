package Controllers;

import Models.Beans.LoginBean;
import Models.Beans.UserBean;
import Models.DTO.ThreadDTO;
import Service.Interfaces.ILoginService;
import Service.Interfaces.IThreadService;
import Service.Service;
import Utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginBean loginCredentials = new LoginBean(email, password);
        ILoginService loginService = Service.getInstance();
        UserBean userBean = loginService.verifyCredentialsAndLogin(loginCredentials);

        HttpSession session = SessionUtil.getSession(request);
        session.setAttribute("userBean", userBean);
        if (userBean != null) {
            IThreadService threadService = Service.getInstance();
            List<ThreadDTO> allThreads = threadService.getAllThreads();

            session.setAttribute("allThreads", allThreads);
            request.getRequestDispatcher("/allThreads.jsp").forward(request, response);
        } else {
            request.setAttribute("errMessage", "Invalid combination of email and password!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}