package ch09.sec02.exam01;

public class AExample {
    public static void main(String[] args) {
        A a = new A();

        A.B b = a.new B(); // A 객체를 생성해야 B 객체를 생성할 수 있다.

        a.method();
    }
}
