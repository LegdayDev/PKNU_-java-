package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.tire = new Tire(); // 일반 타이어 장착
        myCar.run();

        myCar.tire= new HankookTire(); // 한국 타이어 장착
        myCar.run();

        myCar.tire = new KumhoTire(); // 금호 타이어 장착
        myCar.run();
    }
}
