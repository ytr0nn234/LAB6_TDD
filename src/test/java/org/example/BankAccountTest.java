package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("ACC12345", "paul", 100);
    }

    // constructor tests //

    @Test
    void constructorInitialisation() {
        BankAccount acc = new BankAccount("ACC12345", "paul", 100);
        assertEquals("ACC12345", acc.getAccNo());
        assertEquals("paul", acc.getName());
        assertEquals(100, acc.getBalance());
    }

    @Test
    void constructorNegativeInitialisation() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("ACC12345", "paul", -100));
        assertEquals("Balance must be greater than 0", ex.getMessage());
    }


    //  deposit tests //

    @Test
    void depositPositiveIncreasesBalance() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void depositZeroThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));
        assertEquals("Deposit amount must be positive", ex.getMessage());
    }

    @Test
    void depositNegativeThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-10));
        assertEquals("Deposit amount must be positive", ex.getMessage());
    }


    // Withdraw tests  //

    @Test
    void withdrawPositiveDecreasesBalance() {
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void withdrawZeroThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0));
        assertEquals("Withdrawal amount must be positive", ex.getMessage());
    }

    @Test
    void withdrawNegativeThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-5));
        assertEquals("Withdrawal amount must be positive", ex.getMessage());
    }

    @Test
    void withdrawMoreThanBalanceThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(1000));
        assertEquals("Insufficient funds", ex.getMessage());
    }
}
