package ch05.sec05;

public class SubStringExample {
    public static void main(String[] args) {
        String code = "970327-1234567";

        String frontCode = code.substring(0, 6);
        String lastCode = code.substring(7);

        System.out.println("주민 앞자리 : " +frontCode);
        System.out.println("주민 뒷자리 : " +lastCode);
    }
}
