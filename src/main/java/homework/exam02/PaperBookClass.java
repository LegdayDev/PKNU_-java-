package homework.exam02;

public class PaperBookClass extends BookClass {
    private int size; // 책 페이지

    public PaperBookClass(String title, String author, int price, String publisher, int size) {
        super(title, author, price, publisher);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void sizeInfo() {
        System.out.println("책 제목 : " + super.getTitle());
        System.out.println("저자 : " + super.getAuthor());
        System.out.println("가격 : " + super.getPrice());
        System.out.println("공급자 : " + super.getPublisher());
        System.out.println("책 페이지는 총 : " + size + "쪽 입니다.");
        System.out.println("---------------------");
    }

}
