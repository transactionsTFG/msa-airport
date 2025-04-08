package domainevent.command;

import javax.ejb.Local;
import javax.ejb.Stateless;

import business.airport.AirportDTO;
import domainevent.command.handler.BaseHandler;
import domainevent.command.handler.EventHandler;
import msa.commons.event.EventId;
import msa.commons.microservices.airport.qualifier.GetAirportByIdQualifier;
import msa.commons.parser.NumberParser;

@Stateless
@GetAirportByIdQualifier
@Local(EventHandler.class)
public class GetAircraftByIdEvent extends BaseHandler {

    @Override
    public void handleCommand(String json) {
        long idAirport = this.gson.fromJson(json, Long.class);
        AirportDTO a = this.aircraftServices.getAirportById(idAirport);
        this.jmsEventPublisher.publish(EventId.GET_AIRPORT_BY_ID, a);
    }
    
}
