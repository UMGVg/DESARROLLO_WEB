package gt.edu.umg.proyecto1.controller;

import gt.edu.umg.proyecto1.dto.response.PositionResponse;
import gt.edu.umg.proyecto1.service.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<PositionResponse> getAllPosition() {
        return positionService.findAllPosition();
    }
}
