package ao.com.angotech.enums;

public enum FlightStatus {

    SCHEDULED(1L),  // Voo agendado
    DELAYED(2L),    // Voo atrasado
    CANCELED(3L),   // Voo cancelado
    COMPLETED(4L);  // Voo concluído

    private Long id;

    FlightStatus(Long id) {
        this.id = id;
    }
}
