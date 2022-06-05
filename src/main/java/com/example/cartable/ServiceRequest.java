package com.example.cartable;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "serviceRequestServlet", value = "/service-request")
public class ServiceRequest extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service for type");
        String type = (String) req.getAttribute("type");
        System.out.println(type);
        RequestDispatcher dispatch = req.getRequestDispatcher("search-servlet");
        dispatch.forward(req,resp);



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}