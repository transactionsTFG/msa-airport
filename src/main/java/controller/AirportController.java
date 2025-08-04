package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.airport.AirportDTO;
import business.services.AirportService;

@Path("/airport")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AirportController {
    private AirportService airportService;

    @GET
    @Path("/city/{city}")
    public List<AirportDTO> getAirportByCity(@PathParam("city") String city) {
        return airportService.getAirportByCity(city);
    }

    @GET
    @Path("/country/{country}")
    public List<AirportDTO> getAirportByCountry(@PathParam("country") String country) {
        return airportService.getAirportByCountry(country);
    }


    @EJB
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

}
