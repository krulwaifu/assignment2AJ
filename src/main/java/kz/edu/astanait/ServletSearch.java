package kz.edu.astanait;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/ServletSearch", name = "ServletSearch")
public class ServletSearch extends HttpServlet {
    String downloadPath;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("search"));
        if (request.getParameter("search") == null) {
            request.getRequestDispatcher("/jsp/search.jsp").forward(request, response);
        }

        String search = request.getParameter("search");

        ArrayList<File> matchingFiles = findMatches(search);

        request.setAttribute("matchingFiles", matchingFiles);

        request.getRequestDispatcher("/jsp/results.jsp").forward(request, response);
    }

    private ArrayList<File> findMatches(String search) {
        // We use our search  as a Regular Expression
        Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
        ArrayList<File> fileList = new ArrayList<>();

        File[] files = new File(downloadPath).listFiles();

        for (File item : files) {
            Matcher matcher = pattern.matcher(item.getName());
            boolean matchesPattern = matcher.find();
            if (matchesPattern) {
                fileList.add(item);
            }
        }

        return fileList;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeChecker object = TypeChecker.getInstance();
        this.downloadPath= object.check(request.getParameter("directory"));
        response.sendRedirect(request.getContextPath()+"/jsp/search.jsp");
    }
}
