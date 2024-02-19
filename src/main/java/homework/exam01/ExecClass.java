package homework.exam01;

/**
 * <h2>추석과제</h2>
 */
public class ExecClass {
    public static void main(String[] args) {
        /* 1. 회원 등록 */
        CustomClass c1 = new CustomClass(7, "Ronaldo", 38, 10);
        CustomClass c2 = new CustomClass(10, "Messi", 35, 10);
        CustomClass c3 = new CustomClass(1, "최재영", 28, 10);

        System.out.println("=========== 고객정보 ===========");
        c1.customInfo();
        c2.customInfo();
        c3.customInfo();
        System.out.println();

        /* 2. 상품 등록 */
        ProductClass p1 = new ProductClass(1, "먹태깡", 1000, 100);
        ProductClass p2 = new ProductClass(2, "콜라", 2000, 500);
        ProductClass p3 = new ProductClass(3, "천하장사", 800, 1000);
        ProductClass p4 = new ProductClass(4, "빼빼로", 1500, 300);
        ProductClass p5 = new ProductClass(5, "사이다", 2000, 500);

        System.out.println("=========== 주문 전 상품 정보 ===========");
        p1.productInfo();
        p2.productInfo();
        p3.productInfo();
        p4.productInfo();
        p5.productInfo();
        System.out.println();

        /* c1 고객 장바구니에 상품을 담는다 */
        c1.addToCart(p1, 1);
        c1.addToCart(p2, 2);
        c1.addToCart(p3, 2);
        c1.addToCart(p4, 2);
        c1.addToCart(p5, 2);

        // 장바구니에 담은 후 최종 결제
        c1.purchase();
        System.out.println();

        /* c2 고객 장바구니에 상품을 담는다 */
        c2.addToCart(p1, 10);
        c2.addToCart(p2, 20);
        c2.addToCart(p3, 30);
        c2.addToCart(p4, 40);
        c2.addToCart(p5, 50);

        // 장바구니에 담은 후 최종 결제
        c2.purchase();
        System.out.println();

//         c3 고객 장바구니에 상품을 담는다
        c3.addToCart(p1, 10);
        c3.addToCart(p2, 20);
        c3.addToCart(p3, 30);
        c3.addToCart(p4, 40);
        c3.addToCart(p5, 50);

        // 장바구니에 담은 후 최종 결제
        c3.purchase();
        System.out.println();

        System.out.println();
        System.out.println("=========== 주문 완료 후 상품 정보 ===========");
        p1.productInfo();
        p2.productInfo();
        p3.productInfo();
        p4.productInfo();
        p5.productInfo();
    }
}
