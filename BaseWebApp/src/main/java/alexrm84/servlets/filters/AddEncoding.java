package alexrm84.servlets.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AddEncoding", urlPatterns = "/*")
public class AddEncoding implements Filter {
    private FilterConfig filterConfig;
    private Logger logger = LoggerFactory.getLogger(AddEncoding.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("AddEncoding filter destroyed");
    }
}
