/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Account;
import entity.News;
import entity.NewsGroup;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import dao.*;

/**
 *
 * @author Dell
 */
public class newsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String grouped = req.getParameter("groupBy");
        String page = req.getParameter("page");
        String search = req.getParameter("search");
        if (search == null || search.isEmpty()) {
            search = "";
        }
        if (page == null || page.equals("0")) {
            page = "1";
        }
        NewsDAO n = new NewsDAO();
        NewsGroupDAO ng = new NewsGroupDAO();

        if (grouped.equals("0")) {
            grouped = "-1";
        }

        req.setAttribute("count", calThePage(5, Integer.parseInt(grouped), search));
        req.setAttribute("groupBy", Integer.parseInt(grouped));
        req.setAttribute("search", search);
        req.setAttribute("page", page);
        req.setAttribute("groups", ng.getListNewsGroup());
        req.setAttribute("news", n.getListByPagesAndGroupAndSortAndSearch(Integer.parseInt(page), grouped, "-1", search));
        req.getRequestDispatcher("news.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account userAccount = (Account) session.getAttribute("acc");
        if (userAccount == null || (userAccount.getRoleID() != 1 && userAccount.getRoleID() != 3)) {
            req.getRequestDispatcher("403.jsp").forward(req, resp);
            return;
        }

        NewsDAO newsDao = new NewsDAO();
        NewsGroupDAO newsGroupDao = new NewsGroupDAO();
        List<NewsGroup> listNewsGroups = newsGroupDao.getListNewsGroup();

        req.setAttribute("page", "1");
        req.setAttribute("count", calThePage(5, -1, ""));
        req.setAttribute("groups", listNewsGroups);
        req.setAttribute("news", newsDao.getListByPagesAndGroupAndSortAndSearch(1, "-1", "-1", null));
        req.setAttribute("groupBy", "0");
        req.setAttribute("search", "");
        req.getRequestDispatcher("news.jsp").forward(req, resp);
    }

    public int calThePage(int sizePage, int gid, String search) {
        NewsDAO n = new NewsDAO();
        int pages = 0;
        int countNews = n.getListNewsAndSearch(search).size();
        if (gid != -1) {
            countNews = n.getNewsByGidAndSearch(gid, search).size();
        }
        if (countNews % sizePage == 0) {
            pages = countNews / sizePage;
        } else {
            pages = countNews / sizePage + 1;
        }
        return pages;
    }
}
