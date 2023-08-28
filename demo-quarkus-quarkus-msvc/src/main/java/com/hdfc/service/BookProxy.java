package com.hdfc.service;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.hdfc.entity.Book;
import com.hdfc.exception.BookNotFoundExp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@RegisterRestClient(baseUri = "https://localhost:8282/api/books")
public interface BookProxy {

	
	@GET
	@Path("/allbook")
	public List<Book> getAllBook();
	
	@GET
	@Path("getBookById/{id}")
	public Book getByID (@PathParam("id") long id) throws BookNotFoundExp;
	
}
