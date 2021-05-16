package Controllers;

import Models.DTO.ThreadWithCommentsDTO;
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


@WebServlet(name = "GetThreadById")
public class GetThreadByIdController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = SessionUtil.getSession(request);
        if (!SessionUtil.isLoggedIn(session)) {
            request.setAttribute("errMessage", "Invalid session! Please login again.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        int id = Integer.parseInt(request.getParameter("id"));

        IThreadService threadService = Service.getInstance();

        ThreadWithCommentsDTO threadWithComments = threadService.getThreadWithCommentsById(id);

        session.setAttribute("threadWithComments", threadWithComments);

        request.getRequestDispatcher("/seeThread.jsp").forward(request, response);
    }
}
