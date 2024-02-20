package ch09.sec05.exam01;

public class A {
    int field1;

    void method1() {
    }

    static int field2;

    static void method2() {
    }

    class B {
        void mehtod() {
            field1 = 10;
            mehtod();

            field2 = 10;
            method2();
        }
    }

    static class C {
        void method() {
            field2 = 10;
            method2();
        }
    }
}
