package DAO;
import Database.DbConnection;
import Entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

//    private DbConncetion dbConncetion;
    @Override
    public boolean createEmployee(Employee employee) {
        String sql = "Insert into Employee(empId, empName, branch, salary) values(?,?,?,?)";
        try{

            Connection con = DbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,employee.getEmpId());
            stmt.setString(2,employee.getEmpName());
            stmt.setString(3,employee.getBranch());
            stmt.setDouble(4,employee.getSalary());
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public  Employee getEmployeeById(int empId){
         String sql = "Select * from Employee where empId = ?";

         try{
             Connection con = DbConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1,empId);
             ResultSet rs = stmt.executeQuery();
             Employee employee = new Employee();
             if(rs.next()){
                 employee.setEmpId(rs.getInt("empId"));
                 employee.setEmpName(rs.getString("empName"));
                 employee.setBranch(rs.getString("branch"));
                 employee.setSalary(rs.getDouble("salary"));
             }
             return employee;
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }
    public boolean deleteEmployeeById(int empId){
        String sql = "Delete from Employee where empId = ?";
        try{
            Connection con = DbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,empId);
            int rowsAffected = stmt.executeUpdate(); // returns how many rows were deleted
            return rowsAffected > 0; // true if at least one row was deleted

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> employeeList() {
        String sql = "Select * from Employee";
        List<Employee> employeeList = new ArrayList<>();
        try{
            Connection con = DbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("empId"));
                employee.setEmpName(rs.getString("empName"));
                employee.setBranch(rs.getString("branch"));
                employee.setSalary(rs.getDouble("salary"));
                employeeList.add(employee);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public void updateEmployee(int empId, String fieldName, String newValue) {

            String sql = "UPDATE Employee SET " + fieldName + " = ? WHERE empId = ?";

            try (Connection con = DbConnection.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql)) {

                // Set the appropriate data type based on the field
                if (fieldName.equals("salary")) {
                    stmt.setDouble(1, Double.parseDouble(newValue));
                } else {
                    stmt.setString(1, newValue);
                }

                stmt.setInt(2, empId);
                int rows = stmt.executeUpdate();

                if (rows > 0) {
                    System.out.println("Employee " + fieldName + " updated successfully.");
                } else {
                    System.out.println("Employee not found.");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

