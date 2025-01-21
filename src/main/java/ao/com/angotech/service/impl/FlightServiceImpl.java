package ao.com.angotech.service.impl;

import ao.com.angotech.exception.FlightAlreadyExistsException;
import ao.com.angotech.exception.NotFoundException;
import ao.com.angotech.model.Flight;
import ao.com.angotech.repository.FlightsRepository;
import ao.com.angotech.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<Flight> findAll() {
        return flightsRepository.findAll();
    }

    @Override
    public Flight findById(Long id) {

        Optional<Flight> flight = flightsRepository.findById(id);

        if ( flight.isEmpty() ) {
            throw new NotFoundException("Entity not found");
        }

        return flight.get();

    }

    @Override
    @Transactional
    public Flight create(Flight flight) {

        Optional<Flight> existsFlightNumber = flightsRepository.findByFlightNumber(flight.getFlightNumber());

        if ( existsFlightNumber.isPresent() ) {
            throw new FlightAlreadyExistsException("Flight number " + flight.getFlightNumber() + " already exists.");
        }

        return flightsRepository.save(flight);

    }

    @Override
    @Transactional
    public Flight update(Long id, Flight flight) {

        Optional<Flight> existsFlightNumber = flightsRepository.findByFlightNumber(flight.getFlightNumber());

        if ( existsFlightNumber.isPresent() && existsFlightNumber.get().getId() != id ) {
            throw new FlightAlreadyExistsException("Flight number " + flight.getFlightNumber() + " already exists.");
        }

        Optional<Flight> flight1 = flightsRepository.findById(id);

        if ( flight1.isEmpty() ) {
            throw new NotFoundException("Entity not found");
        }

        flight.setId(id);
        return flightsRepository.save(flight);
    }

    @Override
    public void delete(Long id) {

        Optional<Flight> flight1 = flightsRepository.findById(id);

        if ( flight1.isEmpty() ) {
            throw new NotFoundException("Entity not found");
        }

        flightsRepository.deleteById(id);
    }


}
