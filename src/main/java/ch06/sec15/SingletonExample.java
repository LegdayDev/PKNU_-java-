package ch06.sec15;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if(s1==s2){ //동일성 비교
            System.out.println("같은 Singleton 객체이다.");
        }else{
            System.out.println("다른 Singleton 객체이다.");
        }
    }
}
