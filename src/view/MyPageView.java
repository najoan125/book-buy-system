package view;

import java.util.Scanner;

import dao.BasketDAO;
import dao.BookDAO;
import dao.BookDAO;
import dao.Session;

public class MyPageView {
	public int status = 0;
	public MyPageView() {
		Scanner sc = new Scanner(System.in);
		BookDAO bdao = new BookDAO();
		BasketDAO badao = new BasketDAO();
		
		Loop1:
		while(true) {
			status = 0;
			//우리가 만든 프로젝트는 무조건 main()부터 시작하는 프로그램이다.
			//즉 진입점이 한개이기 때문에 아래와 같은 코드를 생략 가능하다.
			//*웹 상이나 다른 프로그램에서는 진입점이 여러개일 수 있으므로
			//아래처럼 로그인 되어있는지를 먼저 검사해주는것이 필요하다.
			if(Session.get("login_id") == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
			System.out.println("☆★☆★☆★☆★"+Session.get("login_id")+"님 어서오세요~☆★☆★☆★☆★\n"
					+ "1. 내 책바구니 보기\n2. 내 주문 조회\n3. 내 정보 수정\n4. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 4) {
				break;
			}
			switch(choice) {
			case 1:
				//내 책바구니 보기
				System.out.println("===========내 장바구니 책 목록===========");
				System.out.println(badao.getBasketList());
				System.out.println("==================================");
				System.out.println("1. 책바구니에서 책 빼내기\n2. 나가기");
				int choice2 = sc.nextInt();
				if(choice2 == 2) {
					break;
				}
				switch(choice2) {
				case 1:
					//내 책바구니 보기
					while(true) {
						System.out.print("빼낼 장바구니 번호를 입력해주세요 : ");
						int basket_id = sc.nextInt();
						if(badao.deleteBasket(basket_id)) {
							System.out.println("정상적으로 장바구니에서 책을 빼내었습니다");
							break;
						}
						else {
							System.out.println("예기치 못한 오류가 발생하였습니다. 다시 시도해주세요.");
						}
					}
				default:
					System.out.println("보기에 있는 번호를 입력해주세요.");
				}
				break;
			case 2:
				new ModifyOrderView();
				break;
			case 3:
				MyInfoView myinfo= new MyInfoView();
				if(myinfo.stat!=0) {
					status++;
					break Loop1;
				}
				break;
			default:
				System.out.println("보기에 있는 번호를 입력해주세요.");
			}
		}
	}
}









