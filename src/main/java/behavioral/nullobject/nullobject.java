package behavioral.nullobject;

import java.lang.reflect.Proxy;

interface Log {

    void info(String msg);
    void warn(String msg);

}

class ConsoleLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }
}

class NullLog implements Log {

    @Override
    public void info(String msg) {

    }

    @Override
    public void warn(String msg) {

    }
}

class BankAccount {

    private Log log;
    private int balance;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {

        balance += amount;

        log.info("Deposited " + amount );
    }
}

class NullObjectDemo {

    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[] { itf },
                (proxy, method, args) -> {
                    if(method.getReturnType().equals(Void.TYPE))
                        return null;
                    else
                        return method.getReturnType().getConstructor().newInstance();
                }
        );
    }

    public static void main(String[] args) {

        ConsoleLog log = new ConsoleLog();
        BankAccount account = new BankAccount(null);

        Log log1 = new NullLog();
        BankAccount account1 = new BankAccount(log1);

        // elegant solution
        Log log2 = noOp(Log.class);
        BankAccount account2 = new BankAccount(log2);
        //

        account.deposit(100);
        account1.deposit(100);
        account2.deposit(100);
    }
}
