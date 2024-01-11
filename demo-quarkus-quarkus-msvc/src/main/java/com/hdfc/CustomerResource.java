package com.hdfc;


import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.hdfc.entity.Book;
import com.hdfc.exception.BookNotFoundExp;
import com.hdfc.service.BookProxy;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name="Client Customer Microservice")     //openapi documentation

@Path("/customer/library")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
	
	@RestClient
	@Inject
	BookProxy proxy;
	
	
//	Mailer object inject
	@Inject
	Mailer mailer;
	
	
	@GET
	@Path("/book")
	@Operation(summary = "This API Display All the Books",description = "Getting all the books from server")
	public List<Book>getAllBooks(){
		return proxy.getAllBook();
	}
	
	
	@GET
	@Path("/book/{id}")
	@Operation(summary = "This API Fetch Book by Id Number", description = "It display Book details according to Book number")
	public Book getByID(@PathParam("id") long id) throws BookNotFoundExp{
		if(proxy.getByID(id) != null)
			{
			mail("Client Successfully Fetched Book data of Id:"+id);
			return proxy.getByID(id);
			}
		else {
			throw new BookNotFoundExp();
		}
			
		
	}
	
	public void mail(String message) {
		 Mail mail = Mail.withText("pbbadwar123@gmail.com", "Update From Client Customer", message);
		 mailer.send(mail);
		 
		
	}
}
