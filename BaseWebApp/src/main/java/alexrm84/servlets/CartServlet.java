package alexrm84.servlets;

import alexrm84.repositories.ProductRepository;
import alexrm84.utils.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = {"cart",
                                                "cart/add",
                                                "cart/reduce"})
public class CartServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CartServlet.class);
    private Cart cart;
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();//(ProductRepository) getServletContext().getAttribute("productRepository");
        this.cart = new Cart();
        if (productRepository == null){
            throw new ServletException("ProductRepository not created");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/cart")){
            request.setAttribute("items", cart.getItems().values());
            getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }

}
