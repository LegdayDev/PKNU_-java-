package ch07.sec05.exam02;

public class SportCar extends Car {

    @Override
    public void speedUp() {
        speed += 10;
    }

    /* final 이 붙은 메서드는 오버라이딩이 안된다.
    @Override
    public void stop() {
        System.out.println("스포츠카를 멈춤");
        speed = 0;
    }*/
}
