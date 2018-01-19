package controller;

import DAO.ListLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListLogic ll = new ListLogic();
        ll.getUsers();
        String button = request.getParameter("button");
        if ("getRichest".equals(button)) {
            request.setAttribute("richest", ll.getRichestUser());
        } else if ("getSum".equals(button)) {
            request.setAttribute("sum", ll.getSum());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
