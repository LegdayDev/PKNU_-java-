package ch07.sec06.package1;

public class B {
    public void method(){
        A a = new A(); // protected 는 같은 패키지 접근가능
        a.field = "value"; // protected 필드기 때문에 같은패키지에서 접근가능
        a.method(); // protected 메서드기 때문에 접근가능
    }
}
