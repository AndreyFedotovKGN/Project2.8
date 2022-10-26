package pro.sky.java.course2.project_2_8.employeeService;

import pro.sky.java.course2.project_2_8.employee.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int office, int salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> allEmployee();
}
