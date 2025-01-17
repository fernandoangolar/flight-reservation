package ao.com.angotech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long id;

    @Column(nullable = true)
    private String airline;

    @Column(name = "flight_number", nullable = true)
    private String flightNumber;

    @Column(nullable = true)
    private String origin;

    @Column(nullable = true)
    private String destination;

    private Timestamp departureTime;
    private Timestamp arrivalTime;

    @Column(nullable = true)
    private Integer availableSeats;

    @Column(nullable = true)
    private BigDecimal price;


    @Column(updatable = false)
    private Timestamp created_at;


    private Timestamp updated_at;

}
