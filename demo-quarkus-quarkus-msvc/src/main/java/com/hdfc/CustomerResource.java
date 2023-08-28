package com.hdfc;


import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.hdfc.entity.Book;
import com.hdfc.exception.BookNotFoundExp;
import com.hdfc.service.BookProxy;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/customer/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
	
	@RestClient
	@Inject
	BookProxy proxy;
	
	@GET
	@Path("/showbook")
	public List<Book>getAllBooks(){
		return proxy.getAllBook();
	}
	
	
	@GET
	@Path("/getBookId/{id}")
	public Book getByID(@PathParam("id") long id) throws BookNotFoundExp{
		if(proxy.getByID(id) != null)
			{
			return proxy.getByID(id);
			}
		else
			throw new BookNotFoundExp();
		
	}
}
