package business.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import business.airport.Airport;
import business.airport.AirportDTO;
import business.external.country.CountryClient;
import business.external.country.CountryDTO;
import business.mapper.AirportMapper;

@Stateless
public class AirportServiceImpl implements AirportService {
    private EntityManager entityManager;
    private CountryClient countryClient;
    
    @Override
    public AirportDTO getAirportById(long id) {
        Airport airport = entityManager.find(Airport.class, id, LockModeType.OPTIMISTIC);
        if (airport == null) 
            return null;
        return AirportMapper.INSTANCE.entityToDto(airport);
    }

    @Override
    public List<AirportDTO> getAirportByCity(String city) {
        List<Airport> airports = entityManager.createQuery("SELECT a FROM Airport a WHERE a.city = :city", Airport.class)
                .setParameter("city", city)
                .setLockMode(LockModeType.OPTIMISTIC)
                .getResultList();
        if (airports == null || airports.isEmpty()) 
            return new ArrayList<>();
        return airports.stream()
                .map(AirportMapper.INSTANCE::entityToDto)
                .toList();
    }

    @Override
    public List<AirportDTO> getAirportByCountry(String c) {
        CountryDTO country = this.countryClient.getCountryName(c);
        if (country == null) 
            return new ArrayList<>();
        List<Airport> airports = entityManager.createQuery("SELECT a FROM Airport a WHERE a.countryId = :countryId", Airport.class)
                .setParameter("countryId", country.getId())
                .setLockMode(LockModeType.OPTIMISTIC)
                .getResultList();
        if (airports == null || airports.isEmpty()) 
            return new ArrayList<>();
        return airports.stream()
                .map(AirportMapper.INSTANCE::entityToDto)
                .toList();
    }

    @Inject public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager;}
    @Inject public void setCountryClient(CountryClient countryClient) { this.countryClient = countryClient; }
}
