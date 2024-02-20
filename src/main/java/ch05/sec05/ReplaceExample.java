package ch05.sec05;

public class ReplaceExample {
    public static void main(String[] args) {
        String oldStr = "Cristiano Ronaldo";
        String newStr = oldStr.replace("Cristiano", "King God");
        System.out.println("oldStr = " + oldStr);
        System.out.println("newStr = " + newStr);
    }
}
