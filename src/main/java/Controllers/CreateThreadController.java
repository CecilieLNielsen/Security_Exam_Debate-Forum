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
import java.util.List;


@WebServlet(name = "CreateThread")
public class CreateThreadController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = SessionUtil.getSession(request);
        if(!SessionUtil.isLoggedIn(session)) {
            request.setAttribute("errMessage", "Invalid session! Please login again.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        ThreadDTO thread = new ThreadDTO(title, category, description);

        IThreadService threadService = Service.getInstance();

        int threadId = threadService.createThread(thread);
        List<ThreadDTO> allThreads = threadService.getAllThreads();

        session.setAttribute("threadId", threadId);
        session.setAttribute("allThreads", allThreads);

        request.getRequestDispatcher("/allThreads.jsp").forward(request, response);
    }
}
