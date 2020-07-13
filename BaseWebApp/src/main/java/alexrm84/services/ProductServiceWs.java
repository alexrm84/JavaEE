package alexrm84.services;

import alexrm84.entities.DAO.ProductDAO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {

    @WebMethod
    void insert(ProductDAO productDAO);

    @WebMethod
    void update(ProductDAO productDAO);

    @WebMethod
    void delete(Long id);

    @WebMethod
    ProductDAO findById(Long id);

    @WebMethod
    List<ProductDAO> findAll();
}
