package DAO;

import Entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public boolean createEmployee(Employee employee);
    public Employee getEmployeeById(int empId);
    public boolean deleteEmployeeById(int empId);
    public List<Employee> employeeList();
    public void updateEmployee(int empId, String filedName, String newValue);
}
