package gt.edu.umg.proyecto1.controller;

import gt.edu.umg.proyecto1.service.TimekeepingService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/timekeepings")
public class TimekeepingController {

    private final TimekeepingService timekeepingService;

    public TimekeepingController(TimekeepingService timekeepingService) {
        this.timekeepingService = timekeepingService;
    }

    @PostMapping("/{idEmployee}/entry")
    public void markEntry(@PathVariable long idEmployee) {
        timekeepingService.markEntry(idEmployee);
    }

    @PostMapping("/{idEmployee}/out")
    public void markOut(@PathVariable long idEmployee) throws Exception {
        timekeepingService.markOut(idEmployee);
    }

}
