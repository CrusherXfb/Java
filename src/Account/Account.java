package Account;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class BankAccountManager {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        Random random = new Random();
        String[] names = {"Алиса", "Борис", "Александр", "Дмитрий", "Евгения", "Фёдор", "Григорий", "Владимир"};

        for (String name : names) {
            double balance = random.nextDouble() * 10000;
            accounts.add(new Account(name, Math.round(balance * 100.0) / 100.0));
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new AccountUpdater(accounts)).start();
        }
    }
}

class AccountUpdater implements Runnable {
    private List<Account> accounts;
    private Random random = new Random();
    private DecimalFormat df = new DecimalFormat("#.##");

    public AccountUpdater(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        while (true) {
            Account account = getRandomAccount();
            double amount = (random.nextDouble() - 0.5) * 1000;
            amount = Math.round(amount * 100.0) / 100.0;

            synchronized (account) {
                double newBalance = account.getBalance() + amount;
                newBalance = Math.round(newBalance * 100.0) / 100.0;

                System.out.println("[" + Thread.currentThread().getName() + "]" + (amount > 0 ? " Пополнение " : " Списание со ") + "счёта клиента " + account.getName() + (amount > 0 ? " на " : " в размере ") + df.format(Math.abs(amount)) + ". Баланс: " + df.format(newBalance));
                account.setBalance(newBalance);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Account getRandomAccount() {
        return accounts.get(random.nextInt(accounts.size()));
    }
}
