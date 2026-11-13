package EX3;

public class JulietteAndRomeoJob implements Runnable {

    private final Account account;
    private final String name;

    public JulietteAndRomeoJob(Account account, String name) {
        this.account = account;
        this.name = name;
    }

    public void doWithdraw(int amount) {
        synchronized (account) {
            if (account.getBalance() >= amount) {
                System.out.println(name + " consulte le compte : " + account.getBalance() + " €");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                account.withdraw(amount);
                System.out.println(name + " a retiré " + amount + " €, solde du compte : " + account.getBalance() + " €");
            } else {
                System.out.println(name + " solde insuffisant (" + account.getBalance() + " €)");
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            doWithdraw(10);
        }
    }

    public static void main(String[] args) {
        Account account = new Account();

        JulietteAndRomeoJob romeoJob = new JulietteAndRomeoJob(account, "romeo");
        JulietteAndRomeoJob julietteJob = new JulietteAndRomeoJob(account, "juliette");

        Thread romeo = new Thread(romeoJob, "romeo");
        Thread juliette = new Thread(julietteJob, "juliette");

        romeo.start();
        juliette.start();
    }
}