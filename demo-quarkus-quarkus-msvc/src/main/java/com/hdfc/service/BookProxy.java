package com.hdfc.service;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.hdfc.entity.Book;
import com.hdfc.exception.BookNotFoundExp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@RegisterRestClient(baseUri = "https://localhost:8282/api/library")
public interface BookProxy {

	
	@GET
	@Path("/book")
	public List<Book> getAllBook();
	
	@GET
	@Path("/book/{id}")
	public Book getByID (@PathParam("id") long id) throws BookNotFoundExp;
	
}
