package pro.sky.java.course2.project_2_8.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.project_2_8.employee.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceOffice extends EmployeeServiceImpl {


    public EmployeeServiceOffice(List<Employee> employees) {
        super(employees);
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

