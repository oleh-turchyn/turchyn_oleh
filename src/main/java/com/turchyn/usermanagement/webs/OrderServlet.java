package com.turchyn.usermanagement.webs;

import com.turchyn.usermanagement.dao.OrderDAO;
import com.turchyn.usermanagement.model.Order;
import com.turchyn.usermanagement.service.OrderService;
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

@WebServlet (urlPatterns = {"/order/new", "/order/list", "/order/insert", "/order/delete", "/order/edit", "/order/update"})
public class OrderServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(OrderServlet.class.getName());
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO = new OrderDAO();
    private OrderService orderService = new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
//                case "/client/new":
//                    showNewForm(request, response);
//                    break;
//                case "/client/insert":
//                    insertClient(request, response);
//                    break;
//                case "/client/delete":
//                    deleteClient(request, response);
//                    break;
//                case "/client/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/client/update":
//                    updateClient(request, response);
//                    break;
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
        List<Order> listOrders = orderService.getAllData();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Order.jsp");
        logger.info("show list of orders - ok");
        dispatcher.forward(request, response);
    }
}
