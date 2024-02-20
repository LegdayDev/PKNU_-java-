package thread.thread4_1;


public class ThreadV4_1 {
    static int count = 0;

    static void increment(){count++;}
    static void decrement(){count--;}
    static void getCount(){
        System.out.println("count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                decrement();
            }
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        getCount();
    }
}

