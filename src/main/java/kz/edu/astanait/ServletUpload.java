package kz.edu.astanait;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUpload")
public class ServletUpload extends HttpServlet {
    private String uploadPath;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items = upload.parseRequest (request); // Get all the files
            for (FileItem fi : items) {
                String fileName = fi.getName();
                if (fileName != null) {
                    File fullFile = new File(fi.getName());
                    fi.write(new File(uploadPath + fullFile.getName()));
                }
            }
        } catch (Exception e) {
            // You can jump to the wrong page
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeChecker object = TypeChecker.getInstance();
        this.uploadPath= object.check(request.getParameter("directory"));
        response.sendRedirect(request.getContextPath()+"/jsp/upload.jsp");
    }
    /*public void init() throws ServletException,NullPointerException {
        File uploadFile = new File(this.uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
    }*/
}
