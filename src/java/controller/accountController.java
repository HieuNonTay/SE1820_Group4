package controller;

import dao.AccountDAO;
import entity.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class accountController extends HttpServlet {

    AccountDAO accountDAO = new AccountDAO();

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:QUYEN/ShoesStore", "sa", "123456");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database connection problem.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Account> listAccount = accountDAO.getAllAccounts();
        request.setAttribute("listAccount", listAccount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AccountManage.jsp");
        dispatcher.forward(request, response);
    }
}
