package gt.edu.umg.proyecto1.service;

import gt.edu.umg.proyecto1.dto.response.PositionResponse;
import gt.edu.umg.proyecto1.mapper.PositionMapper;
import gt.edu.umg.proyecto1.model.PositionModel;
import gt.edu.umg.proyecto1.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionMapper positionMapper;
    private final PositionRepository positionRepository;

    public PositionService(PositionMapper positionMapper, PositionRepository positionRepository) {
        this.positionMapper = positionMapper;
        this.positionRepository = positionRepository;
    }

    public List<PositionResponse> findAllPosition() {
        List<PositionModel> positions = positionRepository.findAll();

        return positions.stream().map(positionMapper::toDto).toList();
    }



}
