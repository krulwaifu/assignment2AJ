<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 9/27/2020
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script type="text/javascript">
        function submitForm() { // submits form
            document.getElementById("ismForm").submit();
        }
        function btnSearchClick()
        {
            if (document.getElementById("ismForm")) {
                setTimeout("submitForm()", 5000); // set timout
            }
        }
    </script>
    <script>
        var i = 0;
        function move() {
            if (i == 0) {
                i = 1;
                var elem = document.getElementById("myBar");
                var width = 1;
                var id = setInterval(frame, 500);
                function frame() {
                    if (width >= 100) {
                        clearInterval(id);
                        i = 0;
                    } else {
                        width++;
                        elem.style.width = width + "%";
                    }
                }
            }
        }
    </script>
    <style>
        #myProgress {
            width: 100%;
            background-color: #ddd;
        }

        #myBar {
            width: 1%;
            height: 30px;
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
<!--includes header's code from header.jsp -->
<%@ include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/UploadFile" method="post" enctype="multipart/form-data" id="ismForm" style="text-align: center;margin-top: 40vh;">
    <h1>Welcome to File Uploader</h1><br>
    <input type="file" name="fileName" multiple><br>
    <button class="btn btn-success" type="submit"  onclick="move();btnSearchClick();">upload</button>
</form>
<div id="myProgress">
    <div id="myBar"></div>
</div>
<!--includes footer's code from footer.jsp -->
<%@include file="footer.jsp"%>
</body>
</html>
