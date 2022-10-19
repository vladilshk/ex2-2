package com.example.ex22.ShoppingCart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        BookStore bookStore = new BookStore();
        Book book = bookStore.getBook(bookId);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align=\"center\">Book</h1>");
        out.println("<img src=\"book.png\" width=\"250\" height=\"250\">");
        out.println("<h4>" + book.getName() + "<h4>");
        out.println("<h4>" + book.getAuthor() + "<h4>");
        out.println("<h4>" + book.getPrice() + " rub" + "<h4>");



        out.println("<form action=\"SetCookies\" method=\"get\">");
        out.println("<input type=\"hidden\" name=\"id\" value=\"" + book.getId() + "\">");
        out.println("<input type=\"submit\" value=\"Add book to a cart\" >");
        out.println("</form>");

        out.println("<a href=\"BookStore.jsp\">Back</a>");

        out.println("</body>");
        out.println("<html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
