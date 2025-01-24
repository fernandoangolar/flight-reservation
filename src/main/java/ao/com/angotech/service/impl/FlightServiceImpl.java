package ao.com.angotech.service.impl;

import ao.com.angotech.dto.FlightsDto;
import ao.com.angotech.exception.*;
import ao.com.angotech.mapper.FlightsMapper;
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

        return getFlight(id);

    }

    @Override
    @Transactional
    public Flight create(FlightsDto dto) {

        existsNumberFlight(dto);

        invalidFlightSchedule(dto);

        invalidSeat(dto);

        invalidRoute(dto);

        return flightsRepository.save(FlightsMapper.fromDtoToEntity(dto));

    }

    @Override
    @Transactional
    public Flight update(Long id, FlightsDto dto) {

        Optional<Flight> existsFlightNumber = flightsRepository.findByFlightNumber(dto.getFlightNumber());

        if ( existsFlightNumber.isPresent() && existsFlightNumber.get().getId() != id ) {
            throw new FlightAlreadyExistsException("Flight number " + dto.getFlightNumber() + " already exists.");
        }

        invalidFlightSchedule(dto);

        invalidSeat(dto);

        getFlight(id);

        invalidRoute(dto);

        dto.setId(id);
        return flightsRepository.save(FlightsMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {

        getFlight(id);

        flightsRepository.deleteById(id);
    }


    private Flight getFlight(Long id) {

        Optional<Flight> flight1 = flightsRepository.findById(id);

        if ( flight1.isEmpty() ) {
            throw new NotFoundException("Entity not found");
        }

        return flight1.get();

    }

    private Optional<Flight> existsNumberFlight(FlightsDto dto) {

        Optional<Flight> existsFlightNumber = flightsRepository.findByFlightNumber(dto.getFlightNumber());

        if ( existsFlightNumber.isPresent() ) {
            throw new FlightAlreadyExistsException("Flight number " + dto.getFlightNumber() + " already exists.");
        }

        return existsFlightNumber;

    }

    private void invalidRoute(FlightsDto dto) {

        if ( dto.getOrigin().equalsIgnoreCase(dto.getDestination()) ) {
            throw new InvalidFlightRouteException("The flight destination cannot be the same as the origin.");
        }

    }

    private void invalidSeat(FlightsDto dto) {

        if ( dto.getAvailableSeats() > dto.getTotalSeats() ) {
            throw new InvalidSeatAllocationException("Available seats cannot exceed the total number of seats on the flight.");
        }

    }

    private void invalidFlightSchedule(FlightsDto dto) {
        if ( dto.getArrivalTime().before(dto.getDepartureTime()) ) {
            throw new InvalidFlightScheduleException("Arrival time must be after the departure time.");
        }
    }
}
