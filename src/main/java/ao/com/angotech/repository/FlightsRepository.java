package ao.com.angotech.repository;

import ao.com.angotech.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flights, Long> {
}
