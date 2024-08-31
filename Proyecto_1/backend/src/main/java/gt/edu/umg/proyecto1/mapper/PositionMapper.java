package gt.edu.umg.proyecto1.mapper;

import gt.edu.umg.proyecto1.dto.request.PositionRequest;
import gt.edu.umg.proyecto1.dto.response.PositionResponse;
import gt.edu.umg.proyecto1.model.PositionModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PositionMapper {

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public PositionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Funcion que convierte PositionModel a tipo PositionResponse
     *
     * @param positionModel informacion del empleado
     * @return PositionResponse
     */
    public PositionResponse toDto(PositionModel positionModel) {
        var positionResponse = this.modelMapper.map(positionModel, PositionResponse.class);
        positionResponse.setIdPosition(positionModel.getIdPosition());
        positionResponse.setName(positionModel.getName());
        positionResponse.setDescription(positionModel.getDescription());

        return positionResponse;
    }

    /**
     * Funcion que convierte PositionRequest a tipo PositionModel
     *
     * @param positionRequest informacion del empleado
     * @return positionModel
     */
    public PositionModel toEntity(PositionRequest positionRequest) {
        PositionModel positionModel = this.modelMapper.map(positionRequest, PositionModel.class);
        positionModel.setName(positionRequest.getName());
        positionModel.setDescription(positionRequest.getDescription());

        return positionModel;
    }

    /**
     * Funcion que actualiza el bill de base de datos con el bill del request
     *
     * @param positionModel   PositionModel de base de datos
     * @param positionRequest position del request
     * @return position actualizado
     */
    public PositionModel toUpdateEntity(PositionModel positionModel, PositionRequest positionRequest) {
        positionModel.setName(positionRequest.getName());
        positionModel.setDescription(positionRequest.getDescription());

        return positionModel;
    }
}
