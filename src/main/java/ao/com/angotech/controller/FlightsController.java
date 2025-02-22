package ao.com.angotech.controller;

import ao.com.angotech.dto.FlightsDto;
import ao.com.angotech.model.Flight;
import ao.com.angotech.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightsController {

    @Autowired
    private FlightService flightService;


    @GetMapping
    public ResponseEntity<List<Flight>> findAll() {
        List<Flight> flights = flightService.findAll();

        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Flight> create(@Valid @RequestBody FlightsDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(flightService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> update(@PathVariable Long id, @Valid @RequestBody FlightsDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        flightService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
