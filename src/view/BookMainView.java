package view;

import java.util.Scanner;

import dao.BasketDAO;
import dao.BookDAO;
import dao.Session;
import dao.UserDAO;
import dto.BasketDTO;
import dto.OrdersDTO;

public class BookMainView {
	int book_id;

	public BookMainView(int book_id) {
		this.book_id = book_id;
		
		Scanner sc = new Scanner(System.in);
		BookDAO bdao = new BookDAO();
		UserDAO udao = new UserDAO();
		BasketDAO badao = new BasketDAO();
		int like = 0;
		while(true) {
			System.out.println(book_id+" 번 책의 메뉴입니다.");
			System.out.println("1. 좋아요 누르기\n2. 구매하기\n3. 책바구니에 담기\n4. 돌아가기");
			int choice = sc.nextInt();
			
			if(choice == 4) {
				break;
			}
			
			switch (choice) {
			case 1 :
				if(like>0){
					System.out.println("연속적으로 좋아요를 클릭하실수 없습니다.\n");
				} else if(bdao.clickLike(book_id)){
					System.out.println("좋아요를 클릭하셨습니다!\n");
					like++;
				} else {
					System.out.println("알수 없는 오류가 발생하였습니다. 다시 시도해주세요.");
				}
				break;
			case 2 :
				//책 구매
				new OrderBookView(book_id);
				break;
			case 3 :
				//장바구니에 담기
				BasketDTO basket = new BasketDTO(Session.get("login_id"), book_id);
				if(badao.addBasket(basket)) {
					System.out.println("책바구니에 추가되었습니다!");
				}
				else {
					System.out.println("알수 없는 오류가 발생하였습니다. 다시 시도해주세요.");
				}
				break;
			default:
				System.out.println("다시 입력해주세요");
			}
		}
	}
	
}
