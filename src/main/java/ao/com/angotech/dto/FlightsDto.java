package ao.com.angotech.dto;

import ao.com.angotech.enums.FlightStatus;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FlightsDto {

    private Long id;

    @NotBlank(message = "Airline cannot be empty.")
    @Size(max = 100, message = "Airline name must not exceed 100 characters.")
    private String airline;

    @NotBlank(message = "Flight number cannot be empty.")
    @Size(max = 10, message = "Flight number must not exceed 10 characters.")
    private String flightNumber;

    @NotBlank(message = "Origin cannot be empty.")
    @Size(max = 50, message = "Origin must not exceed 50 characters.")
    private String origin;

    @NotBlank(message = "Destination cannot be empty.")
    @Size(max = 50, message = "Destination must not exceed 50 characters.")
    private String destination;

    @NotNull(message = "Departure time cannot be null.")
    @Future(message = "Departure time must be in the future.")
    private Timestamp departureTime;

    @NotNull(message = "Available seats cannot be null.")
    @PositiveOrZero(message = "Available seats must be zero or positive.")
    @Max(value = 1000, message = "Available seats cannot exceed 1000.")
    private Integer availableSeats;

    @NotNull(message = "Total seats cannot be null.")
    @Positive(message = "Total seats must be a positive number.")
    @Max(value = 1000, message = "Total seats cannot exceed 1000.")
    private Integer totalSeats;

    @NotNull(message = "Arrival time cannot be null.")
    @Future(message = "Arrival time must be in the future.")
    private Timestamp arrivalTime;

    @NotNull(message = "Price cannot be null.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero.")
    private BigDecimal price;

    @NotNull(message = "Flight status cannot be null")
    private FlightStatus status;

    @NotNull(message = "Created at timestamp cannot be null.")
    private Timestamp created_at;

    @NotNull(message = "Updated at timestamp cannot be null.")
    private Timestamp updated_at;

    public FlightsDto() {}

    public FlightsDto(Long id, String airline, String flightNumber, String origin, String destination, Timestamp departureTime, Integer availableSeats, Integer totalSeats, Timestamp arrivalTime, BigDecimal price, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
