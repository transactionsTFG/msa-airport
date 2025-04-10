package domainevent.command.handler;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.google.gson.Gson;

import business.services.AirportService;
import domainevent.publisher.IJMSEventPublisher;

public abstract class BaseHandler implements EventHandler {
    protected AirportService aircraftServices;
    protected IJMSEventPublisher jmsEventPublisher;
    protected Gson gson;
    @EJB
    public void setTypeUserServices(AirportService aircraftServices) {
        this.aircraftServices = aircraftServices;
    }

    @EJB
    public void setJmsEventPublisher(IJMSEventPublisher jmsEventPublisher) {
        this.jmsEventPublisher = jmsEventPublisher;
    }

    @Inject
    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
