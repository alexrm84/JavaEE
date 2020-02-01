package alexrm84.controllers;

import alexrm84.entities.DAO.ProductDAO;
import alexrm84.services.ProductService;
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
    private ProductDAO product;

    @Getter
    private List<ProductDAO> products;

    @Inject
    private ProductService productService;

    public void preloadProducts(){
        this.products = productService.findAll();
    }

    public String createProduct(){
        this.product = new ProductDAO();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(ProductDAO productDAO){
        this.product = productDAO;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductDAO product){
        productService.delete(product.getId());
    }

    public String saveProduct(){
        if (this.product.getId() == null){
            productService.insert(product);
        } else {
            productService.update(product);
        }
        return "/shop.xhtml?faces-redirect=true";
    }

    public String showProductInfo(ProductDAO productDAO){
        this.product = productDAO;
        return "/productInfo.xhtml?faces-redirect=true";
    }

    public String showShopPage(){
        return "/shop.xhtml?faces-redirect=true";
    }
}
