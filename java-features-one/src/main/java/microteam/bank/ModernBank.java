package microteam.bank;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ModernBank {
    // Thread-safe storage for accounts using ConcurrentHashMap
    private static final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Menu
            System.out.println("""
                Bank Menu:
                1. Create Account
                2. View Accounts
                3. Deposit
                4. Withdraw
                5. Parallel Operations
                6. Exit
                """);
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createAccount(scanner);
                case 2 -> viewAccounts();
                case 3 -> deposit(scanner);
                case 4 -> withdraw(scanner);
                case 5 -> runParallelOperations();
                case 6 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        executorService.shutdown();
        scanner.close();
    }

    // Account class (Concise and readable)
    public static class Account {
        private final int accountNumber;
        private final String accountHolder;
        private double balance;

        public Account(int accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }

        public synchronized void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public synchronized void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public synchronized double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "accountNumber=" + accountNumber +
                    ", accountHolder='" + accountHolder + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }

    // Create account (Reusability and maintainability)
    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        // Add to thread-safe map
        accounts.put(accountNumber, new Account(accountNumber, accountHolder, initialBalance));
        System.out.println("Account created successfully.");
    }

    // View accounts (Readable and productive)
    private static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        accounts.values().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .forEach(System.out::println);
    }

    // Deposit (Testable and maintainable)
    private static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw (Concurrent and testable)
    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Parallel operations (Callable and concurrent)
    private static void runParallelOperations() {
        System.out.println("Running parallel operations...");

        // Simulate parallel deposits
        List<Runnable> tasks = accounts.values().stream()
                .map(account -> (Runnable) () -> account.deposit(100))
                .collect(Collectors.toList());

        tasks.forEach(executorService::execute);

        // View updated balances
        executorService.execute(() -> {
            try {
                Thread.sleep(1000); // Simulate delay
                viewAccounts();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
