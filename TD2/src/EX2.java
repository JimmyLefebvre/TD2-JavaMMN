import java.util.Random;

public class EX2 implements Runnable {
    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(rand.nextInt(201));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EX2 job = new EX2();

        Thread t1 = new Thread(job);
        Thread t2 = new Thread(job);
        Thread t3 = new Thread(job);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}