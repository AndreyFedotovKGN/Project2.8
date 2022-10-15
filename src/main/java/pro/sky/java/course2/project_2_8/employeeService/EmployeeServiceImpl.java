package pro.sky.java.course2.project_2_8.employeeService;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.project_2_8.employee.Employee;
import pro.sky.java.course2.project_2_8.exeption.EmployeeAlreadyAddedException;
import pro.sky.java.course2.project_2_8.exeption.EmployeeNotFoundException;

import java.util.*;

    @Service
    public class EmployeeServiceImpl implements EmployeeService {
        private final Map<String, Employee> employees;

        public EmployeeServiceImpl() {
            this.employees = new HashMap<>();
        }

        @Override
        public Employee addEmployee(String firstName, String lastName, int office, int salary) {
            Employee employee = new Employee(firstName, lastName, office, salary);
            if (employees.containsKey(employee.getFullName())) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.put(employee.getFullName(),employee);
            return employee;
        }

        @Override
        public Employee removeEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(employee.getFullName())) {
                return employees.remove(employee.getFullName());
            }
            throw new EmployeeNotFoundException();
        }

        @Override
        public Employee findEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(employee.getFullName())) {
                return employees.get(employee.getFullName());
            }
            throw new EmployeeNotFoundException();
        }

        @Override
        public Collection<Employee> allEmployee() {
            return Collections.unmodifiableCollection(employees.values());
        }

}
