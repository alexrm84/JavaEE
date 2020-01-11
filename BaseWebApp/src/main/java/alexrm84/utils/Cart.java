package alexrm84.utils;

import alexrm84.entities.OrderItem;
import alexrm84.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class Cart {

    private Map<Long, OrderItem> items;
    private BigDecimal totalPrice;

    @PostConstruct
    public void init(){
        items = new LinkedHashMap<>();
    }

    public void addProduct(Product product){
        OrderItem item = items.get(product.getId());
        if (item==null) {
            item = new OrderItem();
            item.setProduct(product);
            item.setItemPrice(product.getPrice());
            item.setQuantity(0);
        }
        item.setQuantity(item.getQuantity()+1);
        item.setTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getQuantity())));
        items.put(product.getId(), item);
        recalculate();
    }

    public void reduceProduct(Product product){
        OrderItem item = items.get(product.getId());
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
        totalPrice = new BigDecimal(0);
    }

    private void recalculate() {
        totalPrice = new BigDecimal(0);
        items.values().stream().forEach(oi -> totalPrice = totalPrice.add(oi.getTotalPrice()));
    }

}
