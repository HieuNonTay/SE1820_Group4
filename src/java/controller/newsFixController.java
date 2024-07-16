package controller;

import entity.Account;
import entity.News;
import entity.NewsGroup;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import dao.NewsDAO;
import dao.NewsGroupDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class newsFixController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String submitType = req.getParameter("submit");

        String author = req.getParameter("author");
        String cateId = req.getParameter("cateId");
        String title = req.getParameter("title");
        String heading = req.getParameter("heading");
        String content = req.getParameter("content");
        String image = req.getParameter("image");

        // Trim inputs to remove any leading or trailing spaces
        author = (author != null) ? author.trim() : "";
        title = (title != null) ? title.trim() : "";
        heading = (heading != null) ? heading.trim() : "";
        content = (content != null) ? content.trim() : "";
        cateId = (cateId != null) ? cateId.trim() : "";

        // Validate inputs
        boolean inputInvalid = false;
        if (author.isEmpty() || title.isEmpty() || heading.isEmpty() || content.isEmpty() || cateId.isEmpty()) {
            session.setAttribute("functionToast", "showToast('info','Some input(s) are blank!')");
            inputInvalid = true;
        }

        if (title.length() > 50) {
            session.setAttribute("functionToast", "showToast('error','Failure: Title too long')");
            inputInvalid = true;
        }

        String formattedImage = extractImageSrc(image);
        if (formattedImage == null || formattedImage.isEmpty()) {
            session.setAttribute("functionToast", "showToast('error','Invalid image link')");
            inputInvalid = true;
        }

        NewsGroupDAO newsGroupDAO = new NewsGroupDAO();
        NewsGroup category = newsGroupDAO.getNewsGroupById(Integer.parseInt(cateId));
        if (category == null) {
            session.setAttribute("functionToast", "showToast('error','Invalid category')");
            inputInvalid = true;
        }

        if (inputInvalid) {
            forwardToForm(req, resp, author, title, heading, content, formattedImage, cateId);
            return;
        }

        NewsDAO newsDAO = new NewsDAO();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if ("1".equals(submitType)) {
            // Handle update
            String newsId = req.getParameter("newsId");
            String updatedAt = dtf.format(now);
            newsDAO.updateNews(Integer.parseInt(cateId), title, formattedImage, heading, author, updatedAt, content, Integer.parseInt(newsId));
            session.setAttribute("functionToast", "showToast('success','Update news successfully!')");
        } else {
            // Handle addition
            String createdAt = dtf.format(now);
            Account account = (Account) session.getAttribute("acc");
            newsDAO.addNews(account.getAccountID(), Integer.parseInt(cateId), title, formattedImage, heading, author, createdAt, content);
            session.setAttribute("functionToast", "showToast('success','Add news successfully!')");
        }

        resp.sendRedirect("news");
    }

    private void forwardToForm(HttpServletRequest req, HttpServletResponse resp, String author, String title, String heading, String content, String image, String cateId) throws ServletException, IOException {
        NewsGroupDAO newsGroupDAO = new NewsGroupDAO();
        req.setAttribute("author", author);
        req.setAttribute("title", title);
        req.setAttribute("heading", heading);
        req.setAttribute("content", content);
        req.setAttribute("image", image);
        req.setAttribute("cateId", cateId);
        req.setAttribute("groups", newsGroupDAO.getListNewsGroup());
        req.getRequestDispatcher("newsDetailManagement.jsp").forward(req, resp);
    }

    public static String extractImageSrc(String html) {
        if (html == null) {
            return "";
        }
        int startIndex = html.indexOf("src=\"");
        if (startIndex == -1) {
            return "";
        }
        startIndex += "src=\"".length();
        int endIndex = html.indexOf("\"", startIndex);
        return endIndex == -1 ? "" : html.substring(startIndex, endIndex);
    }
}
