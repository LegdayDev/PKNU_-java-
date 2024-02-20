package ch05.sec04;

public class NulPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;

        String str = null;
        try {
            System.out.println("총 문자 수 : " + str.length());
        }catch (NullPointerException e){
            System.out.println("NullPointerException : " + e.getMessage());
        }
    }
}
