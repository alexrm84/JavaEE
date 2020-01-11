package alexrm84.servlets;

import alexrm84.repositories.OrderRepository;
import alexrm84.repositories.ProductRepository;
import alexrm84.utils.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = {"order", "order/create"})
public class OrderServlet extends HttpServlet {
    private OrderRepository orderRepository;

    @Override
    public void init() throws ServletException {
        this.orderRepository = new OrderRepository();
        if (orderRepository == null){
            throw new ServletException("OrderRepository not created");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/order")){
            getServletContext().getRequestDispatcher("/order.jsp").forward(request, response);
        }
    }
}
