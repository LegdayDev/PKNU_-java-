package ch07.sec03.exam01;

public class SmartPhoneExample {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("아이폰", "스페이스 블랙");

        int a =3;
        System.out.println("a = " + a);

        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);


        System.out.println();
    }
}
