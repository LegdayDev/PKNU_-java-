package ch06.sec06.exam02;

public class Korean {
    String nation = "대한민국";
    String name;
    String ssn;

    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public Korean() {
        System.out.println("Default Constructor call");
    }
}
