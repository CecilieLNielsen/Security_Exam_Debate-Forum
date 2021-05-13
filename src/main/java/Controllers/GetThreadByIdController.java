package Controllers;

import Models.DTO.ThreadWithCommentsDTO;
import Service.Interfaces.IThreadService;
import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "GetThreadById")
public class GetThreadByIdController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if user is logged in - if not redirect to login page
        //ILoginService loginService = new LoginService();
        //if (!loginService.isLoggedin()) {
        //    request.getRequestDispatcher("/index.jsp").forward(request, response);
        //}

        // Get all threads and redirect to all threads page
        int id = Integer.parseInt(request.getParameter("id"));
        IThreadService threadService = Service.getInstance();
        ThreadWithCommentsDTO threadWithComments = threadService.getThreadWithCommentsById(id);

        HttpSession session = request.getSession();
        session.setAttribute("threadWithComments", threadWithComments);

        request.getRequestDispatcher("/seeThread.jsp").forward(request, response);
    }
}
