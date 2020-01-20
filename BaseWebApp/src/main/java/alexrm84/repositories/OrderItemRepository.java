package alexrm84.repositories;

import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class OrderItemRepository {
    private Session session;


}
