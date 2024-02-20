package ch04.sec05;

public class PrintFromTo10Example {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            if (i == 10) {
                System.out.println(i);
            } else {
                System.out.print(i + ", ");
            }
            i++;
        }

        for(int j=0;j<10;j++){
            System.out.print((j+1) + " ");
        }
    }
}
