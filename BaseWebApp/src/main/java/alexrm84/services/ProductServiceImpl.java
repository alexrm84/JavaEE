package alexrm84.services;

import alexrm84.controllers.rest.ProductRestController;
import alexrm84.entities.DAO.ProductDAO;
import alexrm84.entities.Product;
import alexrm84.repositories.ProductRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "alexrm84.services.ProductServiceWs", serviceName = "ProductServiceWs")
public class ProductServiceImpl implements ProductService, ProductServiceWs, ProductRestController {

    @Inject
    private ProductRepository productRepository;

    @Override
    public ProductDAO insert(ProductDAO productDAO){
        return convertToDao(productRepository.insert(convertFromDao(productDAO)));
    }

    @Override
    public ProductDAO update(ProductDAO productDAO){
        return convertToDao(productRepository.update(convertFromDao(productDAO)));
    }

    @Override
    public void delete(Long id){
        productRepository.delete(id);
    }

    @Override
    public ProductDAO findById(Long id){
        return convertToDao(productRepository.findById(id));
    }

    @Override
    public List<ProductDAO> findAll(){
        return productRepository.findAll().stream().map(p -> convertToDao(p)).collect(Collectors.toList());
    }

    @Override
    public ProductDAO convertToDao(Product product){
        return new ProductDAO(product.getId(), product.getTitle(), product.getDescription(), product.getPrice());
    }

    @Override
    public Product convertFromDao(ProductDAO productDAO) {
        Product product = new Product(productDAO.getTitle(), productDAO.getDescription(), productDAO.getPrice());
        product.setId(productDAO.getId());
        return product;
    }
}
