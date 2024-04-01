package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReamExample {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream("./src/main/resources/test03.db");

            while (true) {
                int data = is.read();
                if (data == -1) break;
                System.out.print((char)data);
            }

            is.close();
        } catch (IOException e) {
        }
    }
}
