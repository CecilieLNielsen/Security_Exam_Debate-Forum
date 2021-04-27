package Controllers;

import Models.ThreadDTO;
import Models.ThreadWithCommentsDTO;
import Service.IThreadService;
import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "CreateThread")
public class CreateThreadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if user is logged in - if not redirect to login page
        //ILoginService loginService = new LoginService();
        //if (!loginService.isLoggedin()) {
        //    request.getRequestDispatcher("/logintemp.jsp").forward(request, response);
        //}

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        ThreadDTO thread = new ThreadDTO(title, category, author, description);

        IThreadService threadService = new Service();
        int threadId = threadService.createThread(thread);

        HttpSession session = request.getSession();
        session.setAttribute("threadId", threadId);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
