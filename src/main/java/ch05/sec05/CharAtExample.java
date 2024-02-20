package ch05.sec05;

import java.util.Scanner;

public class CharAtExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("주민등록 번호를 입력해주세요 >> ");
        String code = sc.nextLine();

        switch (code.charAt(6)) {
            case '1', '3' -> System.out.println("남자입니다.");
            case '2', '4' -> System.out.println("여자입니다.");
            default -> System.out.println("사람이 아닙니다.");
        }
        sc.close();
    }
}
