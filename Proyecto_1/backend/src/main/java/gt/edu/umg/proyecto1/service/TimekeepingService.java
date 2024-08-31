package gt.edu.umg.proyecto1.service;

import gt.edu.umg.proyecto1.mapper.TimekeepingMapper;
import gt.edu.umg.proyecto1.repository.TimekeepingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TimekeepingService {

    private final TimekeepingMapper timekeepingMapper;
    private final TimekeepingRepository timekeepingRepository;

    public TimekeepingService(TimekeepingMapper timekeepingMapper, TimekeepingRepository timekeepingRepository) {
        this.timekeepingMapper = timekeepingMapper;
        this.timekeepingRepository = timekeepingRepository;
    }

    public void markEntry(long idEmployee) {
        timekeepingRepository.save(timekeepingMapper.toEntity(idEmployee));
    }

    public void markOut(long idEmployee) throws Exception {
        var existEmployee = timekeepingRepository.findById(idEmployee).orElseThrow(Exception::new);

        timekeepingRepository.save(timekeepingMapper.toUpdateEntity(existEmployee));
    }

}
