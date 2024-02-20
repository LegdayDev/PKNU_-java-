package ch14.sec05.exam02;

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start(); // 실행 대기상태
        try {
            sumThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1 ~ 100 까지의 합 : " + sumThread.getSum());
    }
}
