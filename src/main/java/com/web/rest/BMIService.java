package com.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bmi")
public class BMIService {

    // Client: /JavaWebTest/rest/bmi/170/60
    @Path("/{h}/{w}")
    @GET
    //@Produces("text/plain")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcBmi_1(@PathParam("h") double h, @PathParam("w") double w) {
        double bmi = w / Math.pow(h / 100, 2);
        return String.format("h=%.1f w=%.1f bmi=%.2f", h, w, bmi);
    }

    // Client: /JavaWebTest/rest/bmi/?h=170&w=60
    @Path("/")
    @GET
    //@Produces("text/plain")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcBmi_2(@QueryParam("h") double h, @QueryParam("w") double w) {
        double bmi = w / Math.pow(h / 100, 2);
        return String.format("h=%.1f w=%.1f bmi=%.2f", h, w, bmi);
    }
}
