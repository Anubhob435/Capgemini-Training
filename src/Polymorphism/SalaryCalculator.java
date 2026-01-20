package src.Polymorphism;

import java.util.*;


public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // n would be defined or prompted based on requirements
        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the employee id");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter the employee name");
            String name = sc.nextLine();

            System.out.println("1. Permanent Employee");
            System.out.println("2. Payroll Employee");
            System.out.println("Choose the option");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the basic salary");
                    double salary = sc.nextDouble();
                    PermanentEmployee pe = new PermanentEmployee(id, name, salary);
                    employees[i] = pe;
                    break;
                }
                case 2: {
                    System.out.println("Enter the hours");
                    int hours = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the rate");
                    double rate = sc.nextDouble();
                    sc.nextLine();

                    PayRollEmployee payemp = new PayRollEmployee(id, name, hours, rate);
                    employees[i] = payemp;
                    break;
                }
            }
        }

        // Final output loop to demonstrate polymorphism
        System.out.println("\n--- Processing Employee Payroll ---");
        for (Employee emp : employees) {
            if (emp != null) {
                emp.displayDetails();
                System.out.println("Calculated Salary: " + emp.calculateSalary());
                System.out.println("-------------------------");
            }
        }
        sc.close();
    }
}