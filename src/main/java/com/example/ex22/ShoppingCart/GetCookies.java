package com.example.ex22.ShoppingCart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookies", value = "/GetCookies")
public class GetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String ids = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("bookId")) {
                ids = cookie.getValue();
            }
        }

        PrintWriter out = response.getWriter();
        out.println(ids);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
