package Main;

import Entity.Employee;
import Service.EmployeeService;

import java.util.Scanner;

public class Main {
    //Basically, first I declared employeeService globally (as a field in the class) so that I can use it anywhere in that class.
    //Then I created the actual EmployeeService object inside main() and passed it into the constructor of Main, which assigns it to the global variable (this.employeeService).
    //Now, I can use that object (employeeService) anywhere inside the Main class.
    // In spring @Autowired does all these things
    private final EmployeeService employeeService ;

    Main(EmployeeService employeeService) {
        this.employeeService = employeeService;// Dependency Injection
    }

    public void run() {

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println(
                    """
                            1.Add Employee\s
                            2.Delete Employee
                            3.Update Employee
                            4.List of Employees"""
            );
            System.out.println("Enter your choice :");
            int choice = s.nextInt();

            switch (choice) {
                case 1 -> {
                    int empId;
                    String empName;
                    String branch;
                    double salary;
                    while (true) {
                        System.out.println("Enter a Id for Employee :");
                        empId = s.nextInt();
                        if (empId >= 100 && empId <= 999) {
                            break;

                        } else {
                            System.out.println("Invalid Id, Enter a valid ID !!! ");
                        }
                    }

                    while (true) {
                        System.out.println("Enter Employee Name :");
                        empName = s.next();
                        if (empName.matches("[a-zA-Z]")) {
                            break;
                        } else {
                            System.out.println("Invalid Name, Enter a valid Name !!! ");
                        }
                    }
                    while (true) {
                        System.out.println("Enter Employee Branch :");
                        branch = s.next();
                        if (empName.matches("[a-zA-Z]")) {
                            break;
                        } else {
                            System.out.println("Invalid Branch, Enter a valid Branch !!! ");
                        }
                    }
                    while (true) {
                        System.out.println("Enter a Salary for Employee :");
                        salary = s.nextInt();
                        if (salary >= 10000 && salary <= 99999) {
                            break;

                        } else {
                            System.out.println("Invalid Salary, Enter a valid Salary !!! ");
                        }
                    }
                    Employee emp = new Employee(empId, empName, branch, salary);
                    employeeService.createEmployee(emp);
                }

                case 2 -> {
                    System.out.println("Enter the employee Id to delete :");
                    int empId = s.nextInt();
                    employeeService.deleteEmployeeById(empId);

                }
                case 3 -> {
                    while (true) {
                        System.out.print("Enter your ID to update Employee: ");
                        int empId = s.nextInt();
                        s.nextLine(); // clear buffer

                        System.out.println("What do you want to update?");
                        System.out.println("""
                1. Update Name
                2. Update Branch
                3. Update Salary
                4. Back to Main Menu
                """);

                        int update = s.nextInt();
                        s.nextLine(); // clear buffer
                        String fieldName = null;
                        if(update == 1) fieldName = "empName";
                        if(update == 2) fieldName = "branch";
                        if(update == 3) fieldName = "salary";

                        switch (update) {
                            case 1 -> {
                                System.out.print("Enter your new Name: ");
                                String newName = s.nextLine();
                                employeeService.updateEmployee(empId, fieldName, newName);
                                break;
                            }
                            case 2 -> {
                                System.out.print("Enter your new Branch: ");
                                String newBranch = s.nextLine();
                                employeeService.updateEmployee(empId, fieldName, newBranch);
                                break;
                            }
                            case 3 -> {
                                System.out.print("Enter your new Salary: ");
                                double newSalary = s.nextDouble();
                                s.nextLine(); // clear buffer
                                employeeService.updateEmployee(empId, fieldName, String.valueOf(newSalary));
                                break;
                            }
                            case 4 -> {
                                System.out.println("Returning to main menu...");
                                run();
                            }
                            default -> System.out.println("Invalid option. Try again.");
                        }
                    }
                }

                case 4 -> {
                    employeeService.employeeList();

                }
            }
        }
    }

            public static void main (String[]args){
                EmployeeService service = new EmployeeService();
                Main m = new Main(service);
                m.run();
            }
        }

