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

    public BookClass purchase(){
        return null;
    }
}
