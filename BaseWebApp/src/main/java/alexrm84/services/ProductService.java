package alexrm84.services;

import alexrm84.entities.DAO.ProductDAO;
import alexrm84.entities.Product;
import alexrm84.repositories.ProductRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    public void insert(ProductDAO productDAO){
        productRepository.insert(convertFromDao(productDAO));
    }

    public void update(ProductDAO productDAO){
        productRepository.update(convertFromDao(productDAO));
    }

    public void delete(Long id){
        productRepository.delete(id);
    }

    public ProductDAO findById(Long id){
        return convertToDao(productRepository.findById(id));
    }

    public List<ProductDAO> findAll(){
        return productRepository.findAll().stream().map(p -> convertToDao(p)).collect(Collectors.toList());
    }

    public ProductDAO convertToDao(Product product){
        return new ProductDAO(product.getId(), product.getTitle(), product.getDescription(), product.getPrice());
    }

    public Product convertFromDao(ProductDAO productDAO) {
        Product product = new Product(productDAO.getTitle(), productDAO.getDescription(), productDAO.getPrice());
        product.setId(productDAO.getId());
        return product;
    }
}
