package ch06.sec11.exam01;

public class KoreanExample {
    public static void main(String[] args) {
        Korean k1 = new Korean("123456-1234567", "김자바");

        System.out.println("k1.nation = " + k1.nation);
        System.out.println("k1.ssn = " + k1.ssn);
        System.out.println("k1.name = " + k1.name);
        System.out.println(k1.toString());

        k1.name = "김자바";
//        k1.nation = "일본"; final 필드는 변경 불가
//        k1.ssn = "1234": final 필드는 변경 불가
    }
}
