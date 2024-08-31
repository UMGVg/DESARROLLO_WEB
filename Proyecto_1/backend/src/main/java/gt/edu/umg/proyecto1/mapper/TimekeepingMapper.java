package gt.edu.umg.proyecto1.mapper;

import gt.edu.umg.proyecto1.model.TimekeepingModel;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class TimekeepingMapper {

    /**
     * Funcion que convierte TimekeepingRequest a tipo TimekeepingModel
     *
     * @param idEmployee informacion del empleado
     * @return timeKeepingModel
     */
    public TimekeepingModel toEntity(long idEmployee) {
        TimekeepingModel timeKeepingModel = new TimekeepingModel();
        timeKeepingModel.setIdEmployee(idEmployee);
        timeKeepingModel.setCheckIn(LocalDateTime.now());

        return timeKeepingModel;
    }

    /**
     * Funcion que actualiza el bill de base de datos con el bill del request
     *
     * @param timeKeepingModel   TimekeepingModel de base de datos
     * @return timeKeeping actualizado
     */
    public TimekeepingModel toUpdateEntity(TimekeepingModel timeKeepingModel) {

        timeKeepingModel.setCheckOut(LocalDateTime.now());

        return timeKeepingModel;
    }
    
}
