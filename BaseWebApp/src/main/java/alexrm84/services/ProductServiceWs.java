package alexrm84.services;

import alexrm84.entities.DAO.ProductDAO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {

    @WebMethod
    ProductDAO insert(ProductDAO productDAO);

    @WebMethod
    ProductDAO update(ProductDAO productDAO);

    @WebMethod
    void delete(Long id);

    @WebMethod
    ProductDAO findById(Long id);

    @WebMethod
    List<ProductDAO> findAll();
}
