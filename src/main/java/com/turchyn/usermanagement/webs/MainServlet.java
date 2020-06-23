package com.turchyn.usermanagement.webs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String path = "/tour";
////        ServletContext servletContext = getServletContext();
////        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
////        requestDispatcher.forward(request,response);
        String action = request.getServletPath();
        if(action.equals("/tour")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Tour.jsp");
            dispatcher.forward(request, response);
//            request.getRequestDispatcher("Tour.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}