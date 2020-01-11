package alexrm84.servlets;

import alexrm84.entities.Product;
import alexrm84.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = {"shop",
                                                "shop/create",
                                                "shop/edit",
                                                "shop/update",
                                                "shop/delete",
                                                "shop/details"})
public class ShopServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(ShopServlet.class);
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();//(ProductRepository) getServletContext().getAttribute("productRepository");
        if (productRepository == null){
            throw new ServletException("ProductRepository not created");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/shop")){
            List<Product> products = productRepository.findAll();
            request.setAttribute("products", productRepository.findAll());
            getServletContext().getRequestDispatcher("/shop.jsp").forward(request, response);
        }
        if (request.getServletPath().equals("/shop/create")) {
            showCreateProductPage(request, response);
        }
        if (request.getServletPath().equals("/shop/edit")) {
            showEditProductPage(request, response);
        }
        if (request.getServletPath().equals("/shop/delete")) {
            deleteProduct(request, response);
        }
        if (request.getServletPath().equals("/shop/details")) {
            showDetailsProductPage(request, response);
        }

    }

    private void showDetailsProductPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (Exception ex) {
            logger.error("", ex);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Product product = productRepository.findById(id);
        request.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/productInfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/shop/update")) {
            updateProduct(request, response);
        }
        if (request.getServletPath().equals("/shop/create")) {
            createProduct(request, response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        productRepository.insert(new Product(
                (String) request.getParameter("title"),
                (String) request.getParameter("description"),
                new BigDecimal(request.getParameter("price"))
        ));
        response.sendRedirect(getServletContext().getContextPath() + "/shop");
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        productRepository.update(new Product(
                Long.parseLong(req.getParameter("id")),
                req.getParameter("title"),
                req.getParameter("description"),
                new BigDecimal(req.getParameter("price"))
        ));
        resp.sendRedirect(getServletContext().getContextPath() + "/shop");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        productRepository.delete(Long.parseLong(req.getParameter("id")));
        resp.sendRedirect(getServletContext().getContextPath() + "/shop");
    }

    private void showEditProductPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (Exception ex) {
            logger.error("", ex);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Product product = productRepository.findById(id);
        request.setAttribute("product", product);
        request.setAttribute("action", "update");
        getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
    }

    private void showCreateProductPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", new Product());
        req.setAttribute("action", "create");
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

}
