package thread;

public class ThreadV2 extends Thread{
    @Override
    public void run() {
        System.out.println(getName() + " thread start !!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " thread stop !!");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new ThreadV2();
            t.start();

            try {
                t.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
