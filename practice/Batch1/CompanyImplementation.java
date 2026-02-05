package practice.Batch1;

import java.util.Arrays;
import java.util.Scanner;

// Company Interface
interface Company {
    void assignSalaries(int[] salaries);
    double averageSalary();
    int maxSalary();
    int minSalary();
}

// EngineerFirm Class
class EngineerFirm implements Company {
    private String firmName;
    private int[] income;
    private int employeeCount;
    
    public EngineerFirm(String firmName, int employeeCount) {
        this.firmName = firmName;
        this.employeeCount = employeeCount;
        this.income = new int[employeeCount];
    }
    
    @Override
    public void assignSalaries(int[] salaries) {
        if (salaries == null || salaries.length == 0) {
            System.out.println("No salaries to assign.");
            return;
        }
        
        if (salaries.length != employeeCount) {
            System.out.println("Error: Number of salaries (" + salaries.length + 
                             ") does not match employee count (" + employeeCount + ")");
            return;
        }
        
        // Copy salaries to income array
        for (int i = 0; i < salaries.length; i++) {
            income[i] = salaries[i];
        }
        
        System.out.println("Salaries assigned successfully for " + employeeCount + 
                          " engineers at " + firmName);
    }
    
    @Override
    public double averageSalary() {
        if (employeeCount == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int salary : income) {
            sum += salary;
        }
        
        double average = (double) sum / employeeCount;
        System.out.println("Average Engineer Salary at " + firmName + ": $" + 
                          String.format("%.2f", average));
        return average;
    }
    
    @Override
    public int maxSalary() {
        if (employeeCount == 0) {
            System.out.println("No employees to calculate maximum salary.");
            return 0;
        }
        
        int max = income[0];
        for (int salary : income) {
            if (salary > max) {
                max = salary;
            }
        }
        
        System.out.println("Maximum Engineer Salary at " + firmName + ": $" + max);
        return max;
    }
    
    @Override
    public int minSalary() {
        if (employeeCount == 0) {
            System.out.println("No employees to calculate minimum salary.");
            return 0;
        }
        
        int min = income[0];
        for (int salary : income) {
            if (salary < min) {
                min = salary;
            }
        }
        
        System.out.println("Minimum Engineer Salary at " + firmName + ": $" + min);
        return min;
    }
    
    public void displaySalaries() {
        System.out.println("\n=== " + firmName + " - Engineer Salaries ===");
        for (int i = 0; i < income.length; i++) {
            System.out.println("Engineer " + (i + 1) + ": $" + income[i]);
        }
        System.out.println("=".repeat(50));
    }
    
    public String getFirmName() {
        return firmName;
    }
    
    public int[] getIncome() {
        return income.clone();
    }
    
    public int getEmployeeCount() {
        return employeeCount;
    }
}

// AccountantFirm Class
class AccountantFirm implements Company {
    private String firmName;
    private int[] income;
    private int employeeCount;
    
    public AccountantFirm(String firmName, int employeeCount) {
        this.firmName = firmName;
        this.employeeCount = employeeCount;
        this.income = new int[employeeCount];
    }
    
    @Override
    public void assignSalaries(int[] salaries) {
        if (salaries == null || salaries.length == 0) {
            System.out.println("No salaries to assign.");
            return;
        }
        
        if (salaries.length != employeeCount) {
            System.out.println("Error: Number of salaries (" + salaries.length + 
                             ") does not match employee count (" + employeeCount + ")");
            return;
        }
        
        // Copy salaries to income array
        for (int i = 0; i < salaries.length; i++) {
            income[i] = salaries[i];
        }
        
        System.out.println("Salaries assigned successfully for " + employeeCount + 
                          " accountants at " + firmName);
    }
    
    @Override
    public double averageSalary() {
        if (employeeCount == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int salary : income) {
            sum += salary;
        }
        
        double average = (double) sum / employeeCount;
        System.out.println("Average Accountant Salary at " + firmName + ": $" + 
                          String.format("%.2f", average));
        return average;
    }
    
