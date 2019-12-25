package alexrm84.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

//Remember!!! URL mapping patterns.
// '/something'
// '/something/*'
// '/*.xxx'
// ''
// '/'
// '/*' <---AntiPattern, use only for filters.

public class MainServlet implements Servlet, Serializable {

    private transient ServletConfig servletConfig;
    private Logger logger = LoggerFactory.getLogger(MainServlet.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.info("new request");
        response.getWriter().println("<title>Main</title>");
        response.getWriter().println("<h1>hello</h1>");
    }

    @Override
    public String getServletInfo() {
        return "Main servlet";
    }

    @Override
    public void destroy() {
        logger.info("Main servlet destroyed");
    }
}
