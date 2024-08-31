package gt.edu.umg.proyecto1.mapper;

import gt.edu.umg.proyecto1.dto.request.EmployeeRequest;
import gt.edu.umg.proyecto1.dto.request.PositionRequest;
import gt.edu.umg.proyecto1.dto.request.UserRequest;
import gt.edu.umg.proyecto1.dto.response.EmployeeResponse;
import gt.edu.umg.proyecto1.model.EmployeeModel;
import gt.edu.umg.proyecto1.model.PositionModel;
import gt.edu.umg.proyecto1.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public EmployeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Funcion que convierte EmployeeModel a tipo EmployeeResponse
     *
     * @param employeeModel informacion del empleado
     * @return EmployeeResponse
     */
    public EmployeeResponse toDto(EmployeeModel employeeModel) {
        return this.modelMapper.map(employeeModel, EmployeeResponse.class);
    }

    /**
     * Funcion que convierte EmployeeRequest a tipo EmployeeModel
     *
     * @param employeeRequest informacion del empleado
     * @return employeeModel
     */
    public EmployeeModel toEntity(EmployeeRequest employeeRequest) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setIdPosition(employeeRequest.getPositionId());
        employeeModel.setIdUser(employeeRequest.getUserId());
        employeeModel.setDpi(employeeRequest.getDpi());
        employeeModel.setFirstname(employeeRequest.getFirstname());
        employeeModel.setLastname(employeeRequest.getLastname());
        employeeModel.setContact(employeeRequest.getContact());

        return employeeModel;
    }

    /**
     * Funcion que actualiza el bill de base de datos con el bill del request
     *
     * @param employeeModel   PositionModel de base de datos
     * @param employeeRequest position del request
     * @return position actualizado
     */
    public EmployeeModel toUpdateEntity(EmployeeModel employeeModel, EmployeeRequest employeeRequest) {
        employeeModel.setIdPosition(employeeRequest.getPositionId());
        employeeModel.setIdUser(employeeRequest.getUserId());
        employeeModel.setDpi(employeeRequest.getDpi());
        employeeModel.setFirstname(employeeRequest.getFirstname());
        employeeModel.setLastname(employeeRequest.getLastname());
        employeeModel.setContact(employeeRequest.getContact());

        return employeeModel;
    }

}
