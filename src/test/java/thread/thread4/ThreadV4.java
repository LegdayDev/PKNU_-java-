package thread.thread4;

class MyClass {
    private int count;

    public synchronized void increment() { count++; }

    public synchronized void decrement() {
        count--;
    }

    public void getCount() {
        System.out.println("count = " + count);
    }
}

class ThreadImpl1 implements Runnable {
    private MyClass myClass;

    public ThreadImpl1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            myClass.increment();
        }
    }
}

class ThreadImpl2 implements Runnable {
    private MyClass myClass;

    public ThreadImpl2(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            myClass.decrement();
        }
    }
}

public class ThreadV4 {
    public static void main(String[] args){
        MyClass myClass = new MyClass();

        Thread thread1 = new Thread(new ThreadImpl1(myClass));
        Thread thread2 = new Thread(new ThreadImpl2(myClass));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        myClass.getCount();
    }
}

