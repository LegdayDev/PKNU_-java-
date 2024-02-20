package ch06.sec06.exam04;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car(); // 기본생성자 호출
        System.out.println("car1.company = " + car1.company);

        Car car2 = new Car("자가용"); // 파라미터 1개 생성자 호출
        System.out.println("car2.company = " + car2.company);
        System.out.println("car2.model = " + car2.model);
        System.out.println();

        Car car3 = new Car("자가용", "빨강"); // 파라미터 2개 생성자 호출
        System.out.println("car3.company = " + car3.company);
        System.out.println("car3.model = " + car3.model);
        System.out.println("car3.color = " + car3.color);
        System.out.println();

        Car car4 = new Car("택시", "검정", 200); // 파라미터 3개 생성자 호출
        System.out.println("car4.company = " + car4.company);
        System.out.println("car4.model = " + car4.model);
        System.out.println("car4.color = " + car4.color);
        System.out.println("car4.maxSpeed = " + car4.maxSpeed);
    }
}
