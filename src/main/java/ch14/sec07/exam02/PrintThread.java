package ch14.sec07.exam02;

public class PrintThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("실행 중");
                Thread.sleep(100); // 스레드가 일시 정지 하므로 InterruptedException 발생 !!
            }
        } catch (InterruptedException e) {
            System.err.println("PrintThread error : " + e.getMessage());
        }
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
