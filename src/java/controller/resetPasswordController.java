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
import java.io.IOException;

/**
 *
 * @author quyen
 */
public class resetPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                    req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
                }
            }
    }
              
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

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
