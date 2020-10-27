<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: super
  Date: 9/27/2020
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome to File Search Results</h1><br>
    <%
        ArrayList<File> list = (ArrayList<File>) request.getAttribute("matchingFiles");
        for (File f: list) {%>
            <%out.print(f.getName()+" ("+ f.length()/1024 + "KB)");%><br>
        <%}%>

</body>
</html>
