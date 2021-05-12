package Controllers;

import Models.DTO.ThreadDTO;
import Service.IThreadService;
import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DeleteThread")
public class DeleteThreadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if user is logged in - if not redirect to login page
        //ILoginService loginService = new LoginService();
        //if (!loginService.isLoggedin()) {
        //    request.getRequestDispatcher("/logintemp.jsp").forward(request, response);
        //}

        int id = Integer.parseInt(request.getParameter("id"));
        IThreadService threadService = Service.getInstance();
        threadService.deleteThread(id);
        List<ThreadDTO> allThreads = threadService.getAllThreads();

        HttpSession session = request.getSession();
        session.setAttribute("allThreads", allThreads);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
