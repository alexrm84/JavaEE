package alexrm84.controllers;

import alexrm84.entities.Product;
import alexrm84.repositories.ProductRepository;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ShopController implements Serializable {

    private static final long serialVersionUID = 6500398559644099323L;

    @Getter
    @Setter
    private Product product;

    @Getter
    private List<Product> products;

    @Inject
    private ProductRepository productRepository;

    public void preloadProducts(){
        this.products = productRepository.findAll();
    }

    public String createProduct(){
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(Product product){
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product){
        productRepository.delete(product.getId());
    }

    public String saveProduct(){
        if (this.product.getId() == null){
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/shop.xhtml?faces-redirect=true";
    }

    public String showProductInfo(Product product){
        this.product = product;
        return "/productInfo.xhtml?faces-redirect=true";
    }

    public String showShopPage(){
        return "/shop.xhtml?faces-redirect=true";
    }
}
