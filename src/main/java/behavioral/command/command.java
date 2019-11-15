package behavioral.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BankAccount {

    private int balance;
    private int overdraftLimit = -500;

    public boolean deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
        return true;
    }

    public boolean withdraw(int amount){
        if(balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdraw " + amount + ", balance is now " + balance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}

interface Command {
    void call();
    void undo();
}

class BankAccountCommand implements Command {

    public enum Action {
        DEPOSIT, WITHDRAW
    }

    private BankAccount account;
    private Action action;
    private int amount;
    private boolean succeeded;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                succeeded = account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if(!succeeded) return;
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }
}

class CommandDemo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<BankAccountCommand> commands = Arrays.asList(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        );

        commands.forEach(c -> {
            c.call();
            System.out.println(ba);
        });
        commands.forEach(c -> {
            c.undo();
            System.out.println(ba);
        });
    }
}



