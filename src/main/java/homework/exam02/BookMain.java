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

            int inputData = sc.nextInt(); // 선택한 숫자
            sc.nextLine(); // 버퍼 비우기

            switch (inputData) {
                case 1 -> { // 도서 등록(전자책 or 종이책)
                    System.out.print("전자책은 1번, 종이책은 2번을 입력해주세요 >> ");
                    int bookType = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    saveBook(sc,bookType,bookList);
                    System.out.println();
                }
                case 2 -> { // 도서 검색(책 제목 or 책 저자)
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
                case 3 -> { // 도서 삭제
                    System.out.print("삭제할 책 제목을 입력해주세요 >> ");
                    String title = sc.nextLine();

                    BookClass book = findBook(title, bookList);
                    if (book == null) System.out.println("찾으시는 책이 없습니다.");
                    else bookList.remove(book);
                    System.out.println();
                }
                case 4 -> { // 책 목록 전체 출력
                    System.out.println("<<<<<<<<<<<< 책목록 >>>>>>>>>>>>");
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

                    BookClass book = buyTheBook(bookType, title, bookList);

                    if (book == null) System.out.println("구매 하실 책이 존재하지 않습니다 !!");
                    else bookList.remove(book);

                    System.out.println();
                }
            }

            if (inputData == 0) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }
        }
        sc.close();
    }

    /**
     * <h1>책 저장 메서드</h1>
     * 입력을 위한 Scanner 와 전자책인지 종이책인지 구분할 type, List 타입의 bookList 를 파라미터로 받는다.
     * <li>case 1 번에서 사용</li>
     */
    private static void saveBook(Scanner sc, int type, List<BookClass> bookList) {
        BookClass book = inputBook(sc);
        if (type == 1) { // 전자책
            System.out.print("쪽수 입력하세요 : ");
            int size = sc.nextInt();
            sc.nextLine();
            bookList.add(new PaperBookClass(book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher(), size));
            System.out.println("책 저장이 완료 되었습니다 !!");
        } else if (type == 2) { // 종이책
            System.out.print("호환기기를 입력하세요 : ");
            String superDevices = sc.nextLine();
            EBookClass eBookClass = new EBookClass(book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher(), superDevices);
            bookList.add(eBookClass);
            System.out.println("책 저장이 완료 되었습니다 !!");
        }
    }

    /**
     * <h1>책 단권 검색 메서드</h1>
     * 검색할 책 제목인 keyword , List 타입의 bookList를 파라미터로 받는다.
     * <li>case 2 번에서 사용</li>
     */
    private static BookClass searchBook(String keyword, List<BookClass> bookList) {
        for (BookClass book : bookList) {
            if (book.getTitle().equals(keyword) || book.getAuthor().equals(keyword)) {
                return book;
            }
        }
        return null;
    }

    /**
     * <h1>책 제목을 이용하여 검색하는 메서드</h1>
     * 책 제목인 title 와 List타입의 bookList를 파라미터로 받아 title을 가지는 객체를 찾아서 반환 못찾으면 null 반환
     * <li>case 3 번에서 사용</li>
     */
    private static BookClass findBook(String title, List<BookClass> bookList) {
        for (BookClass book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * <h1>자식타입 추론을 위한 메서드</h1>
     * 파라미터로 BookClass(부모타입) 참조변수를 받아 자식타입 비교후 자식타입의 정보를 출력
     * <li>case 2,4 번에서 사용</li>
     */
    private static void bookInfo(BookClass book) {
        if (book instanceof EBookClass eBook) eBook.deviceInfo();
        else if (book instanceof PaperBookClass paperBook) paperBook.sizeInfo();
    }

    /**
     * <h1>책 구입을 위한 메서드</h1>
     * 전자책인지 종이책인지 구분하는 bookType 와 책제목 title, List 타입의 bookList를 파라미터로 받아 각 종류마다 로직 실행
     * 반환은 해당 타입의 객체를 반환 구입할 책이 없다면 null 반환
     * <li>case 5 번에서 사용</li>
     */
    private static BookClass buyTheBook(String bookType, String title, List<BookClass> bookList) {
        if (bookType.equals("전자책")) {
            for (BookClass b : bookList) {
                if (b.getTitle().equals(title) && b instanceof EBookClass eBook) {
                    float totalPrice = eBook.getPrice() * eBook.getTax();
                    System.out.printf("%s 전자책을 %.1f 원에 구매하셨습니다! 호환기기는 %s 입니다.", eBook.getTitle(), totalPrice, eBook.getCompatibleDevices());
                    return eBook;
                }
            }
        } else if (bookType.equals("종이책")) {
            for (BookClass b : bookList) {
                if (b.getTitle().equals(title) && b instanceof PaperBookClass paperBook) {
                    float totalPrice = paperBook.getPrice() * paperBook.getTax();
                    System.out.printf("%s 종이책을 %.1f 원에 구매하셨습니다! 쪽수는 %d 쪽입니다.", paperBook.getTitle(), totalPrice, paperBook.getSize());
                    return paperBook;
                }
            }
        }
        return null;
    }

    /**
     * <h1>책 등록 시 공통 필드 입력받는 메서드</h1>
     * Scanner 를 파라미터로 받아 부모객체 필드를 입력받는 로직을 실행하고 입력값으로 부모타입의 객체를 생성 후 반환
     */
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
