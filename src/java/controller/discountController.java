/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Account;
import entity.Discount;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.*;

/**
 *
 * @author Dell
 */
public class discountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        String page = req.getParameter("page");

        DisCountDAO d = new DisCountDAO();
        if (search == null) {
            search = "";
        }
        if (page == null || page.equals("0")) {
            page = "1";
        }
        if (Integer.parseInt(page) > calThePage(5, search)) {
            page = calThePage(5, search) + "";
        }

//        req.setAttribute("groupBy", Integer.parseInt(req.getParameter("groupBy")));
        req.setAttribute("search", req.getParameter("search"));
        req.setAttribute("count", calThePage(5, search));
        req.setAttribute("page", page);
        req.setAttribute("discounts", d.getListDiscountByTypeAndSearchAndPage(Integer.parseInt(page), null, search));
//        req.setAttribute("types", n.getListContentsByName("discountFilter"));

        req.getRequestDispatcher("/admin/discount.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("acc") == null) {
            req.getRequestDispatcher("403.jsp").forward(req, resp);
        }
        Account ch = (Account) session.getAttribute("acc");
        if (!(ch.getRoleID() == 1 || ch.getRoleID() == 3)) {
            req.getRequestDispatcher("403.jsp").forward(req, resp);
        }
        DisCountDAO d = new DisCountDAO();
        NewsDAO n = new NewsDAO();

//        req.setAttribute("types", n.getListContentsByName("discountFilter"));
        req.setAttribute("groupBy", "0");
        req.setAttribute("search", null);
        req.setAttribute("count", calThePage(5, ""));
        req.setAttribute("page", "1");
        //req.setAttribute("discounts", d.getListDiscount());
        req.setAttribute("discounts", d.getListDiscountByTypeAndSearchAndPage(1, null, null));

        req.getRequestDispatcher("/admin/discount.jsp").forward(req, resp);
    }

    public int calThePage(int sizePage, String search) {
        DisCountDAO d = new DisCountDAO();
        NewsDAO n = new NewsDAO();

        int pages = 0;
        int countDiscounts = 0;

        countDiscounts = d.getListDiscountBySearch(search).size();

        if (countDiscounts % sizePage == 0) {
            pages = countDiscounts / sizePage;
        } else {
            pages = countDiscounts / sizePage + 1;
        }
        return pages;
    }
}
