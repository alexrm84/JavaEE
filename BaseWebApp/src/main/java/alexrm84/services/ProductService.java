package alexrm84.services;

import alexrm84.entities.DAO.ProductDAO;
import alexrm84.entities.Product;

import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Local
public interface ProductService {

    ProductDAO insert(ProductDAO productDAO);
    ProductDAO update(ProductDAO productDAO);
    void delete(Long id);
    ProductDAO findById(Long id);
    List<ProductDAO> findAll();
    ProductDAO convertToDao(Product product);
    Product convertFromDao(ProductDAO productDAO);
}
