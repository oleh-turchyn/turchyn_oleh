package com.turchyn.usermanagement.webs;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/")
public class MainServlet extends HttpServlet {
    //private static Logger logger = Logger.getLogger(MainServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/tour":
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("Tour.jsp");
                dispatcher1.forward(request, response);
                break;
            case "/client":
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("Client.jsp");
                dispatcher2.forward(request, response);
                break;
            }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}