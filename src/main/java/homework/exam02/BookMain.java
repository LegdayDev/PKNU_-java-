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
                    
                    if (bookType == 1) { // 전자책이라면
                        saveEBook(sc, bookList);
                    } else if (bookType == 2) { // 종이책이라면
                        savePaperBook(sc, bookList);
                    }
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
                    
                    BookClass book = findBook(title, bookList);
                    if (book == null) System.out.println("구매 하실 책이 존재하지 않습니다 !!");
                    else buyTheBook(book);
                    bookList.remove(book); // 구매했으니 도서목록에서 삭제
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

    // 종이책 저장을 위한 메서드
    private static void savePaperBook(Scanner sc, List<BookClass> bookList) {
        BookClass book = inputBook(sc);
        System.out.print("쪽수 입력하세요 : ");
        int size = sc.nextInt();
        sc.nextLine();
        bookList.add(new PaperBookClass(book.getTitle(),book.getAuthor(),book.getPrice(),book.getPublisher(), size));
        System.out.println("책 저장이 완료 되었습니다 !!");
    }

    // 전자책 저장을 위한 메서드
    private static void saveEBook(Scanner sc, List<BookClass> bookList) {
        BookClass book = inputBook(sc);
        System.out.print("호환기기를 입력하세요 : ");
        String superDevices = sc.nextLine();
        EBookClass eBookClass = new EBookClass(book.getTitle(),book.getAuthor(),book.getPrice(),book.getPublisher(), superDevices);
        bookList.add(eBookClass);
        System.out.println("책 저장이 완료 되었습니다 !!");
    }

    // 책 제목 or 책 저자가 찾는 키워드와 같으면 객체 반환
    private static BookClass searchBook(String keyword, List<BookClass> bookList) {
        for (BookClass book : bookList) {
            if (book.getTitle().equals(keyword) || book.getAuthor().equals(keyword)) {
                return book;
            }
        }
        return null; // 찾지 못했을 경우 null 
    }

    // 책 제목을 검색하여 책을 반환
    private static BookClass findBook(String title, List<BookClass> bookList) {
        for (BookClass book : bookList) {
            if (book.getTitle().equals(title)) { // 책 제목과 찾는책 제목이 같다면 객체 반환
                return book;
            }
        }
        return null; // 찾지 못했을 경우 null 
    }

    // 종이책인지 전자책인지 구분하여 각 책의 정보를 출력
    private static void bookInfo(BookClass book) {
        if (book instanceof EBookClass eBook) eBook.deviceInfo();
        else if (book instanceof PaperBookClass paperBook) paperBook.sizeInfo();
    }

    // 책 구입을 위한 메서드
    private static void buyTheBook(BookClass book) {
        if (book instanceof EBookClass eBook) { //전자책이라면
            float totalPrice = eBook.getPrice() * eBook.getTax();
            System.out.printf("%s 전자책을 %.1f 원에 구매하셨습니다! 호환기기는 %s 입니다.",eBook.getTitle(),totalPrice,eBook.getCompatibleDevices());
        } else if (book instanceof PaperBookClass paperBook) { //종이책이라면
            float totalPrice = paperBook.getPrice() * paperBook.getTax();
            System.out.printf("%s 종이책을 %.1f 원에 구매하셨습니다! 쪽수는 %d 쪽입니다.",paperBook.getTitle(),totalPrice,paperBook.getSize());
        }
    }

    /**
     * 반복하는 코드 메서드 추출
     * @param sc
     * @return
     */
    private static BookClass inputBook(Scanner sc){
        System.out.print("제목을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();
        System.out.print("가격를 입력하세요 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("발행자를 입력하세요 : ");
        String publisher = sc.nextLine();

        return new BookClass(title,author,price,publisher);
    }
}
