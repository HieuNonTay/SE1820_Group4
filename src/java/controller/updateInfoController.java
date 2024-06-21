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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author quyen
 */
public class updateInfoController extends HttpServlet {

    // Biểu thức chính quy để kiểm tra email phải kết thúc bằng "@gmail.com"
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+@gmail\\.com$";

    private static final Pattern checkEmail = Pattern.compile(EMAIL_PATTERN);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logout = req.getParameter("logout");
        if (logout != null) {
            resp.sendRedirect("logout");
        } else {
            HttpSession session = req.getSession();
            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String dob = req.getParameter("dob");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            AccountDAO accountDAO = new AccountDAO();
            Account a = accountDAO.checkPhoneExist(email, phone);
            if (a == null) {
                if (!checkDob(dob)) {
                    req.setAttribute("mess", "Please enter your birth day before today");
                    req.getRequestDispatcher("userDetail.jsp").forward(req, resp);
                } else {
                    accountDAO.Update(fname, lname, dob, phone, address, email);
                    session.removeAttribute("acc");
                    session.setAttribute("acc", accountDAO.getUser(email));
                    req.setAttribute("mess", "Update Successfully");
                    req.getRequestDispatcher("userDetail.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("mess", "The Phone has been use registered");
                req.getRequestDispatcher("userDetail.jsp").forward(req, resp);
            }
        }
    }

    public static boolean checkDob(String dobString) {
        boolean isBeforeToday = false;
        try {
            // Định dạng ngày mà bạn mong muốn
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Chuyển đổi chuỗi dob sang LocalDate
            LocalDate dob = LocalDate.parse(dobString, formatter);
            // Lấy ngày hiện tại
            LocalDate today = LocalDate.now();
            // Kiểm tra xem ngày sinh có trước ngày hôm nay không
            isBeforeToday = dob.isBefore(today);
        } catch (DateTimeParseException e) {
        }
        return isBeforeToday;
    }

}
