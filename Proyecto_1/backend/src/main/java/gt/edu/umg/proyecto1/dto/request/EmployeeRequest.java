package gt.edu.umg.proyecto1.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private long positionId;
    private long userId;
    private String dpi;
    private String firstname;
    private String lastname;
    private String contact;
}
