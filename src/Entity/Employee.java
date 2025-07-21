package Entity;

public class Employee {
    private int empId;
    private String empName;
    private String branch;
    private double salary;

    public Employee(int empId, String empName, String branch, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.branch = branch;
        this.salary = salary;
    }

    public Employee() {

    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getBranch() {
        return branch;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", branch='" + branch + '\'' +
                ", salary=" + salary +
                '}';
    }
}
