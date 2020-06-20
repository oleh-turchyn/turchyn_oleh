package com.turchyn.usermanagement.webs;

import com.turchyn.usermanagement.dao.TourDAO;
import com.turchyn.usermanagement.model.TourBase;
import com.turchyn.usermanagement.service.TourService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("http://localhost:8080/test/list")
public class TourServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TourDAO tourDAO;
    private TourService tourService = new TourService();

    public void init() {
        tourDAO = new TourDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
//                case "/list":
//                    listTour(request, response);
//                    break;
                case "/insert":
                    insertTour(request, response);
                    break;
                case "/delete":
                    deleteTour(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTour(request, response);
                    break;
                default:
                    listTour(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTour(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<TourBase> listTours = tourService.getAllData();
        request.setAttribute("listTours", listTours);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("TourForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourBase existingTour = tourService.getDataById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TourForm.jsp");
        request.setAttribute("tour", existingTour);
        dispatcher.forward(request, response);
    }

    private void insertTour(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String location = request.getParameter("location");
        String transport = request.getParameter("transport");
        String nutrition = request.getParameter("nutrition");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int price = Integer.parseInt(request.getParameter("price"));
        TourBase tour = new TourBase(title, location, transport, nutrition, duration, price);
        tourService.addData(tour);
        response.sendRedirect("list");
    }

    private void deleteTour(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourBase tour = new TourBase(id);
        tourService.deleteData(tour);
        response.sendRedirect("list");
    }

    private void updateTour(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String location = request.getParameter("location");
        String transport = request.getParameter("transport");
        String nutrition = request.getParameter("nutrition");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int price = Integer.parseInt(request.getParameter("price"));
        TourBase tour = new TourBase(id, title, location, transport, nutrition, duration, price);
        tourService.updateData(tour);
        response.sendRedirect("list");
    }
}
