package ao.com.angotech.service;

import ao.com.angotech.dto.FlightsDto;
import ao.com.angotech.model.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> findAll();
    Flight findById(Long id);
    Flight create(FlightsDto flight);
    Flight update(Long id, FlightsDto flight);

    void delete(Long id);
}
