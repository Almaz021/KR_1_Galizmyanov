package ru.itis.fisd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.fisd.service.OrderService;

import java.io.IOException;

@WebServlet("/index")
public class IndexPageServlet extends HttpServlet {

    private final OrderService service = new OrderService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            request.setAttribute("orders", service.findAll());

            request.getRequestDispatcher("/index.ftl").forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }
}