package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeFilter implements Filter {

    private FilterConfig filterConfig = null;

    public HomeFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = httpRequest.getServletPath();

        if (url.endsWith(".jsp") || !url.equals("404.jsp")) {
            // Chuyển hướng đến một đường dẫn hoàn chỉnh, không chỉ tên trang
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
        } else {
            // Gọi method doFilter để tiếp tục chuỗi filter
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }
    // Các phương thức khác (doBeforeProcessing, doAfterProcessing, sendProcessingError, getStackTrace, log) có thể bỏ đi nếu không sử dụng.
}
