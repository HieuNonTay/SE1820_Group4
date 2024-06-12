/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.accountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import entity.Account;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author quyen
 */
public class registerController extends HttpServlet {

    // Biểu thức chính quy để kiểm tra email phải kết thúc bằng "@gmail.com"
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+@gmail\\.com$";

    private static final Pattern checkEmail = Pattern.compile(EMAIL_PATTERN);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String rePass = req.getParameter("repass");
        String dob = req.getParameter("dob");
        req.setAttribute("fname", fname);
        req.setAttribute("lname", lname);
        req.setAttribute("phone", phone);
        req.setAttribute("address", address);
        req.setAttribute("email", email);
        req.setAttribute("pass", pass);
        req.setAttribute("repass", rePass);
        req.setAttribute("dob", dob);
        if (isValid(email) == true) {
            if ((pass.length() < 6) || !isIncludedDigits(pass) || !isIncludedLetters(pass) || !isIncludedSpecialChars(pass)) {
                req.setAttribute("mess", "Password must contain at least 6 included digit, characters and special characters");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } else {
                if (pass.equals(rePass)) {
                    accountDAO accountDAO = new accountDAO();
                    Account a = accountDAO.checkAccountExist(email, phone);
                    if (a == null) {
                        accountDAO.signUp(fname, lname, dob, phone, address, email, pass);
                        req.setAttribute("mess", "Sign Up Successfully");
                        req.getRequestDispatcher("signIn.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("mess", "The email or Phone has been use registered");
                        req.getRequestDispatcher("register.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("mess", "The password is wrong. Please accept the return!");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("mess", "Please enter google email fomat");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
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

    public static boolean isValid(String email) {
        Matcher matcher = checkEmail.matcher(email);
        return matcher.matches();
    }

}
