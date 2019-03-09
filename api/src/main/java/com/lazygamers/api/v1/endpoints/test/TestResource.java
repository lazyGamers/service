package com.lazygamers.api.v1.endpoints.test;

import com.lazygamers.services.LogService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
    
    @Inject
    private LogService logService;
    
    @GET
    @Path("/log")
    public Response log() {
        logService.info("information");
        logService.debug("debugging");
        logService.warn("this is warning!");
        logService.error("somethng's off!");
        return Response.ok().build();
    }
}
