package com.example.ex22.ShoppingCart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookStore {
    private Map<Integer, Book> books;
    private Map<String, user> users;
    private int ID;

    public BookStore() throws IOException {
        ID = 0;
        getData();
    }

    public void addBook(String name, String author, int price, int id) {
        Book book = new Book(name, author, price, id);
        books.put(book.getId(), book);
        ID++;
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public Map<Integer, Book> getAllBooks() {
        return books;
    }


    public void setData() throws IOException {
        FileWriter fileWriter = new FileWriter("books.txt");
        for (Book book : books.values()) {
            fileWriter.write(book.getName() + "\n");
            fileWriter.write(book.getAuthor() + "\n");
            fileWriter.write(book.getPrice() + "\n");
            fileWriter.write(book.getId() + "\n");
        }
        fileWriter.write("/");
        fileWriter.close();
    }

    public void getData() throws IOException {

        FileReader fileReader = new FileReader("books.txt");
        char[] buffer = new char[2056];
        fileReader.read(buffer);

        int idx = 0;
        books = new HashMap<>();
        while (buffer[idx] != '/') {
            StringBuilder name = new StringBuilder();
            StringBuilder author = new StringBuilder();
            StringBuilder price = new StringBuilder();
            StringBuilder id = new StringBuilder();
            while (buffer[idx] != '\n') {
                name.append(buffer[idx]);
                idx++;
            }
            idx++;
            while (buffer[idx] != '\n') {
                author.append(buffer[idx]);
                idx++;
            }
            idx++;
            while (buffer[idx] != '\n') {
                price.append(buffer[idx]);
                idx++;
            }
            idx++;
            while (buffer[idx] != '\n') {
                id.append(buffer[idx]);
                idx++;
            }
            idx++;
            Book book = new Book(name.toString(), author.toString(), Integer.parseInt(price.toString()), Integer.parseInt(id.toString()));
            books.put(book.getId(), book);
            ID = book.getId();
        }

    }

    public String getBooksForPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table>");
        for (int i = 0; i < 4; i++) {
            stringBuilder.append("<tr>");
            for (int j = 0; j < 4; j++) {
                if (books.containsKey(i * 4 + j)) {
                    stringBuilder.append("<td>");
                    stringBuilder.append("<img src=\"book.png\" width=\"250\" height=\"250\">");
                    stringBuilder.append("<h4>" + books.get(i * 4 + j).getName() + "<h4>");
                    stringBuilder.append("<h4>Price:" + books.get(i * 4 + j).getPrice() + "</h4>");
                    stringBuilder.append("<form action=\"BookServlet\" method=\"get\">\n");
                    stringBuilder.append("<input type=\"hidden\" name=\"id\" value=\"" + (i * 4 + j) + "\">");
                    stringBuilder.append("<input type=\"submit\" value=\"more info\" >");
                    stringBuilder.append("</form>");

                    /*stringBuilder.append("<a href=\"addUser.jsp\">" +
                            "<button>Add user or number</button>\n" +
                            "</a>");*/
                    stringBuilder.append("</td>");
                } else {
                    stringBuilder.append("<td>");
                    stringBuilder.append("<h4>" + "<h4>");
                    stringBuilder.append("</td>");
                }
            }
            stringBuilder.append("<tr>");
        }

        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }

}
