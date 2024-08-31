package gt.edu.umg.proyecto1.repository;

import gt.edu.umg.proyecto1.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    Boolean existsByFirstname(String firstname);
}
