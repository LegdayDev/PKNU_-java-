package homework.exam02;

public class EBookClass extends BookClass{
    private String superDevices; //호환 기기

    public EBookClass(String title, String author, int price, String publisher, String superDevices) {
        super(title, author, price, publisher);
        this.superDevices = superDevices;
    }

    public String getSuperDevices() {
        return superDevices;
    }

    public void deviceInfo(){
        super.bookInfo();
        System.out.println("호환 가능한 기기는 " + superDevices);
        System.out.println("---------------------");
    }
}
