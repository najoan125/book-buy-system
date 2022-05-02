package view;

import java.util.Scanner;

import dao.BookDAO;
import dao.OrderDAO;
import dao.Session;
import dto.OrdersDTO;

public class OrderBookView {
	public OrderBookView(int book_id) {
		//주문에 관련된 정보에 접근할 객체인 odao 생성(주문 관련된 기능들이 선언되어 있다.)
		BookDAO bdao = new BookDAO();
		OrderDAO odao = new OrderDAO();
		Scanner sc = new Scanner(System.in);
		
		String order_check = "배송 중";
		java.sql.Timestamp order_buydate = new java.sql.Timestamp(new java.util.Date().getTime());
		
		OrdersDTO order = new OrdersDTO(order_check, order_buydate, Session.get("login_id"), book_id);
		
		//포장이 끝났다면 odao의 메소드에 객체 넘겨주기
		if(!bdao.purchasedBook(book_id)) {
			System.out.println("품절된 책 입니다\nㅠㅅㅠ");
		}
		else if(odao.addOrder(order)) {
			System.out.println(book_id + "번 책 구매를 완료하셨습니다!");
			bdao.purchaseBook(book_id);
		}
		else {
			System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
		}
	}
}














