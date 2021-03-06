package alexrm84.utils;

import alexrm84.entities.DAO.OrderItemDAO;
import alexrm84.entities.DAO.ProductDAO;
import alexrm84.entities.OrderItem;
import alexrm84.entities.Product;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class Cart implements Serializable {

    private static final long serialVersionUID = 2268736247949966333L;

    private Map<Long, OrderItemDAO> items;

    @Getter
    private BigDecimal orderTotalPrice;

    @PostConstruct
    public void init(){
        items = new LinkedHashMap<>();
    }

    public void addProduct(ProductDAO product){
        OrderItemDAO item = items.get(product.getId());
        if (item==null) {
            item = new OrderItemDAO(product, 0, product.getPrice());
        }
        item.setQuantity(item.getQuantity()+1);
        item.setTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getQuantity())));
        items.put(product.getId(), item);
        recalculate();
    }

    public void reduceProduct(ProductDAO product){
        OrderItemDAO item = items.get(product.getId());
        if (item.getQuantity()==1){
            items.remove(product.getId());
        }else {
            item.setQuantity(item.getQuantity()-1);
            item.setTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getQuantity())));
            items.put(product.getId(), item);
        }
        recalculate();
    }

    public void clear() {
        items.clear();
        orderTotalPrice = new BigDecimal(0);
    }

    private void recalculate() {
        orderTotalPrice = new BigDecimal(0);
        items.values().stream().map(oi -> orderTotalPrice = orderTotalPrice.add(oi.getTotalPrice()));
    }

    public List<OrderItemDAO> getItems(){
        return items.values().stream().collect(Collectors.toList());
    }

}
