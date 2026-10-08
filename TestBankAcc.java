import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccount() {
        System.out.println("Account details:");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder: " + accountHolderName);
        System.out.printf("Balance: %.2f%n", checkBalance());
    }
}

public class TestBankAcc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account =
                new BankAccount(accountNumber, accountHolderName, initialBalance);

        System.out.print("Enter deposit amount: ");
        account.deposit(scanner.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        account.withdraw(scanner.nextDouble());

        account.displayAccount();
        scanner.close();
    }
}