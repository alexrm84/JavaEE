package alexrm84.utils;

import alexrm84.entities.Order;
import alexrm84.entities.OrderItem;
import alexrm84.entities.Product;
import alexrm84.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
    private final String DB_DRIVER_NAME = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://192.168.56.101:5432/postgres?currentSchema=javaee";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "admin";
    private final String DB_DIALECT = "org.hibernate.dialect.PostgreSQL94Dialect";
    private final String DB_SHOW_SQL = "true";
    private final String DB_CURRENT_SESSION_CONTEXT_CLASS = "thread";
    private final String DB_HBM2DDL_AUTO = "create-drop";

    private SessionFactory sf;
    private Configuration cfg;

    private static volatile HibernateUtil instance;
    public static HibernateUtil getInstance(){
        if (instance == null){
            synchronized (HibernateUtil.class){
                if (instance == null){
                    instance= new HibernateUtil();
                }
            }
        }
        return instance;
    }

    public SessionFactory getSf(){
        if (sf==null){
            cfg = new Configuration();
            cfg.setProperty(Environment.DRIVER, DB_DRIVER_NAME);
            cfg.setProperty(Environment.URL, DB_URL);
            cfg.setProperty(Environment.USER, DB_USERNAME);
            cfg.setProperty(Environment.PASS, DB_PASSWORD);
            cfg.setProperty(Environment.DIALECT, DB_DIALECT);
            cfg.setProperty(Environment.SHOW_SQL, DB_SHOW_SQL);
//            cfg.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, DB_CURRENT_SESSION_CONTEXT_CLASS);
//            cfg.setProperty(Environment.HBM2DDL_AUTO, DB_HBM2DDL_AUTO);

            cfg.addAnnotatedClass(Product.class);
            cfg.addAnnotatedClass(User.class);
            cfg.addAnnotatedClass(Order.class);
            cfg.addAnnotatedClass(OrderItem.class);
            sf = cfg.buildSessionFactory();
        }
        return sf;
    }
}
