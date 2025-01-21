package ao.com.angotech.service;

import ao.com.angotech.model.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> findAll();
    Flight findById(Long id);
    Flight create(Flight flight);
    Flight update(Long id, Flight flight);

    void delete(Long id);
}
