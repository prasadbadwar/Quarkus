package org.hdfcbank;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/library")
public class GreetingResource {

	@Inject
	SecurityIdentity identity;
    @GET
    @Path("/book_list")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getList() {
        return Response.ok("Welcome "+identity.getPrincipal().getName()+"\nList :Abc \n EFG \n HIJ \n XYZ").build();
    }
    
    @GET
    @Path("/book")
    @RolesAllowed("viewer")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getBook() {
        return Response.ok("Welcome "+identity.getPrincipal().getName()+"\n viewer is accessing list of books").build();
    }
    
    @GET
    @Path("/add_book")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addBook() {
    	return Response.ok("\"Welcome "+identity.getPrincipal().getName()+"\n Book Added Successfully!!!").build();
    }
    
    @GET
    @Path("/update_book")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook() {
    	return Response.ok("Book Updated!").build();
    }
    
    @GET
    @Path("/delete_book")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook() {
    	return Response.ok("Book Deleted!").build();
    }
}
