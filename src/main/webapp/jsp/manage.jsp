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
<form action="${pageContext.request.contextPath}/ServletDelete" method="get" style="text-align: center;margin-top: 40vh;">
    <h1>Welcome to File Deleter</h1><br>
    <%
        File[] list = (File[]) request.getAttribute("files");
        int folderSize = 0;
        for (File f: list) {
            folderSize += f.length()/1024;
    %>
    <input type="radio" name="FileName" value="<%out.print(f.getName());%>"><%out.print(f.getName()+" ("+ f.length()/1024 + "KB)");%><br>
    <%}%>
    <%out.print("Size of the folder:"+" ("+ folderSize + "KB)");%>
    <button class="btn btn-success" type="submit">delete</button>
</form>
</body>
</html>
