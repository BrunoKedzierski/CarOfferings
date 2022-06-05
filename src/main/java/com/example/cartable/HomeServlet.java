package com.example.cartable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<String> models = DbService.getAllValues("model");
       List<String> types = DbService.getAllValues("type");
       List<String> manufacturers = DbService.getAllValues("manufacturer");

       request.setAttribute("models",models);
       request.setAttribute("types",types);
       request.setAttribute("manufacturers",manufacturers);
       request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
