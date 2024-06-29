import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
public class Task3 {
    private BankAccount account;
    private Scanner scanner;
    public Task3(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount. Please try again.");
        }
    }
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }
    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your current balance is: " + balance);
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0); 
        Task3 atm = new Task3(account);
        atm.start();
    }
}


