package ch04.sec02;

public class IfExample {
    public static void main(String[] args) {
        int score = 30;

        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A 입니다.");
        } else if (score < 90 && score >= 80) {
            System.out.println("점수가 90보다 작고 80보다 큽니다.");
            System.out.println("등급은 B 입니다.");
        } else if (score < 80 && score >= 70) {
            System.out.println("정수가 80보다 작고 70보다 큽니다.");
            System.out.println("등급은 C 입니다.");
        } else if (score < 70 && score >= 60) {
            System.out.println("점수가 70보다 작습니다.");
            System.out.println("등급은 D 입니다.");
        } else {
            System.out.println("학사경고 입니다.");
        }
    }
}
