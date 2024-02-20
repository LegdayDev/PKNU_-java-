package ch06.sec08.exam02;

public class ComputerExample {
    public static void main(String[] args) {
        Computer myCom = new Computer();

        int result1 = myCom.sum(1, 2, 3, 4);
        System.out.println("1 부터 4 까지 합 = " + result1);

        int result2 = myCom.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("1 부터 10 까지 합 = " + result2);

        int[] values = {1, 2, 3};
        int result3 = myCom.sum(values);
        System.out.println("1 부터 3 을 가지는 배열의 원소 합 = " + result3);

        int result4 = myCom.sum(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("메서드 호출과 동시에 배열선언 후 파라미터 전달 합 : " + result4);
    }
}
