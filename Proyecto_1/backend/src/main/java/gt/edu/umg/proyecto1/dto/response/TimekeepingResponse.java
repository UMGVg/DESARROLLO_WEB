package gt.edu.umg.proyecto1.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TimekeepingResponse {
    private long idTimekeeping;
    private long idEmployee;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private int manHours;
}
