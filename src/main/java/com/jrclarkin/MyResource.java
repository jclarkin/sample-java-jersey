package com.jrclarkin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @SuppressWarnings("unchecked")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String post(String aRequest) throws IOException {

    	Map<String,Object> result =
    	        new ObjectMapper().readValue(aRequest, HashMap.class);
    	System.out.println(result);
    	return aRequest;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("repair/contract")
    public String getREpairSTation() {
        return "All the secrets";
    }

    
}
