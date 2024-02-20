package thread.thread4_2;

class MyClass {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public void getCount() {
        System.out.println("count = " + count);
    }
}

public class ThreadV4_2 {
    public static void main(String[] args) throws InterruptedException {
        MyClass myClass = new MyClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    myClass.increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    myClass.decrement();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        myClass.getCount();
    }
}