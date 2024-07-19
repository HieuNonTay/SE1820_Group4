/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import dao.AccountDAO;
import entity.Account;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS
 */
public class SendEmailController extends HttpServlet {

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
            out.println("<title>Servlet SendEmailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendEmailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        req.setAttribute("email", email);
        AccountDAO accDao = new AccountDAO();
        Account acc = accDao.getUser(email);
        if (acc == null) {
            // User not found
            req.setAttribute("mess", "Your account is not correct!");
            req.getRequestDispatcher("forGotPassword.jsp").forward(req, resp);
        } else {
            // Configuration for Jakarta Mail
            String host = "smtp.gmail.com";
            String port = "587";
            String username = "quyennvhe172461@fpt.edu.vn";
            System.out.println("khong");
            String password = "tmxrtmjxraoeegjo"; // Consider more secure methods for storing passwords
            String fromAddress = "quyennvhe172461@fpt.edu.vn";
            String toAddress = email;
            String subject = "Reset your password";

            // Generate reset token
            String token = UUID.randomUUID().toString();
            LocalDateTime expireTime = LocalDateTime.now().plusHours(1); // Expires in 1 hour
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String expireTimeString = expireTime.format(formatter);

            // Save token and email to cookies
            Cookie tokenCookie = new Cookie("resetToken", token);
            tokenCookie.setMaxAge(3600); // Set cookie lifetime to 1 hour
            resp.addCookie(tokenCookie);

            Cookie emailCookie = new Cookie("resetEmail", email);
            emailCookie.setMaxAge(3600); // Set cookie lifetime to 1 hour
            resp.addCookie(emailCookie);

            // Create the reset link with the token as a parameter
            String resetLink = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/sendEmail?token=" + token;

            // Message content
            String messageContent = "Hello,\n\n"
                    + "You have requested to reset your password. Please click the link below to reset your password:\n\n"
                    + "Reset Password: " + resetLink + "\n\n"
                    + "If you did not request this, please ignore this email. This link will expire within 1 hour.\n\n"
                    + "Special thanks,\n"
                    + "Shoes Store - GR4";

            // Mail server properties
            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // Session for authentication
            Session sessionMail = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Create MimeMessage
                MimeMessage message = new MimeMessage(sessionMail);
                message.setFrom(new InternetAddress(fromAddress));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
                message.setSubject(subject);
                message.setText(messageContent);

                // Send email
                Transport.send(message);

                // Redirect user after successful sending
                resp.sendRedirect("home");
            } catch (MessagingException e) {
                // Handle messaging exceptions (e.g., email sending failed)
                e.printStackTrace(); // Log the exception for debugging
                req.setAttribute("error", "Failed to send email. Please try again later.");
                req.getRequestDispatcher("404.jsp").forward(req, resp); // Forward to error page
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        String resetEmail = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("resetEmail")) {
                    resetEmail = cookie.getValue();
                }
            }
        }

        if (token == null || resetEmail == null) {
            req.setAttribute("mess", "Link has expired or is invalid. Please request a new one.");
            req.getRequestDispatcher("forGotPassword.jsp").forward(req, resp);
            return;
        }

        // Check token expiration time from cookie
        Cookie tokenCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("resetToken") && cookie.getValue().equals(token)) {
                tokenCookie = cookie;
                break;
            }
        }

        if (tokenCookie == null) {
            req.setAttribute("mess", "Link has expired or is invalid. Please request a new one.");
            req.getRequestDispatcher("forGotPassword.jsp").forward(req, resp);
            return;
        }

        // If token is valid, forward to resetPassword.jsp
        req.setAttribute("resetEmail", resetEmail);
        req.getRequestDispatcher("resetPassword.jsp").forward(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
