package com.example.cartable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RenderViewServlet", value = "/render-view")
public class RenderViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> carList = (List<Car>) request.getAttribute("carResultSet");
        System.out.println(carList.isEmpty());
        PrintWriter writer = response.getWriter();

        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("<link href=\"main.css\" rel=\"stylesheet\">\n");
        writer.write("</head>\n");
        writer.write("<body bgcolor=\"white\">\n");


        String link = "http://"+ request.getServerName() + ":" + request.getServerPort() +request.getContextPath()+"/";
        System.out.println(link);
        System.out.println("render view");
        writer.write("<a href=\" " + link +"\"  type=\"button\">Back home</a>");
        writer.write("<table style=\"  font-family: \"Droid Sans\"  \"  cellspacing=\"20\">\n" +
                " <thead>" +
                "  <tr>\n" +
                "    <th>Type</th>\n" +
                "    <th>Model</th>\n" +
                "    <th>Manufacturer</th>\n" +
                "    <th>Horsepower</th>\n" +
                "    <th>Phone number</th>\n" +
                "    <th>Email</th>\n" +
                "    <th>Price</th>\n" +
                "  </tr>\n"+
                " </thead>"
        );
        for(Car car : carList){
           writer.write("<tr>\n" +
                   car.renderTableEntry() +
                   "</tr>");
        }




        writer.write("</table>\n");




        writer.write("</body>");
        writer.write("</html>");



        writer.close();
    }
}
