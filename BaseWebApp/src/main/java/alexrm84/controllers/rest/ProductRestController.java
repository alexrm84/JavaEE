package alexrm84.controllers.rest;

import alexrm84.entities.DAO.ProductDAO;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/products")
public interface ProductRestController {

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductDAO> findAll();

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    ProductDAO findById(@PathParam("id") Long id);

    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductDAO productDAO);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductDAO productDAO);

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") Long id);
}
