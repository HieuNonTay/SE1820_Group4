package controller;

import dao.accountDAO;
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
public class changePassController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();    
        String username = req.getParameter("user");
        String password = req.getParameter("password");
        String newPass = req.getParameter("newPass");
        String Re_newPass = req.getParameter("re_newPass");
        req.setAttribute("user", username);
        accountDAO accountDAO = new accountDAO();
        Account a = (Account) session.getAttribute("acc");
        Account acc = accountDAO.loginUser(username, password);
        if (acc == null) {
            req.setAttribute("mess", "Email or password is wrong. Please enter again!");
            req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
        } else {
            if ((newPass.length() < 6) || !isIncludedDigits(newPass) || !isIncludedLetters(newPass) || !isIncludedSpecialChars(newPass)) {
                req.setAttribute("mess", "Password must contain at least 6 included digit, characters and special characters");
                req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
            } else {
                if (newPass.equals(Re_newPass)) {                                     
                    accountDAO.changePassword(username, newPass);
                    req.setAttribute("mess", "Change password successfully!");
                    if (a == null) {
                        req.getRequestDispatcher("signIn.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("userDetail.jsp").forward(req, resp);
                    }
                    
                } else {
                    req.setAttribute("mess", "Check your new password again!");
                    req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
                }
            }
        }
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
