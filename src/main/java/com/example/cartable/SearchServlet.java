package com.example.cartable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type =  request.getParameter("type");
        String model =  request.getParameter("model");
        String manufacturer =  request.getParameter("manufacturer");
        String electric =  request.getParameter("electric");
        String horsePowerString = request.getParameter("horsepower");






        System.out.println(type);
        List<Car> cars  =  null;
        try {
            cars = DbService.getAllCars();
            System.out.println(cars);
              if(type != null && !type.isEmpty()) {
                  System.out.println("empty type");
                  cars.removeIf(c -> !c.getType().equals(type));
              }
            if(model != null && !model.isEmpty()) {
                System.out.println("empty model");
                cars.removeIf(c -> !c.getModel().equals(model));
            }
            if(manufacturer != null && !manufacturer.isEmpty()) {
                System.out.println("empty manufacturer");
                cars.removeIf(c -> !c.getManufacturer().equals(manufacturer));
            }
            if(electric != null && !electric.isEmpty()) {
                System.out.println("empty electric");
                cars.removeIf(c -> !String.valueOf(c.isElectric()).equals(electric));
            }
            if(horsePowerString != null && !horsePowerString.isEmpty()) {
                System.out.println("empty horsepower");
                cars.removeIf(c -> c.getHorsePower() != Double.parseDouble(horsePowerString));
            }




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("carResultSet",cars);
        RequestDispatcher dispatch = request.getRequestDispatcher("render-view");
        dispatch.forward(request,response);


    }
}
