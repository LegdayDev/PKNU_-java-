package ch04.sec07;

public class BreakExample {
    public static void main(String[] args) {
        while (true) {
            int randomNum = (int) (Math.random() * 6) + 1;
            if (randomNum == 6) {
                System.out.println("현재 번호는 " + randomNum + "번입니다, 프로그램을 종료합니다");
                break;
            } else {
                System.out.println("현재 번호는 " + randomNum + "번 입니다.");
            }
        }
    }
}
