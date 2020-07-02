package com.turchyn.usermanagement.webs;

import org.apache.log4j.Logger;
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
import java.util.List;

@WebServlet(urlPatterns = {"/tour/new", "/tour/list", "/tour/insert", "/tour/delete", "/tour/edit", "/tour/update"})
public class TourServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(TourServlet.class.getName());
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
                case "/tour/new":
                    showNewForm(request, response);
                    break;
                case "/tour/insert":
                    insertTour(request, response);
                    break;
                case "/tour/delete":
                    deleteTour(request, response);
                    break;
                case "/tour/edit":
                    showEditForm(request, response);
                    break;
                case "/tour/update":
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Tour.jsp");
        logger.info("show list of tours - ok");
        rd.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TourForm.jsp");
        logger.info("show new form - ok");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourBase existingTour = tourService.getDataById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TourForm.jsp");
        request.setAttribute("tour", existingTour);
        logger.info("show edit form - ok");
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
        logger.info("insert tour - ok");
        response.sendRedirect("list");
    }

    private void deleteTour(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourBase tour = new TourBase(id);
        tourService.deleteData(tour);
        logger.info("delete tour - ok");
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
        logger.info("update tour - ok");
        response.sendRedirect("list");
    }
}
