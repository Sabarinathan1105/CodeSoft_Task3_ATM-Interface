import java.util.Scanner;

public class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void displayMenu() {
        System.out.println("ATM INTERFACE");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Invalid withdrawal amount. Please enter a positive value.");
                    } else if (amount > balance) {
                        System.out.println("Insufficient balance");
                    } else {
                        balance -= amount;
                        System.out.println("Withdrawal successful. Your new balance is: " + balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Invalid deposit amount. Please enter a positive value.");
                    } else {
                        balance += amount;
                        System.out.println("Deposit successful. Your new balance is: " + balance);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        atm.run();
    }
}