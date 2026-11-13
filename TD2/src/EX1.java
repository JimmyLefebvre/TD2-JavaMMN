class Lettres implements Runnable  {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
    }
}

class Nombres implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 26; i++) {
            System.out.print(i + " ");
        }
    }
}

public class EX1 {
    static void main(String[] args) {
        Thread t1 = new Thread(new Lettres());
        Thread t2 = new Thread(new Nombres());
        t1.start();
        t2.start();
        System.out.println();
    }
}