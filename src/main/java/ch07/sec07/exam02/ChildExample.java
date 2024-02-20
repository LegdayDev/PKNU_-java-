package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();

        Parent parent = child; // 업캐스팅

        parent.method1();
        parent.method2();
    }
}
