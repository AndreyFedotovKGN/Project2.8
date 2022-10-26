package pro.sky.java.course2.project_2_8.employeeService;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.project_2_8.employee.Employee;
import pro.sky.java.course2.project_2_8.exeption.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;

@Service
    public class EmployeeServiceImpl implements EmployeeService {
        protected final List<Employee> employees;

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }


    @Override
        public Employee addEmployee(String firstName, String lastName, int office, int salary) {
            Employee employee = new Employee(firstName, lastName, office, salary);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.add(employee);
            return employee;
        }

        @Override
        public Employee removeEmployee(String firstName, String lastName) {
            Employee employee = findEmployee(firstName,lastName);
            employees.remove(employee);
            return employee;
        }

        public Employee findEmployee(String firstName, String lastName) {
            final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findAny();
            return employee.orElseThrow(() -> new RuntimeException());
        }

        @Override
        public Collection<Employee> allEmployee() {
            return Collections.unmodifiableList(employees);
        }


}
