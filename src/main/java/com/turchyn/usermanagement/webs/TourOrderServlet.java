package com.turchyn.usermanagement.webs;

import com.turchyn.usermanagement.model.Order;
import com.turchyn.usermanagement.model.TourBase;
import com.turchyn.usermanagement.model.TourOrder;
import com.turchyn.usermanagement.service.TourOrderService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/order/new", "/order/list", "/order/insert", "/order/delete", "/order/edit", "/order/update"})

public class TourOrderServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(TourOrderServlet.class.getName());
    private static final long serialVersionUID = 1L;
    private TourOrderService tourOrderService = new TourOrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/order/new":
                    showNewForm(request, response);
                    break;
                case "/order/insert":
                    insertOrder(request, response);
                    break;
                case "/order/delete":
                    deleteOrder(request, response);
                    break;
                case "/order/edit":
                    showEditForm(request, response);
                    break;
                case "/order/update":
                    updateOrder(request, response);
                    break;
                default:
                    listOrder(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOrder(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<Order> listOrders = tourOrderService.getAllData();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Order.jsp");
        logger.info("show list of orders - ok");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TourOrderForm.jsp");
        logger.info("show new form - ok");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourOrder existingOrder = tourOrderService.getDataById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TourOrderForm.jsp");
        request.setAttribute("order", existingOrder);
        logger.info("show edit form for order - ok");
        dispatcher.forward(request, response);
    }
    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String dateOrder = request.getParameter("date_order");
        int clientCode = Integer.parseInt(request.getParameter("client_code"));
        int tourCode = Integer.parseInt(request.getParameter("tour_code"));
        TourOrder tourOrder = new TourOrder(dateOrder,clientCode,tourCode);
        tourOrderService.addData(tourOrder);
        logger.info("insert order - ok");
        response.sendRedirect("list");
    }
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TourOrder tourOrder = new TourOrder(id);
        tourOrderService.deleteData(tourOrder);
        logger.info("delete order - ok");
        response.sendRedirect("list");
    }
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dateOrder = request.getParameter("date_order");
        int clientCode = Integer.parseInt(request.getParameter("client_code"));
        int tourCode = Integer.parseInt(request.getParameter("tour_code"));
        TourOrder tourOrder = new TourOrder(id,dateOrder,clientCode,tourCode);
        tourOrderService.updateData(tourOrder);
        logger.info("update order - ok");
        response.sendRedirect("list");
    }
}
