package ao.com.angotech.controller;

import ao.com.angotech.model.Flight;
import ao.com.angotech.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightsController {

    @Autowired
    private FlightsRepository flightsRepository;


    @GetMapping
    public ResponseEntity<List<Flight>> findAll() {
        List<Flight> flights = flightsRepository.findAll();

        return ResponseEntity.ok(flights);
    }
}
