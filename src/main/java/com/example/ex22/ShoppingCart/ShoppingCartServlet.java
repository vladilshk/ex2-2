package com.example.ex22.ShoppingCart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Set<Integer> booksIds = new HashSet<>();
        String ids = "";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("bookId")) {
                ids = cookie.getValue();
            }
        }

        PrintWriter out = response.getWriter();

        for (int i = 0; i < ids.length(); i++) {
            booksIds.add(Integer.parseInt(String.valueOf(ids.charAt(i))));
            i++;
        }

        BookStore bookStore = new BookStore();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align=\"center\">Cart<h1>");
        for (int id : booksIds){
            Book book = bookStore.getBook(id);
            out.println("<img src=\"book.png\" width=\"250\" height=\"250\">");
            out.println("<h4>" + book.getName() + "<h4>");
            out.println("<h4>" + book.getPrice() + " rub" + "<h4>");
            out.println("<br>");
            out.println("<br>");
        }


        out.println("</body>");
        out.println("<html>");




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
