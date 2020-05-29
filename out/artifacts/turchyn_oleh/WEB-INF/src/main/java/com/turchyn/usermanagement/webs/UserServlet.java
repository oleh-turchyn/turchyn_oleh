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

@WebServlet("/test")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TourDAO tourDAO;

    public void init() {
//        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
//        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
////        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
//        String jdbcPassword = "";
        String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours2";
        String jdbcUsername = "sa";
        String jdbcPassword = "pass";
        tourDAO = new TourDAO(jdbcURL,jdbcUsername,jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String items[] = {"4","ti","stryj","car","lunch","5","200"};
//        request.setAttribute("items",items);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
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
        List<TourBase> listTours = tourDAO.listAllTours();
            request.setAttribute("listTours", listTours);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tour-form.jsp");
        dispatcher.forward(request, response);
    }
}
