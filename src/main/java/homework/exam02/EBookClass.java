package homework.exam02;

public class EBookClass extends BookClass{
    private String compatibleDevices; //호환 기기

    public EBookClass(String title, String author, int price, String publisher, String superDevices) {
        super(title, author, price, publisher);
        this.compatibleDevices = superDevices;
    }

    public String getCompatibleDevices() {
        return compatibleDevices;
    }

    public void deviceInfo(){
        System.out.println("책 제목 : " + super.getTitle());
        System.out.println("저자 : " + super.getAuthor());
        System.out.println("가격 : " + super.getPrice());
        System.out.println("공급자 : " + super.getPublisher());
        System.out.println("호환 가능한 기기는 " + compatibleDevices);
        System.out.println("---------------------");
    }
}
