package ch14.sec07.exam02;

public class InterruptExample {
    public static void main(String[] args) {
        PrintThread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000); // 메인 스레드 1초간 멈춤
        }catch (InterruptedException e){}

        thread.interrupt();
    }
}
