package pro.sky.java.course2.project_2_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.project_2_8.employee.Employee;
import pro.sky.java.course2.project_2_8.employeeService.EmployeeServiceOffice;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final EmployeeServiceOffice employeeServiceOffice;

    public OfficeController(EmployeeServiceOffice employeeServiceOffice) {
        this.employeeServiceOffice = employeeServiceOffice;
    }

    @GetMapping(path = "/max-salary")
    public Employee getHighestPaidEmployee(
            @RequestParam(value = "office") int office) {
        Employee employee = null;
        employee = employeeServiceOffice.getHighestPaidEmployee(office);
        return employee;
    }

    @GetMapping(path = "/min-salary")
    public Employee getLowestPaidEmployee(
            @RequestParam(value = "office") int office) {
        Employee employee = null;
        employee = employeeServiceOffice.getLowestPaidEmployee(office);
        return employee;
    }

    @GetMapping(path = "/office/all", params = "officeId")
    public Employee printEmployeesForOffice(
            @RequestParam(value = "officeId") int officeId) {
        List<Employee> employees = null;
        employees = employeeServiceOffice.printEmployeesForOffice(officeId);
        return (Employee) employees;
    }

    @GetMapping(path = "/all")
    public Employee printEmployeesByOffice() {
        List<Employee> employees = null;
        employees = employeeServiceOffice.printEmployeesByOffice();
        return (Employee) employees;
    }
}
