package pro.sky.java.course2.project_2_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.project_2_8.employee.Employee;
import pro.sky.java.course2.project_2_8.employeeService.EmployeeService;

import java.util.Collection;

@RequestMapping("/employee/")
@RestController
public class EmployeeController {

        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService service) {
            this.employeeService = service;
        }

        @GetMapping("add")
        public Object addEmployee(@RequestParam(name = "firstName", required = false) String firstName,
                                  @RequestParam(name = "lastName", required = false) String lastName,
                                  @RequestParam(name = "office") int office,
                                  @RequestParam(name = "salary") int salary) {
            Employee employee = null;
            try {
                employee = employeeService.addEmployee(firstName, lastName, office, salary);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping("remove")
        public Object removeEmployee(@RequestParam(name = "firstName", required = false) String firstName,
                                     @RequestParam(name = "lastName", required = false) String lastName) {
            Employee employee = null;
            try {
                employee = employeeService.removeEmployee(firstName, lastName);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping("find")
        public Object findEmployee(@RequestParam(name = "firstName", required = false) String firstName,
                                   @RequestParam(name = "lastName", required = false) String lastName) {

            Employee employee = null;
            try {
                employee = employeeService.findEmployee(firstName, lastName);
            } catch (Throwable throwable) {
                return throwable.getMessage();
            }
            return employee;
        }

        @GetMapping
        public Collection<Employee> allEmployees() {
            return employeeService.allEmployee();
        }

    }