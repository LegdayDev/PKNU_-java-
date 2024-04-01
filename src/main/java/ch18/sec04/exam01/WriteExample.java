package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        try {
            FileWriter wr = new FileWriter("./src/main/resources/test.txt");

            char a = 'A';
            wr.write(a);
            char b = 'B';
            wr.write(b);

            char[] arr = {'C', 'D', 'E'};
            wr.write(arr);

            wr.write("FGH");
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
