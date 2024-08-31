package gt.edu.umg.proyecto1.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmployeeResponse {
    private Long idEmployee;
    private Long idPosition;
    private Long idUser;
    private String dpi;
    private String firstname;
    private String lastname;
    private String contact;
    private boolean isActive;
}