    @Override
    public int maxSalary() {
        if (employeeCount == 0) {
            System.out.println("No employees to calculate maximum salary.");
            return 0;
        }
        
        int max = income[0];
        for (int salary : income) {
            if (salary > max) {
                max = salary;
            }
        }
        
        System.out.println("Maximum Accountant Salary at " + firmName + ": $" + max);
        return max;
    }
    
    @Override
    public int minSalary() {
        if (employeeCount == 0) {
            System.out.println("No employees to calculate minimum salary.");
            return 0;
        }
        
        int min = income[0];
        for (int salary : income) {
            if (salary < min) {
                min = salary;
            }
        }
        
        System.out.println("Minimum Accountant Salary at " + firmName + ": $" + min);
        return min;
    }
    
    public void displaySalaries() {
        System.out.println("\n=== " + firmName + " - Accountant Salaries ===");
        for (int i = 0; i < income.length; i++) {
            System.out.println("Accountant " + (i + 1) + ": $" + income[i]);
        }
        System.out.println("=".repeat(50));
    }
    
    public String getFirmName() {
        return firmName;
    }
    
    public int[] getIncome() {
        return income.clone();
    }
    
    public int getEmployeeCount() {
        return employeeCount;
    }
}

// Main Class
public class CompanyImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== COMPANY IMPLEMENTATION SYSTEM ===\n");
        
        // ========== ENGINEER FIRM DEMONSTRATION ==========
        System.out.println("========== ENGINEER FIRM ==========\n");
        
        // Create EngineerFirm
        EngineerFirm techCorp = new EngineerFirm("TechCorp Engineering", 5);
        
        // Assign salaries to engineers
        System.out.println("Example 1: Assign Salaries to Engineers");
        int[] engineerSalaries = {85000, 92000, 78000, 95000, 88000};
        techCorp.assignSalaries(engineerSalaries);
        System.out.println();
        
        // Display all engineer salaries
        techCorp.displaySalaries();
        System.out.println();
        
        // Calculate average salary
        System.out.println("Example 2: Calculate Average Engineer Salary");
        techCorp.averageSalary();
        System.out.println();
        
        // Find maximum salary
        System.out.println("Example 3: Find Maximum Engineer Salary");
        techCorp.maxSalary();
        System.out.println();
        
        // Find minimum salary
        System.out.println("Example 4: Find Minimum Engineer Salary");
        techCorp.minSalary();
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== ACCOUNTANT FIRM DEMONSTRATION ==========
        System.out.println("========== ACCOUNTANT FIRM ==========\n");
        
        // Create AccountantFirm
        AccountantFirm financeGroup = new AccountantFirm("Finance Group LLP", 6);
        
        // Assign salaries to accountants
        System.out.println("Example 5: Assign Salaries to Accountants");
        int[] accountantSalaries = {72000, 68000, 81000, 75000, 79000, 70000};
        financeGroup.assignSalaries(accountantSalaries);
        System.out.println();
        
        // Display all accountant salaries
        financeGroup.displaySalaries();
        System.out.println();
        
        // Calculate average salary
        System.out.println("Example 6: Calculate Average Accountant Salary");
        financeGroup.averageSalary();
        System.out.println();
        
        // Find maximum salary
        System.out.println("Example 7: Find Maximum Accountant Salary");
        financeGroup.maxSalary();
        System.out.println();
        
        // Find minimum salary
        System.out.println("Example 8: Find Minimum Accountant Salary");
        financeGroup.minSalary();
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== COMPARISON ==========
        System.out.println("========== FIRM COMPARISON ==========\n");
        
        System.out.println("Example 9: Compare Both Firms");
        double engineerAvg = techCorp.averageSalary();
        double accountantAvg = financeGroup.averageSalary();
        System.out.println();
        
        if (engineerAvg > accountantAvg) {
            System.out.println("Engineers at " + techCorp.getFirmName() + 
                              " earn more on average ($" + String.format("%.2f", engineerAvg - accountantAvg) + 
                              " difference)");
        } else if (accountantAvg > engineerAvg) {
            System.out.println("Accountants at " + financeGroup.getFirmName() + 
                              " earn more on average ($" + String.format("%.2f", accountantAvg - engineerAvg) + 
                              " difference)");
        } else {
            System.out.println("Both firms have the same average salary");
        }
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== MULTIPLE FIRMS ==========
        System.out.println("========== MULTIPLE FIRMS DEMONSTRATION ==========\n");
        
        // Create another engineer firm
        EngineerFirm innovationLab = new EngineerFirm("Innovation Lab", 4);
        int[] innovationSalaries = {98000, 105000, 92000, 88000};
        innovationLab.assignSalaries(innovationSalaries);
        System.out.println();
        
        // Create another accountant firm
        AccountantFirm auditPro = new AccountantFirm("AuditPro Associates", 3);
        int[] auditSalaries = {85000, 90000, 82000};
        auditPro.assignSalaries(auditSalaries);
        System.out.println();
        
        // Display statistics for all firms
        System.out.println("=== All Firms Statistics ===\n");
        
        Company[] companies = {techCorp, financeGroup, innovationLab, auditPro};
        String[] companyNames = {
            techCorp.getFirmName(),
            financeGroup.getFirmName(),
            innovationLab.getFirmName(),
            auditPro.getFirmName()
        };
        
        for (int i = 0; i < companies.length; i++) {
            System.out.println("Firm " + (i + 1) + ": " + companyNames[i]);
            companies[i].averageSalary();
            companies[i].maxSalary();
            companies[i].minSalary();
            System.out.println();
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== ERROR HANDLING ==========
        System.out.println("========== ERROR HANDLING ==========\n");
        
        // Test with mismatched salary count
        System.out.println("Example 10: Mismatched Salary Count");
        EngineerFirm testFirm = new EngineerFirm("Test Engineering", 5);
        int[] wrongSalaries = {80000, 85000, 90000}; // Only 3 salaries for 5 employees
        testFirm.assignSalaries(wrongSalaries);
        System.out.println();
        
        // Test with null salaries
        System.out.println("Example 11: Null Salaries");
        testFirm.assignSalaries(null);
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== INTERACTIVE MODE ==========
        System.out.println("========== INTERACTIVE MODE ==========\n");
        
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Engineer Firm");
            System.out.println("2. Create Accountant Firm");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.println();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter firm name: ");
                    String engFirmName = scanner.nextLine();
                    System.out.print("Enter number of engineers: ");
                    int engCount = scanner.nextInt();
                    scanner.nextLine();
                    
                    EngineerFirm userEngFirm = new EngineerFirm(engFirmName, engCount);
                    
                    System.out.println("Enter salaries for " + engCount + " engineers:");
                    int[] engSal = new int[engCount];
                    for (int i = 0; i < engCount; i++) {
                        System.out.print("Engineer " + (i + 1) + " salary: $");
                        engSal[i] = scanner.nextInt();
                    }
                    scanner.nextLine();
                    
                    System.out.println();
                    userEngFirm.assignSalaries(engSal);
                    System.out.println();
                    userEngFirm.displaySalaries();
                    System.out.println();
                    userEngFirm.averageSalary();
                    userEngFirm.maxSalary();
                    userEngFirm.minSalary();
                    System.out.println();
                    break;
                    
                case 2:
                    System.out.print("Enter firm name: ");
                    String accFirmName = scanner.nextLine();
                    System.out.print("Enter number of accountants: ");
                    int accCount = scanner.nextInt();
                    scanner.nextLine();
                    
                    AccountantFirm userAccFirm = new AccountantFirm(accFirmName, accCount);
                    
                    System.out.println("Enter salaries for " + accCount + " accountants:");
                    int[] accSal = new int[accCount];
                    for (int i = 0; i < accCount; i++) {
                        System.out.print("Accountant " + (i + 1) + " salary: $");
                        accSal[i] = scanner.nextInt();
                    }
                    scanner.nextLine();
                    
                    System.out.println();
                    userAccFirm.assignSalaries(accSal);
                    System.out.println();
                    userAccFirm.displaySalaries();
                    System.out.println();
                    userAccFirm.averageSalary();
                    userAccFirm.maxSalary();
                    userAccFirm.minSalary();
                    System.out.println();
                    break;
                    
                case 3:
                    running = false;
                    System.out.println("Thank you for using Company Implementation System!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        
        scanner.close();
    }
}
