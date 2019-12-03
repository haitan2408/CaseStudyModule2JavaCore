package service.impl;

import models.Employee;
import service.FilingCabinetsService;

import java.util.Stack;

public class FilingCabinetsServiceImpl implements FilingCabinetsService {
    private static Stack<Employee> employees;

    static {
    employees=new Stack<>();
    employees.push(new Employee("001","Nguyen Hong Son",20,"Da Nang"));
    employees.push(new Employee("002","Nguyen Hong Son",20,"Da Nang"));
    employees.push(new Employee("003","Nguyen Hong Son",20,"Da Nang"));
    employees.push(new Employee("004","Nguyen Hong Son",20,"Da Nang"));
    employees.push(new Employee("005","Nguyen Hong Son",20,"Da Nang"));
    employees.push(new Employee("006","Nguyen Hong Son",20,"Da Nang"));
    employees.push(new Employee("007","Nguyen Hong Son",20,"Da Nang"));
    }

    @Override
    public Employee findEmployeeById(String id) {
        Stack<Employee> employees1=employees;
        while (true) {
            Employee employee=employees1.pop();
            if(employee==null) {
                break;
            }
            if(id.equals(employee.getIdEmployee())) {
                return employee;
            }
        }
        return null;
    }
}
