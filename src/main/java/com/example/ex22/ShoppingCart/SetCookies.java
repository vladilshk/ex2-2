package com.example.ex22.ShoppingCart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "SetCookies", value = "/SetCookies")
public class SetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cookie[] cookies = request.getCookies();
        String ids = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("bookId")) {
                ids = cookie.getValue();
            }
        }

        ids += id + "/";

        Cookie cookie1 = new Cookie("bookId", ids);


        cookie1.setMaxAge(3 * 60);
        response.addCookie(cookie1);
        response.sendRedirect(request.getHeader("referer"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
