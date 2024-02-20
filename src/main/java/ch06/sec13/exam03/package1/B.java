package ch06.sec13.exam03.package1;

public class B {
    public void mehtod(){
        A a = new A();

        a.field1 = 1;
        a.field2 = 1;
//        a.field3 = 1; // private 접근불가

        a.method1();
        a.method2();
//        a.method3(); // private 접근불가
    }
}
