/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Discount;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import dao.*;
import entity.Product;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Dell
 */
public class discountDetailController extends HttpServlet {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6; // Length of the discount code

    public static String generateRandomCode() {
        Random random = new SecureRandom();
        StringBuilder code = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }

        return code.toString();
    }

    public static String generateUniqueCode(List<Discount> existingDiscounts) {
        Set<String> existingCodes = new HashSet<>();
        for (Discount di : existingDiscounts) {
            existingCodes.add(di.getCode());
        }

        String code;
        do {
            code = generateRandomCode();
        } while (existingCodes.contains(code));

        return code;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit").equalsIgnoreCase("add")) {
            HttpSession s = req.getSession();
//            String code = req.getParameter("code");
            String code = "";

            String name = req.getParameter("name");
            Double amount = Double.parseDouble(req.getParameter("amount"));
            String description = req.getParameter("description");
            String type = req.getParameter("type");

            DisCountDAO d = new DisCountDAO();
            List<Discount> dis = d.getListDiscount();

            boolean checkCode = true;
            boolean checkAmount = true;
            String error = "";

            if (amount > 100 || amount < 0) {
                checkAmount = false;
                error += "showToast('error','The amount is out of range!');";
            }

            if (checkCode && checkAmount) {
                if (type.equalsIgnoreCase("Product")) {
                    String productModel = req.getParameter("proModel");
                    String fromDate = req.getParameter("fromDate");
                    String toDate = req.getParameter("toDate");

                    String[] models = req.getParameterValues("models[]");

                    String insideError = "";
                    boolean modelsNull = true;
                    if (models == null) {
                        modelsNull = false;
                        insideError += "showToast('info','Product should not be empty');";
                    }

                    boolean checkDate = true;
                    boolean checkExistModel = true;
                    LocalDate localDate1 = LocalDate.parse(fromDate);
                    LocalDate localDate2 = LocalDate.parse(toDate);
                    int result = localDate1.compareTo(localDate2);
                    if (result > 0) {
                        checkDate = false;
                        insideError += "showToast('error','To must be after from!');";
                    }

                    if (checkDate && modelsNull && checkExistModel) {

                        for (String item : models) {
                            code = generateUniqueCode(dis);
                            d.addDiscount(code, name, amount, description, type);

//                            int proId = d.getProductIdByModel(item);
                            d.addProductDiscount(Integer.parseInt(item), code, fromDate, toDate);
                        }
                        s.setAttribute("functionToast", "showToast('success','Add discount successfully!')");

                        //d.addProductDiscount(productId, code, fromDate, toDate);
                        resp.sendRedirect("discount");
                    } else {

                        req.setAttribute("code", code);
                        req.setAttribute("name", name);
                        req.setAttribute("amount", amount);
                        req.setAttribute("description", description);
                        req.setAttribute("proModel", productModel);
                        req.setAttribute("fromDate", fromDate);
                        req.setAttribute("toDate", toDate);
                        s.setAttribute("functionToast", insideError);

                        req.getRequestDispatcher("discountDetailManagement.jsp").forward(req, resp);
                    }
                }
            } else {
                req.setAttribute("code", code);
                req.setAttribute("name", name);
                req.setAttribute("amount", amount);
                req.setAttribute("description", description);
                s.setAttribute("functionToast", error);

                req.getRequestDispatcher("discountDetailManagement.jsp").forward(req, resp);
            }
        } else if (req.getParameter("submit").equalsIgnoreCase("update")) {

            String code = req.getParameter("code");
            String name = req.getParameter("name");
            Double amount = Double.parseDouble(req.getParameter("amount"));
            String description = req.getParameter("description");

            HttpSession s = req.getSession();
            DisCountDAO d = new DisCountDAO();
            Discount thisDiscount = d.getDisCountByCode(code);
            boolean checkAmount = true;
            if (amount > 100 || amount < 0) {
                checkAmount = false;
            }
            if (checkAmount) {
                if (d.getProductDiscountByCode(code) != null) {

                    Discount updateProductDiscount = d.getProductDiscountByCode(code);

                    Product p = d.getProductByProductDiscountCode(code);
                    req.setAttribute("updateModels", p.getName());

                    req.setAttribute("updateProductDiscount", updateProductDiscount);

                    req.setAttribute("updateFromDate", convertDateTimeFormat(updateProductDiscount.getFromDate()));
                    req.setAttribute("updateToDate", convertDateTimeFormat(updateProductDiscount.getToDate()));
                    req.setAttribute("updateDiscount", thisDiscount);
                    req.setAttribute("checkUpdate", true);

                }
                d.updateDiscount(name, amount, description, code);
                s.setAttribute("functionToast", "showToast('success','Update discount successfully!')");
                resp.sendRedirect("discount");
            } else {
                if (d.getProductDiscountByCode(code) != null) {
                    Discount updateProductDiscount = d.getProductDiscountByCode(code);
                    //req.setAttribute("updateProductModel", d.getProductModelByProductId(updateProductDiscount.getProductId()));
                    req.setAttribute("updateProductModel", req.getParameter("proModel"));
                    req.setAttribute("updateProductDiscount", updateProductDiscount);
                    req.setAttribute("updateFromDate", convertDateTimeFormat(updateProductDiscount.getFromDate()));
                    req.setAttribute("updateToDate", convertDateTimeFormat(updateProductDiscount.getToDate()));
                }
                req.setAttribute("updateDiscount", thisDiscount);
                s.setAttribute("functionToast", "showToast('error','The amount is out of range!')");
                req.getRequestDispatcher("discountDetailManagement.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect("discount");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private String convertDateTimeFormat(String inputDateTime) {
        if (inputDateTime == null) {
            return null;
        } else {
            DateFormat inputFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat.parse(inputDateTime);
                return outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
