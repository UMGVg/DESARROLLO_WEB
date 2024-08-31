package gt.edu.umg.proyecto1.repository;

import gt.edu.umg.proyecto1.model.TimekeepingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimekeepingRepository extends JpaRepository<TimekeepingModel, Long> {
}
