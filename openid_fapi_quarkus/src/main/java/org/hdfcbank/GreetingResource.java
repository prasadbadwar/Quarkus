package org.hdfcbank;

import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hdfc_login")
public class GreetingResource {

	@Inject
    JsonWebToken jwt;
	
    @GET
    @Path("/user")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello "+ jwt.getName();
    }
}
