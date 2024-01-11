package org.hdfcbank;


import java.net.URI;

import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/callback")
public class CallBackResource {

    @Inject
    JsonWebToken jwt;

    @GET
    public Response callback() {
        if (jwt == null || jwt.getClaimNames() == null) {
            // Handle authentication failure
            return Response.seeOther(URI.create("/login-failed")).build();
        } else {
            // Authentication succeeded
            return Response.seeOther(URI.create("/hdfc_login")).build();
        }
    }
}
