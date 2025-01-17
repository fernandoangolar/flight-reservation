package ao.com.angotech.repository;

import ao.com.angotech.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightsRepository extends JpaRepository<Flight, Long> {
}
