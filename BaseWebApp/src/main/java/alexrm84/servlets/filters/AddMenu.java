package alexrm84.servlets.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AddMenu", urlPatterns = "/*")
public class AddMenu implements Filter {
    private FilterConfig filterConfig;
    private Logger logger = LoggerFactory.getLogger(AddMenu.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterConfig.getServletContext().getRequestDispatcher("/menu.jsp").include(request, response);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("AddMenu filter destroyed");
    }
}
