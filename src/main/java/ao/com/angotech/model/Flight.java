package ao.com.angotech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("airline")
    private String airline;

    @Column(name = "flight_number", unique = true)
    @JsonProperty("flightNumber")
    private String flightNumber;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("destination")
    private String destination;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "departure_time")
    @JsonProperty("departureTime")
    private Timestamp departureTime;

    @Column(name = "available_seats")
    @JsonProperty("availableSeats")
    private Integer availableSeats;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "arrival_time")
    @JsonProperty("arrivalTime")
    private Timestamp arrivalTime;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(updatable = false)
    @CreationTimestamp
    @JsonProperty("created_at")
    private Timestamp created_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @JsonProperty("updated_at")
    private Timestamp updated_at;
}
