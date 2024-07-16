/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Discount;
import entity.Product;
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

/**
 *
 * @author Dell
 */
public class discountUpdateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("updateDiscountCode");
        if (code != null) {
            DisCountDAO d = new DisCountDAO();
            Discount updateDiscount = d.getDisCountByCode(code);

            if (d.getProductDiscountByCode(code) != null) {
                Discount updateProductDiscount = d.getProductDiscountByCode(code);
                req.setAttribute("updateFromDate", convertDateTimeFormat(updateProductDiscount.getFromDate()));
                req.setAttribute("updateToDate", convertDateTimeFormat(updateProductDiscount.getToDate()));
                req.setAttribute("updateProductDiscount", updateProductDiscount);

//                String models = "";
//                List<Integer> ids = d.getListProductIdByDiscountCode(code);
//                for (Integer id : ids) {
//                    String tmpMod = d.getProductModelByProductId(id);
//                    models += " " + tmpMod;
//                }
//                req.setAttribute("updateModels", models);
            }
            Product p = d.getProductByProductDiscountCode(code);
            req.setAttribute("updateModels", p.getName());
            req.setAttribute("updateDiscount", updateDiscount);
        }
        ProductDAO p = new ProductDAO();
        List<Product> ps = p.getAll();
        HttpSession s = req.getSession();
        s.setAttribute("products", ps);
        req.getRequestDispatcher("discountDetailManagement.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String code = req.getParameter("discountCode");
        DisCountDAO d = new DisCountDAO();
        Discount selectDiscount = d.getDisCountByCode(code);

        d.deleteProductDiscount(code);
        d.deleteDiscount(code);
        s.setAttribute("functionToast", "showToast('success','Delete discount successfully!')");
        resp.sendRedirect("discount");

    }

    private static String convertDateTimeFormat(String inputDateTime) {
        if (inputDateTime == null) {
            return null;
        } else {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
