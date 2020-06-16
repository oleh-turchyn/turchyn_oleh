package com.turchyn.usermanagement.webs;

import com.turchyn.usermanagement.dao.TourDAO;
import com.turchyn.usermanagement.model.TourBase;

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
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TourDAO tourDAO;

    public void init() {
//        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
//        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
////        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
//        String jdbcPassword = "";
//        String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours2";
//        String jdbcUsername = "sa";
//        String jdbcPassword = "pass";
//        tourDAO = new TourDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
        List<TourBase> listTours = tourDAO.read();
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
        TourBase existingTour = tourDAO.getById(id);
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
        tourDAO.create(tour);
        response.sendRedirect("list");
    }

    private void deleteTour(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourBase tour = new TourBase(id);
        tourDAO.delete(tour);
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
        tourDAO.update(tour);
        response.sendRedirect("list");
    }
}
