package ch04.sec03;

public class SwitchValueExample {
    public static void main(String[] args) {
        String grade = "B";

        int score = 0;
        switch (grade) {
            case "A":
                score = 100;
                break;
            case "B":
                score = 80;
                break;
            default:
                score = 60;
        }

        System.out.println("score = " + score);

        // Java 12 부터 가능
        score = switch (grade){
            case "A" -> 100;
            case "B" -> 80;
            default -> 60;
        };

        System.out.println("score = " + score);
    }
}
