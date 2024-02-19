package homework;

public class ProductClass {
    public int id;
    public String name;
    public int price;
    public int quantity;

    public ProductClass(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void productInfo() {
        System.out.printf("상품명 : %s, 가격 : %d, 수량 : %d \n", name, price, quantity);
    }

    public boolean checkToQuantity(int quantity) {
        return quantity > this.quantity ? true : false; // 구매가 불가능하면 true 반환
    }
}
