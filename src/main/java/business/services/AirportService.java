package business.services;

import java.util.List;

import business.airport.AirportDTO;

public interface AirportService {
    AirportDTO getAirportById(long id);
    List<AirportDTO> getAirportByCity(String city);
    List<AirportDTO> getAirportByCountry(String country);
}
