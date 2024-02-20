package ch02;

public class BooleanExample {
    public static void main(String[] args) {
        boolean stop = true;
        if (stop) {
            System.out.println("중지합니다.");
        } else {
            System.out.println("시작합니다.");
        }

        int x = 10;
        boolean result1 = (x == 200);
        boolean result2 = (x != 200);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
