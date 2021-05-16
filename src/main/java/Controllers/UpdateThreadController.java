package Controllers;

import Models.DTO.ThreadDTO;
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


@WebServlet(name = "UpdateThread")
public class UpdateThreadController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if user is logged in - if not redirect to login page
        //ILoginService loginService = new LoginService();
        //if (!loginService.isLoggedin()) {
        //    request.getRequestDispatcher("/index.jsp").forward(request, response);
        //}

        int id = Integer.parseInt(request.getParameter("id"));
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        ThreadDTO thread = new ThreadDTO(id, title, category, author, description);

        IThreadService threadService = Service.getInstance();
        int threadId = threadService.updateThread(thread);

        HttpSession session = SessionUtil.getSession(request);
        session.setAttribute("threadId", threadId);

        request.getRequestDispatcher("/allThreads.jsp").forward(request, response);
    }
}
