package ch09.sec02.exam01;

public class A {
    class B { }

    B field = new B(); // 필드를 초기화하면서 객체 B 대입

    A(){ // 생성자
        B b = new B();
    }

    void method(){
        B b = new B();
    }
}
