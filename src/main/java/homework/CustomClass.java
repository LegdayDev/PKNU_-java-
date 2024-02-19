package homework;

public class CustomClass {
    int id;
    String name;
    int age;
    ProductClass[] basket = new ProductClass[10]; // 상품(ProductClass)를 담기위한 배열

    int basketSize = 0; // 장바구니 배열의 첫번쨰 인덱스로 초기화

    public CustomClass(int id, String name, int age, int range) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void customInfo() {
        System.out.printf("회원번호 : %d, 회원이름 : %s, 나이 : %d \n", id, name, age);
    }

    public void addToCart(ProductClass product, int quantity) {
        if (basketSize >= basket.length) { // 장바구니가 가득찻는지 체크
            System.out.println("장바구니가 가득찼습니다.");
            return;
        }

        if (product.checkToQuantity(quantity)) {
            System.out.printf("현재 구매가 불가능합니다. 구입 가능 수량은 %d 입니다", product.quantity);
        } else {
            product.quantity -= quantity; // 재고수량 감소

            basket[basketSize++] = new ProductClass(product.id, product.name, product.price, quantity); //구매수량까지 띄우기 위해 새로운 객체 생성
            
            System.out.printf("나이가 %d살인 %s가 %d 짜리 %s를 %d개를 장바구니에 담았습니다\n",this.age, this.name, product.price, product.name, quantity);
        }
    }

    public void purchase() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
               break;
            }
            System.out.println(this.name + "고객님이 " + basket[i].name + "를" + basket[i].quantity+"개를 구매하셨습니다.");
        }
    }
}
