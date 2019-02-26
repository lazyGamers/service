package com.lazygamers.api.v1.endpoints.user;

import com.lazygamers.auth.context.UserContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@RequestScoped
@Path("/identity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IdentityEndpoint {
    
    @Inject
    private UserContext userContext;
    
    @GET
    public Response getUserIdentity() {
        if (userContext.userIsPresent()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("username", userContext.getUsername());
            map.put("id", userContext.getUserId());
            map.put("roles", userContext.getUserRoles());
            return Response.ok(map).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
    
}
