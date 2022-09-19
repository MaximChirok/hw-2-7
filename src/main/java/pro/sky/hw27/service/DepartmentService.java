package pro.sky.hw27.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.hw27.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMaxSalaryFromDepartment (int department) {


        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment()==department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);


    }



    public Employee findMinSalaryFromDepartment (int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment()==department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }



    public List<Employee> findEmployeesFromDepartment (int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.toList());
    }



    public Map<Integer, List<Employee>> findEmployees() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }







}
