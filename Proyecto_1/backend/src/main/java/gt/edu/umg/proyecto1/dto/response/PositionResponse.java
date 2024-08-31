package gt.edu.umg.proyecto1.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PositionResponse {
    private long idPosition;
    private String name;
    private String description;
}
