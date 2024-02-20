package thread;

public class ThreadV1 {
    public static void main(String[] args) {
        Thread tc = Thread.currentThread();
        System.out.println(tc.getName());
        new TEs().print();
    }
}
