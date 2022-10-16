package pro.sky.java.course2.project_2_8.employeeService;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.project_2_8.employee.Employee;
import pro.sky.java.course2.project_2_8.exeption.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;

@Service
    public class EmployeeServiceImpl implements EmployeeService {
        private final List<Employee> employees;

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
        @Override
        public Employee getLowestPaidEmployee(int office) {
            return employees.stream()
                    .filter(e -> e.getOffice() == office)
                    .min(Comparator.comparingInt(e -> e.getSalary()))
                    .orElseThrow(() -> new RuntimeException());
        }

        @Override
        public Employee getHighestPaidEmployee(int office) {
            return employees.stream()
                    .filter(e -> e.getOffice() == office)
                    .max(Comparator.comparingInt(e -> e.getSalary()))
                    .orElseThrow(() -> new RuntimeException());
        }

    @Override
        public List<Employee> printEmployeesForDepartment(int office) {
            return employees.stream()
                    .filter(e -> e.getOffice() == office)
                    .collect(Collectors.toList());
    }

        @Override
        public List<Employee> printEmployeesByDepartments() {
            return Collections.unmodifiableList(employees.stream()
                    .sorted(Comparator.comparingInt(e -> e.getOffice()))
                    .collect(Collectors.toList()));
        }

        @Override
        public List<Employee> printEmployees() {
            return Collections.unmodifiableList(employees);
        }
}
