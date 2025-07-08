import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            System.out.println("❌ Invalid withdrawal amount.");
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM interface
class ATM {
    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // Show menu and perform actions
    public void start() {
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Your Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("🙏 Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
}

// Main class to run the ATM
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance ₹1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
