package gt.edu.umg.proyecto1.mapper;

import gt.edu.umg.proyecto1.dto.request.UserRequest;
import gt.edu.umg.proyecto1.dto.response.EmployeeResponse;
import gt.edu.umg.proyecto1.dto.response.UserResponse;
import gt.edu.umg.proyecto1.model.EmployeeModel;
import gt.edu.umg.proyecto1.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Funcion que convierte EmployeeModel a tipo EmployeeResponse
     *
     * @param userModel informacion del empleado
     * @return EmployeeResponse
     */
    public UserResponse toDto(UserModel userModel) {
        return this.modelMapper.map(userModel, UserResponse.class);
    }

    /**
     * Funcion que convierte TimekeepingRequest a tipo TimekeepingModel
     *
     * @param userRequest informacion del empleado
     * @return timeKeepingModel
     */
    public UserModel toEntity(UserRequest userRequest) {
        UserModel userModel = this.modelMapper.map(userRequest, UserModel.class);
        userModel.setUsername(userRequest.getUsername());
        userModel.setPassword(userRequest.getPassword());

        return userModel;
    }



}
