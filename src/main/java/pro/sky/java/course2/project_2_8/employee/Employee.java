package pro.sky.java.course2.project_2_8.employee;

import java.util.Objects;

public class Employee {
        private final String firstName;
        private final String lastName;
        private int office;
        private int salary;

    public Employee(String firstName, String lastName, int office, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getOffice() {
        return office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return office == employee.office && salary == employee.salary && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, office, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", office=" + office +
                ", salary=" + salary +
                '}';
    }
}

