package kz.edu.astanait;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ServletDelete")
public class ServletDelete extends HttpServlet {
    String downloadPath;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.downloadPath == null){
            TypeChecker object = TypeChecker.getInstance();
            this.downloadPath= object.check(request.getParameter("directory"));
            request.getRequestDispatcher("/ServletDelete").forward(request, response);
        }else {
            File[] files = new File(downloadPath).listFiles();
            request.setAttribute("files", files);
            request.getRequestDispatcher("/jsp/manage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aFileName = new String(request.getParameter("FileName").getBytes(
                "iso8859-1"), "gbk");

        File file = new File(downloadPath, aFileName);

        response.setContentType("text/html;charset=GBK");

        if (!file.isDirectory()) {
            file.delete();
            response.sendRedirect(request.getContextPath() + "/index.html");
        }
    }
}
