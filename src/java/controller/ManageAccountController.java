/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import entity.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class ManageAccountController extends HttpServlet {

    // Biểu thức chính quy để kiểm tra email phải kết thúc bằng "@gmail.com"
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+@gmail\\.com$";

    private static final Pattern checkEmail = Pattern.compile(EMAIL_PATTERN);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageCustomerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageCustomerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO accDao = new AccountDAO();
        List<Account> listA = accDao.getAllAccount();
        List<Role> listRole = accDao.getRoleAccount();

        request.setAttribute("listAcc", listA);
        request.setAttribute("listR", listRole);
        request.getRequestDispatcher("admin/account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO accDao = new AccountDAO();
        String action = request.getParameter("action");
        switch (action) {
            case "update":
                HttpSession session = request.getSession();
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String status = request.getParameter("status");
                String role = request.getParameter("role");
                int roleID = Integer.parseInt(role);
                Account a = accDao.checkPhoneExist(email, phone);
                if (a == null) {
                    if (!checkDob(dob)) {
                        request.setAttribute("mess", "Please enter your birth day before today");
                        request.getRequestDispatcher("admin/account.jsp").forward(request, response);
                    } else {
                        accDao.UpdateAll(fname, lname, dob, phone, address, email, status, roleID);
                        request.setAttribute("mess", "Update Successfully");
                        response.sendRedirect("accountmanager");
                    }
                } else {
                    request.setAttribute("mess", "The Phone has been use registered");
                    request.getRequestDispatcher("admin/account.jsp").forward(request, response);
                }
                break;
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
