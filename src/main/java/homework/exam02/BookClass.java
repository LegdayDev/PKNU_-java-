package homework.exam02;

public class BookClass {
    private String title;
    private String author;
    private int price;
    private String publisher;
    private float tax = 1.1f;

    public BookClass(String title, String author, int price, String publisher) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getTax() {
        return tax;
    }

    public String getTitle() {
        return title;
    }

    public void bookInfo(){
        System.out.println("책 제목 : " + title);
        System.out.println("저자 : " + author);
        System.out.println("가격 : " + price);
        System.out.println("공급자 : " + publisher);
    }
}
