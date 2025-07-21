package Service;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import Entity.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void createEmployee(Employee employee){
        int empId = employee.getEmpId();
        if(employeeDao.getEmployeeById(empId) != null ){
            throw new RuntimeException("Employee Already Exist !!!");
        }
        else{
            employeeDao.createEmployee(employee);
            System.out.println("Employee created successfully");

        }
    }
    public void getEmployeeById(int empId){
         employeeDao.getEmployeeById(empId);

    }
    public void deleteEmployeeById(int empId){
        if(employeeDao.getEmployeeById(empId) != null){
            employeeDao.deleteEmployeeById(empId);
            System.out.println("Employee deleted successfully");
        }
        else{
            throw new RuntimeException("Employee Not Exists !!!");
        }
    }
    public void employeeList(){
       List<Employee> employees = employeeDao.employeeList();
       if(employees != null) {
           System.out.println(employees);
       }
       else {
           System.out.println("No Students are Available !!!!");
       }
    }
    public void updateEmployee(int empId, String fieldName, String newValue){
        if(employeeDao.getEmployeeById(empId) != null) {
            employeeDao.updateEmployee( empId,  fieldName,  newValue);
           }
        else{
            System.out.println("Invalid Employee ID !!!!");
        }
        }
    }

