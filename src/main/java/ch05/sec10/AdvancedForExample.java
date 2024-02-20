package ch05.sec10;

public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 87};
        int sum = 0;
        double ave;

        for (int score : scores) {
            sum += score;
        }

        for (int i = 0; i < scores.length; i++) {
            sum+=scores[i];
        }

        ave = (double) sum / scores.length;

        System.out.println("점수 총합 = " + sum);
        System.out.printf("점수 평균 = %.2f",ave);
    }
}
