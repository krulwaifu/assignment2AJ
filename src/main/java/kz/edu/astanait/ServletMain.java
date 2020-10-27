package kz.edu.astanait;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMain")
public class ServletMain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String where = request.getParameter("redirecting");
        switch (where){
            case "upload": response.sendRedirect(request.getContextPath() + "/jsp/chooseType.jsp");
            break;
            case "download": response.sendRedirect(request.getContextPath() + "/jsp/chooseDirectory.jsp");
            break;
            case "manage": response.sendRedirect(request.getContextPath() + "/jsp/chooseDelDirectory.jsp");
            break;
            case "search": response.sendRedirect(request.getContextPath() + "/jsp/chooseSearchDir.jsp");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
