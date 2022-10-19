<%@ page import="com.example.ex22.ShoppingCart.Book" %>
<%@ page import="com.example.ex22.ShoppingCart.BookStore" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.sun.jdi.IntegerType" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Scanner" %><%--
  Created by IntelliJ IDEA.
  User: voldi
  Date: 18.10.2022
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookStore</title>
    <style type="text/css">
        TABLE {
            width: 100%;
            height: 100%;
        }

        DIV {
            background: black;
            width: 100%;
            align: center;
        }

        #menu {
            background: black;
            width: 100%;
            align: center;
            justify-content: center;
            align-items: center;
            top: 0;
            left: 0;
            width: 100%;
        }

        #menu .content {
            top: 0;
            left: 0;
        }

        #menu .content a {
            color: wheat;
            text-decoration: none;
            display: inline-block;
            align-self: auto;
            width: 32%;
        }
    </style>
</head>
<body>
<div id="menu">
    <div class="content">
        <p><a align="left" href="">Profile</a>
            <a href="ShoppingCartServlet">Cart</a>
            <a href="">logout</a></p>
        <%--<h3 align="center">hello hello hello</h3>--%>
    </div>
</div>
<h1 align="center">Bookstore</h1>
    <%
        BookStore bookStore = new BookStore();
        String books;
        Cookie[] cookies = request.getCookies();
        String login = null;
        String password = null;
        if (cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    login = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
        if(login != null && password != null ){
            books = bookStore.getBooksForPrint();
        }
        else{
            books = "<h3 >Please Login</h3>" +
                    "<a  href=\"UserLogin.html\">login Page</a>"
            ;
        }
    %>
    <%=books%>

</body>
</html>
