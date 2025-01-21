package ao.com.angotech.repository;

import ao.com.angotech.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FlightsRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);
}
