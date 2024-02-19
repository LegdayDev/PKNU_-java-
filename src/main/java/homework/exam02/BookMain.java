package homework.exam02;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BookClass> bookList = new ArrayList<>();

        while (true) {
            System.out.println("**** 메뉴 ****");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 확인");
            System.out.println("5. 도서 구입");
            System.out.println("0. 종료");
            System.out.print("번호를 선택하시오 >> ");

            int inputData = sc.nextInt(); // 선택한 숫자
            sc.nextLine();
            switch (inputData) {
                case 1 -> {
                    System.out.print("전자책은 1번, 종이책은 2번을 입력해주세요 >> ");
                    int isBook = sc.nextInt();
                    sc.nextLine();
                    if (isBook == 1) {
                        saveEBook(sc, bookList);
                    } else if (isBook == 2) {
                        savePaperBook(sc, bookList);
                    }
                }
                case 2 -> {
                    System.out.print("찾으시는 책 제목을 입력해주세요 >> ");
                    String findTitle = sc.nextLine();
                    BookClass emptyBook;

                    emptyBook = findBook(findTitle, bookList);
                    if (emptyBook == null) System.out.println("찾으시는 책이 없습니다.");
                    else {
                        System.out.println("<<<<<< 찾으시는 책은 아래와 같습니다 >>>>>>");
                        if (emptyBook instanceof EBookClass eBook) ((EBookClass) emptyBook).deviceInfo();
                        else if (emptyBook instanceof PaperBookClass paperBook) ((PaperBookClass) emptyBook).sizeInfo();
                    }
                }
                case 3 -> {
                    System.out.print("삭제할 책 제목을 입력해주세요 >> ");
                    String removeTitle = sc.nextLine();
                    BookClass findBook = findBook(removeTitle, bookList);
                    bookList.remove(findBook);
                }
                case 4 -> { // 책 목록 전체 출력
                    System.out.println("<<<<<< 책목록 >>>>>>");
                    for (BookClass bookClass : bookList) {
                        bookClass.bookInfo();
                    }
                }
                case 5 -> {
                    System.out.print("구입 하실 책 제목을 알려주세요 >> ");
                    String buyBookTitle = sc.nextLine();
                    BookClass buyBook = findBook(buyBookTitle, bookList);
                    buyTheBook(buyBook);
                }
            }
            if (inputData == 0) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }
        }
    }

    // 책 구입을 위한 메서드
    private static void buyTheBook(BookClass buyBook) {
        if (buyBook instanceof EBookClass eBook) { //전자책이라면
            System.out.println("책 제목 : " + eBook.getTitle());
            System.out.println("저자 : " + eBook.getAuthor());
            System.out.println("가격 : " + (eBook.getPrice() * eBook.getTax()) + "원");
            System.out.println("발행처 : " + eBook.getPublisher());
            System.out.println("호환 기기 : " + eBook.getSuperDevices());
            System.out.println("구입 완료 !!");
        } else if (buyBook instanceof PaperBookClass paperBook) {
            System.out.println("책 제목 : " + paperBook.getTitle());
            System.out.println("저자 : " + paperBook.getAuthor());
            System.out.println("가격 : " + (paperBook.getPrice() * paperBook.getTax()) + "원");
            System.out.println("발행처 : " + paperBook.getPublisher());
            System.out.println("호환 기기 : " + paperBook.getSize());
            System.out.println("구입 완료 !!");
        }
    }

    // 책 제목을 검색하여 책을 반환
    private static BookClass findBook(String findTitle, List<BookClass> bookList) {
        for (BookClass bookClass : bookList) {
            if (bookClass.getTitle().equals(findTitle)) {
                return bookClass;
            }
        }
        return null;
    }

    // 종이책 저장을 위한 메서드
    private static void savePaperBook(Scanner sc, List<BookClass> bookList) {
        System.out.print("제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();
        System.out.print("가격를 입력하세요 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("발행자를 입력하세요 : ");
        String publisher = sc.nextLine();
        System.out.print("쪽수 입력하세요 : ");
        int size = sc.nextInt();
        bookList.add(new PaperBookClass(title, author, price, publisher, size));
        sc.nextLine();
    }

    // 전자책 저장을 위한 메서드
    private static void saveEBook(Scanner sc, List<BookClass> bookList) {
        System.out.print("제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();
        System.out.print("가격를 입력하세요 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("발행자를 입력하세요 : ");
        String publisher = sc.nextLine();
        System.out.print("호환기기를 입력하세요 : ");
        String superDevices = sc.nextLine();
        bookList.add(new EBookClass(title, author, price, publisher, superDevices));
    }
}
