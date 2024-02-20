package homework.exam02;

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

            int selectCase = sc.nextInt();
            sc.nextLine();

            switch (selectCase) {
                case 1 -> {
                    System.out.print("전자책은 1번, 종이책은 2번을 입력해주세요 >> ");
                    int bookType = sc.nextInt();
                    sc.nextLine();

                    saveBook(sc, bookType, bookList);
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("찾으시는 책 제목또는 저자를 입력해주세요 >> ");
                    String keyword = sc.nextLine();

                    BookClass book = searchBook(keyword, bookList);
                    if (book == null) System.out.println("찾으시는 책이 없습니다.");
                    else {
                        System.out.println("<<<<<< 찾으시는 책은 아래와 같습니다 >>>>>>");
                        bookInfo(book);
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("삭제할 책 제목을 입력해주세요 >> ");
                    String title = sc.nextLine();

                    BookClass book = findBook(title, bookList);
                    if (book == null) System.out.println("찾으시는 책이 없습니다.");
                    else bookList.remove(book);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("<<<<<<<<<<<< 전체 책 목록 >>>>>>>>>>>>");
                    for (BookClass book : bookList) {
                        bookInfo(book);
                    }
                    System.out.println();
                }
                case 5 -> { // 도서 구입
                    System.out.print("구입 하실 책 제목을 알려주세요 >> ");
                    String title = sc.nextLine();
                    System.out.print("종이책과 전자책중 고르세요 >> ");
                    String bookType = sc.nextLine();

                    BookClass book = purchaseBook(bookType, title, bookList);

                    if (book == null) System.out.println("구매 하실 책이 존재하지 않습니다 !!");
                    else bookList.remove(book);

                    System.out.println();
                }
            }

            if (selectCase == 0) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }
        }
        sc.close();
    }

    private static void saveBook(Scanner sc, int type, List<BookClass> bookList) {
        if (type != 1 && type != 2) {
            System.out.println("등록하시는 책은 프로그램에서 지원하지 않습니다.");
            return;
        }
        BookClass book = inputBook(sc);
        if (type == 1) { // 전자책
            System.out.print("호환기기를 입력하세요 : ");
            String superDevices = sc.nextLine();
            EBookClass eBookClass = new EBookClass(book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher(), superDevices);
            bookList.add(eBookClass);
            System.out.println("책 저장이 완료 되었습니다 !!");
        } else if (type == 2) { // 종이책
            System.out.print("쪽수 입력하세요 : ");
            int size = sc.nextInt();
            sc.nextLine();
            bookList.add(new PaperBookClass(book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher(), size));
            System.out.println("책 저장이 완료 되었습니다 !!");
        }
    }

    private static BookClass searchBook(String keyword, List<BookClass> bookList) {
        for (BookClass book : bookList) {
            if (book.getTitle().equals(keyword) || book.getAuthor().equals(keyword)) {
                return book;
            }
        }
        return null;
    }

    private static BookClass findBook(String title, List<BookClass> bookList) {
        for (BookClass book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    private static void bookInfo(BookClass book) {
        if (book instanceof EBookClass eBook) eBook.deviceInfo();
        else if (book instanceof PaperBookClass paperBook) paperBook.sizeInfo();
    }

    private static BookClass purchaseBook(String bookType, String title, List<BookClass> bookList) {
        if (bookType.equals("전자책")) {
            for (BookClass b : bookList) {
                if (b.getTitle().equals(title) && b instanceof EBookClass eBook) {
                    return eBook.purchase();
                }
            }
        } else if (bookType.equals("종이책")) {
            for (BookClass b : bookList) {
                if (b.getTitle().equals(title) && b instanceof PaperBookClass paperBook) {
                    return paperBook.purchase();
                }
            }
        }
        return null;
    }

    private static BookClass inputBook(Scanner sc) {
        System.out.print("제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();
        System.out.print("가격를 입력하세요 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("발행자를 입력하세요 : ");
        String publisher = sc.nextLine();

        return new BookClass(title, author, price, publisher);
    }
}
