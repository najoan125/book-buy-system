package view;

import java.util.Scanner;

import dao.BookDAO;
import dao.Session;
import dto.BookDTO;

public class AddBookView {
	public AddBookView() {
		//책에 관련된 정보에 접근할 객체인 bdao 생성(책 관련된 기능들이 선언되어 있다.)
		BookDAO bdao = new BookDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("책 제목 : ");
		String book_title = sc.nextLine();
		System.out.print("책 가격 : ");
		int book_price = sc.nextInt();
		System.out.print("책 재고 : ");
		int book_inventory = sc.nextInt();
		System.out.print("책 작가 : ");
		sc = new Scanner(System.in);
		String book_author = sc.nextLine();
		System.out.print("책 출판사 : ");
		sc = new Scanner(System.in);
		String book_publisher = sc.nextLine();
		System.out.print("책 장르 : ");
		sc = new Scanner(System.in);
		String book_genre = sc.nextLine();
		System.out.print("책 출판 국가 : ");
		sc = new Scanner(System.in);
		String book_country = sc.nextLine();
		System.out.print("책 출판 년도 : ");
		sc = new Scanner(System.in);
		int book_publishyear = sc.nextInt();
		System.out.print("책 사용 언어 : ");
		sc = new Scanner(System.in);
		String book_language = sc.nextLine();
		
		
		//지금 추가중인 책의 상품번호는 현재 "추가되어 있는 book_id"+1로 설정해 주어야 한다.
		//bdao에 getLastNum()을 만들어서 리턴받고 +1 해준 것을 book_id로 사용한다.
		BookDTO book = new BookDTO(book_title, book_price,
				book_inventory, book_author, book_publisher, book_genre, book_country,
				book_publishyear, book_language);//올린 사람은 현재
		//								로그인 되어 있는 유저이므로 세션에서 아이디를 받아온 후 사용
		
		//포장이 끝났다면 bdao의 메소드에 객체 넘겨주기
		if(bdao.addBook(book)) {
			System.out.println(book_title + " 책이 추가되었습니다!");
		}
		else {
			System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
		}
	}
}














