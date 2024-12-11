package bank;

//package microteam.bank;

import microteam.bank.ModernBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class ModernBankTest {

    private Map<Integer, ModernBank.Account> accounts;

    @BeforeEach
    void setUp() {
        // Initialize a new ConcurrentHashMap for each test
        accounts = new ConcurrentHashMap<>();
        ModernBank.Account account1 = new ModernBank.Account(1, "John Doe", 500);
        ModernBank.Account account2 = new ModernBank.Account(2, "Jane Doe", 1000);
        accounts.put(account1.getAccountNumber(), account1);
        accounts.put(account2.getAccountNumber(), account2);
    }

    @Test
    void testAccountCreation() {
        ModernBank.Account account = new ModernBank.Account(3, "Alice", 200);
        assertEquals(3, account.getAccountNumber());
        assertEquals("Alice", account.getAccountHolder());
        assertEquals(200, account.getBalance());
    }

    @Test
    void testDeposit() {
        ModernBank.Account account = accounts.get(1);
        assertNotNull(account);

        account.deposit(100);
        assertEquals(600, account.getBalance());

        account.deposit(-50); // Invalid deposit
        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdraw() {
        ModernBank.Account account = accounts.get(2);
        assertNotNull(account);

        account.withdraw(500);
        assertEquals(500, account.getBalance());

        account.withdraw(1000); // Overdraft attempt
        assertEquals(500, account.getBalance());

        account.withdraw(-100); // Invalid withdrawal
        assertEquals(500, account.getBalance());
    }

    @Test
    void testConcurrentDeposits() throws InterruptedException {
        ModernBank.Account account = accounts.get(1);
        assertNotNull(account);

        // Simulate concurrent deposits
        Thread thread1 = new Thread(() -> account.deposit(100));
        Thread thread2 = new Thread(() -> account.deposit(200));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertEquals(800, account.getBalance());
    }

    @Test
    void testParallelOperations() throws InterruptedException {
        // Initialize an executor and add tasks for parallel deposits
        ModernBank.Account account1 = accounts.get(1);
        ModernBank.Account account2 = accounts.get(2);

        Thread thread1 = new Thread(() -> account1.deposit(50));
        Thread thread2 = new Thread(() -> account2.deposit(100));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertEquals(550, account1.getBalance());
        assertEquals(1100, account2.getBalance());
    }
}
