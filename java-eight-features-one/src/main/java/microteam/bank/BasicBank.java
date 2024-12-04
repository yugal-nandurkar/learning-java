package microteam.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicBank {
    static class Account {
        private int accountNumber;
        private String accountHolder;
        private double balance;

        public Account(int accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }
    }

    private static List<Account> accounts = new ArrayList<Account>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bank Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                viewAccounts();
            } else if (choice == 3) {
                deposit();
            } else if (choice == 4) {
                withdraw();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        accounts.add(new Account(accountNumber, accountHolder, balance));
        System.out.println("Account created successfully.");
    }

    private static void viewAccounts() {
        System.out.println("Accounts:");
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Account Holder: " + account.getAccountHolder() +
                    ", Balance: " + account.getBalance());
        }
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }
}

