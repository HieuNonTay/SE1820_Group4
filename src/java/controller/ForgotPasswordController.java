/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
//forgotpass
public class ForgotPasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgotPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPasswordController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("forGotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        processRequest(request, response);
        String username = req.getParameter("user");
        String newPass = req.getParameter("newPass");
        String Re_newPass = req.getParameter("re_newPass");
        req.setAttribute("user", username);
        AccountDAO accountDAO = new AccountDAO();
        Account acc = new Account();
        if ((newPass.length() < 6) || !isIncludedDigits(newPass) || !isIncludedLetters(newPass) || !isIncludedSpecialChars(newPass)) {
            req.setAttribute("mess", "Password must contain at least 6 included digit, characters and special characters");
            req.getRequestDispatcher("resetPassword.jsp").forward(req, resp);
        } else {
            if (newPass.equals(Re_newPass)) {
                accountDAO.changePassword(username, newPass);
                req.setAttribute("mess", "Change password successfully!");
                req.getRequestDispatcher("signIn.jsp").forward(req, resp);
            } else {
                req.setAttribute("mess", "Check your new password again!");
                req.getRequestDispatcher("resetPassword.jsp").forward(req, resp);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static boolean isIncludedDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIncludedLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIncludedSpecialChars(String s) {
        String SpeChar = "~`!@#$%^&*()-_+={][}|:;,<>.?/";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (SpeChar.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }

}
