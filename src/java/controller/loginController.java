/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author quyen
 */
public class loginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        String username = req.getParameter("user");
        String password = req.getParameter("password");
        req.setAttribute("user", username);
        if (username == null) {
            req.setAttribute("mess", "Username or password cannot be null.");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
            return;
        }
        AccountDAO accountDAO = new AccountDAO();
        Account acc = accountDAO.loginUser(username, password);
        if (acc == null) {
            req.setAttribute("mess", "Your account is wrong! Please try again!");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("acc", acc);
            session.setAttribute("roleID", acc.getRoleID());
            session.setMaxInactiveInterval(24 * 60 * 60);
            resp.sendRedirect("home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signIn.jsp").forward(req, resp);
    }
}
