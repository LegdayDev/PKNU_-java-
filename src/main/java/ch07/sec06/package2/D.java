package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class D extends A {
    public D(){
        super(); // protected 는 상속받은 자식클래스에서 호출가능
    }

    public void method1(){
        this.field = "value"; // 자식 클래스기 때문에 수정가능
        this.method();
    }

    public void method2(){
//        A a = new A(); // 직접 객체 생성해서 사용하는 것은 안됨
//        a.field = "value"; // 직접 객체 생성이 불가능하기 때문에 인스턴스를 통해 접근 불가
//        a.method();
    }
}
