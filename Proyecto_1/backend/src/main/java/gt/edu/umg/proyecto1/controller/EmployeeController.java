package gt.edu.umg.proyecto1.controller;

import gt.edu.umg.proyecto1.dto.request.EmployeeRequest;
import gt.edu.umg.proyecto1.dto.response.EmployeeResponse;
import gt.edu.umg.proyecto1.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public String addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

}
