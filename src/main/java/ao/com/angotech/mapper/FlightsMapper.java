package ao.com.angotech.mapper;

import ao.com.angotech.dto.FlightsDto;
import ao.com.angotech.model.Flight;

public class FlightsMapper {

    public static Flight fromDtoToEntity(FlightsDto dto) {

        Flight flight = new Flight();
        flight.setId(dto.getId());
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setAirline(dto.getAirline());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setDestination(dto.getDestination());
        flight.setAvailableSeats(dto.getAvailableSeats());
        flight.setTotalSeats(dto.getTotalSeats());
        flight.setCreated_at(dto.getCreated_at());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setOrigin(dto.getOrigin());
        flight.setPrice(dto.getPrice());
        flight.setUpdated_at(dto.getUpdated_at());

        return flight;
    }
}
