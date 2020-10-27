package kz.edu.astanait;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet(name = "ServletDownload")
public class ServletDownload extends HttpServlet {
    String downloadPath;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.downloadPath == null){
        TypeChecker object = TypeChecker.getInstance();
        this.downloadPath= object.check(request.getParameter("directory"));
            request.getRequestDispatcher("/ServletDownload").forward(request, response);
        }else {
            File[] files = new File(downloadPath).listFiles();
            request.setAttribute("files", files);
            request.getRequestDispatcher("/jsp/download.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aFileName = new String(request.getParameter("FileName").getBytes(
                "iso8859-1"), "gbk");

        File fileLoad = new File(downloadPath, aFileName);

        FileInputStream in = null; //input stream
        OutputStream out = response.getOutputStream();
        byte b[] = new byte[1024];

        try {

            response.setContentType("application/x-msdownload;");

            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(aFileName.getBytes("GBK"), "iso8859-1"));

            // download the file.
            in = new FileInputStream(fileLoad);
            int n = 0;
            while ((n = in.read(b)) != -1) {
                out.write(b, 0, n);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/index.html");
    }
}
