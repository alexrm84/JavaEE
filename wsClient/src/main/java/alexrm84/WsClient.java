package alexrm84;

import alexrm84.services.ProductServiceWs;
import alexrm84.services.ProductServiceWs_Service;

import java.net.MalformedURLException;
import java.net.URL;

public class WsClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/BaseWebApp/ProductServiceWs/ProductServiceImpl?wsdl");
        ProductServiceWs_Service productService = new ProductServiceWs_Service(url);
        ProductServiceWs productServiceWs = productService.getProductServiceImplPort();
        productServiceWs.findAll().forEach(p -> System.out.println(p.getTitle()));
    }
}
