package business.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import business.airport.Airport;
import business.airport.AirportDTO;
import business.mapper.AirportMapper;

@Stateless
public class AirportServiceImpl implements AirportService {
    private EntityManager entityManager;
    
    @Override
    public AirportDTO getAirportById(long id) {
        Airport airport = entityManager.find(Airport.class, id, LockModeType.OPTIMISTIC);
        if (airport == null) 
            return null;
        return AirportMapper.INSTANCE.entityToDto(airport);
    }

    @Inject public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager;}
}
