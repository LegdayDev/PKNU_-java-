package ch02;

public class LongExample {
    public static void main(String[] args) {
        long var1 = 10;
        long var2 = 20L;
//        long var3 = 1000000000000; 컴파일러가 int 로 간주, L 이나 l을 붙혀줘야 한다.
        long var4 = 1000000000000L;
        long var5 = 1000000000000L;
        if(var4 == var5){
            System.out.println("같다");
        }else{
            System.out.println("같지않다.");
        }

        System.out.println("var1 = " + var1);
        System.err.println("var2 = " + var2);
        System.out.println("var4 = " + var4);
    }
}
