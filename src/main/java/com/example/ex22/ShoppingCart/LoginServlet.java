package com.example.ex22.ShoppingCart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.Scanner;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileReader fileReader = new FileReader("logins.txt");
        File file = new File("logins.txt");
        boolean loginIsTrue = false;
        String inputName = request.getParameter("login");
        String inputPass = request.getParameter("password");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            if (scanner.hasNextLine()) {
                String password = scanner.nextLine();
                if (name.equals(inputName) && password.equals(inputPass)) {
                    loginIsTrue = true;
                    Cookie cookie1 = new Cookie("login", name);
                    cookie1.setMaxAge(-1);
                    Cookie cookie2 = new Cookie("password", password);
                    cookie2.setMaxAge(-1);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
            }
        }

        if (loginIsTrue){
            response.sendRedirect("BookStore.jsp");
        }
        else {
            response.sendRedirect("WrongUserLogin.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
