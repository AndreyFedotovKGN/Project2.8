package pro.sky.java.course2.project_2_8.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.project_2_8.employee.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceOffice {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeServiceOffice(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public Employee getLowestPaidEmployee(int office) {
        return employeeServiceImpl.employees.stream()
                .filter(e -> e.getOffice() == office)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException());
    }


    public Employee getHighestPaidEmployee(int office) {
        return employeeServiceImpl.employees.stream()
                .filter(e -> e.getOffice() == office)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException());
    }


    public List<Employee> printEmployeesForOffice(int office) {
        return employeeServiceImpl.employees.stream()
                .filter(e -> e.getOffice() == office)
                .collect(Collectors.toList());
    }


    public List<Employee> printEmployeesByOffice() {
        return Collections.unmodifiableList(employeeServiceImpl.employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getOffice()))
                .collect(Collectors.toList()));
    }


    public List<Employee> printEmployees() {
        return (List<Employee>) employeeServiceImpl.allEmployee().
                stream().collect(Collectors.groupingBy(Employee::getOffice));
    }
}

