package gt.edu.umg.proyecto1.service;

import gt.edu.umg.proyecto1.dto.request.EmployeeRequest;
import gt.edu.umg.proyecto1.dto.response.EmployeeResponse;
import gt.edu.umg.proyecto1.mapper.EmployeeMapper;
import gt.edu.umg.proyecto1.model.EmployeeModel;
import gt.edu.umg.proyecto1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getAllEmployees() {

        List<EmployeeModel> employees = employeeRepository.findAll();

        return employees.stream().map(employeeMapper::toDto).toList();
    }

    public String createEmployee(EmployeeRequest employeeRequest){
        try {

            employeeRepository.save(employeeMapper.toEntity(employeeRequest));

            return "Empleado creado correctamente";
        }catch (Exception e){
            return "Empleado no creado" + e.getMessage();
        }

    }


}