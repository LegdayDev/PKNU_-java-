package thread;

public class ThreadV3 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : Thread Start !!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " : Thread Stop !!");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadV3());
            thread.start();

            thread.join();
        }
    }
}
