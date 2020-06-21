package com.turchyn.usermanagement.webs;

import com.turchyn.usermanagement.dao.ClientDAO;
import com.turchyn.usermanagement.model.Client;
import com.turchyn.usermanagement.service.ClientService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO;
    private ClientService clientService = new ClientService();

    public void init() {
        clientDAO = new ClientDAO();
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
                case "/insert":
                    insertClient(request, response);
                    break;
                case "/delete":
                    deleteClient(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateClient(request, response);
                    break;
                default:
                    listClient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void listClient(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<Client> listTours = clientService.getAllData();
        request.setAttribute("listClients", listTours);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Tour.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientService.getDataById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName =  request.getParameter("last_name");
        String patronName =  request.getParameter("patron_name");
        String passport =  request.getParameter("passport");
        String telNum =  request.getParameter("tel_num");
        Client client = new Client(firstName, lastName, patronName, passport,telNum);
        clientService.addData(client);
        response.sendRedirect("list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client client = new Client(id);
        clientService.deleteData(client);
        response.sendRedirect("list");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("first_name");
        String lastName =  request.getParameter("last_name");
        String patronName =  request.getParameter("patron_name");
        String passport =  request.getParameter("passport");
        String telNum =  request.getParameter("tel_num");
        Client client = new Client(firstName, lastName, patronName, passport,telNum);
        clientService.updateData(client);
        response.sendRedirect("list");
    }

}
