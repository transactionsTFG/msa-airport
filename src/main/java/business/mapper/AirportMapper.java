package business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import business.airport.Airport;
import business.airport.AirportDTO;

@Mapper
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);
    AirportDTO entityToDto(Airport airport);
}
