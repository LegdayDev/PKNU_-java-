package ch03.sec08;

public class BitLogicExample {
    public static void main(String[] args) {

        // 45 = 101101
        // 25 = 011001
        // 45 = 00101101
        //    = 11010010
        //    = 00101101
        //    = 00000001
        //~46 = 00101110 => -46
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
        System.out.println("================");

        byte receiveData = -120;

        int unsignedInt1 = receiveData & 255;
        System.out.println("unsignedInt1 = " + unsignedInt1);

        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println("unsignedInt2 = " + unsignedInt2);

        int test = 136;
        byte btest = (byte) test;
        System.out.println("btest = " + btest);
    }
}
