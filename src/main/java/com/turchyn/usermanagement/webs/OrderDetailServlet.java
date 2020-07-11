package com.turchyn.usermanagement.webs;


import com.turchyn.usermanagement.dao.OrderDetailDAO;
import com.turchyn.usermanagement.model.OrderDetail;
import com.turchyn.usermanagement.service.OrderDetailService;
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

@WebServlet (urlPatterns = {"/orderDetails/list"})
public class OrderDetailServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(OrderDetailServlet.class.getName());
    private static final long serialVersionUID = 1L;
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    private OrderDetailService orderDetailService = new OrderDetailService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listOrder(request, response);
        } catch (SQLException e) {
            logger.error("Some problems with OrderDetail servlet");
            logger.error(e.getMessage());
        }
    }

    private void listOrder(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<OrderDetail> listOrders = orderDetailService.getAllData();
        request.setAttribute("listOrders", listOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Order.jsp");
        logger.info("show list of orders - ok");
        dispatcher.forward(request, response);
    }

}
