package domainevent.registry;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import domainevent.command.handler.CommandHandler;

import msa.commons.event.EventId;
import msa.commons.microservices.airport.qualifier.GetAirportByIdQualifier;

@Singleton
@Startup
public class CommandRegistry {
    private Map<EventId, CommandHandler> handlers = new EnumMap<>(EventId.class);

    @PostConstruct
    public void init(){
    }

    public CommandHandler getHandler(EventId eventId) {
        return this.handlers.get(eventId);
    }
}
