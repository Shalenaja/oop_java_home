package oop_java_home_7;

import java.util.Objects;

public class Employee {
    
    private final String name;    
    String department;
    Double salary;

   
    public Employee(String name, String department, double salary) {
        this.name = name;     
        this.department = department;
        this.salary = salary;
    }

    @Override 
    public String toString() {   
        return "[" + name + "]";
    }

    public String getName() {   
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;
        return name == employee.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
