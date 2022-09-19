package pro.sky.hw27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw27.model.Employee;
import pro.sky.hw27.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {



    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }





    @GetMapping("/max-salary")
    public Employee findMaxSalaryFromDepartment (@RequestParam("departmentId") int department) {
return departmentService.findMaxSalaryFromDepartment(department);
    }



    @GetMapping("/min-salary")
    public Employee findMinSalaryFromDepartment (@RequestParam("departmentId") int department) {
        return departmentService.findMinSalaryFromDepartment(department);
    }


    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartment (@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesFromDepartment(department);
    }


    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployees();
    }



}
