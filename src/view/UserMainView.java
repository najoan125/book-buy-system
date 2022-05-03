package view;

import java.util.Scanner;

import dao.BasketDAO;
import dao.BookDAO;
import dao.BookDAO;
import dao.Session;

public class UserMainView {
	public UserMainView() {
		Scanner sc = new Scanner(System.in);
		BookDAO bdao = new BookDAO();
		BasketDAO badao = new BasketDAO();
		
		Loop1:
		while(true) {
			//우리가 만든 프로젝트는 무조건 main()부터 시작하는 프로그램이다.
			//즉 진입점이 한개이기 때문에 아래와 같은 코드를 생략 가능하다.
			//*웹 상이나 다른 프로그램에서는 진입점이 여러개일 수 있으므로
			//아래처럼 로그인 되어있는지를 먼저 검사해주는것이 필요하다.
			if(Session.get("login_id") == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
			System.out.println("☆★☆★☆★☆★"+Session.get("login_id")+"님 어서오세요~☆★☆★☆★☆★\n"
					+ "1. 책 검색\n2. 마이 페이지\n3. 고객 센터\n4. 베스트셀러\n5. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				//로그아웃
				System.out.println(Session.get("login_id")+"님 안녕히가세요~\n");
				//로그인한 정보를 담아주는 Session에서 login_id라는 KEY 와 쌍을 이루고 있는 값은
				//로그아웃을 했다면 없애주어야 한다. 따라서 null로 초기화 해주어야 한다.
				Session.put("login_id", null);
				break;
			}
			switch(choice) {
			case 1:
				//상품 검색
				while (true) {
					System.out.print("0. 뒤로가기\n1. 책 제목 검색\n2. 작가 검색\n3. 출판사 검색\n4. 장르 검색\n검색방법을 선택해주세요: ");
					sc = new Scanner(System.in);
					int choice2 = sc.nextInt();
					if(choice2 == 0) {
						break;
					}
					else if(choice2 == 1) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						System.out.println(bdao.titleSearch(keyword));
						System.out.print("0. 뒤로가기\n자세히 볼 책 번호 : ");
						int book_id = sc.nextInt();
						if(book_id == 0) {
							break;
						}
						new BookMainView(book_id);
						break;
					}
					else if(choice2 == 2) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						System.out.println(bdao.authorSearch(keyword));
						System.out.print("0. 뒤로가기\n자세히 볼 책 번호 : ");
						int book_id = sc.nextInt();
						if(book_id == 0) {
							break;
						}
						new BookMainView(book_id);
						break;
					}
					else if(choice2 == 3) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						System.out.println(bdao.publisherSearch(keyword));
						System.out.print("0. 뒤로가기\n자세히 볼 책 번호 : ");
						int book_id = sc.nextInt();
						if(book_id == 0) {
							break;
						}
						new BookMainView(book_id);
						break;
					}
					else if(choice2 == 4) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						System.out.println(bdao.genreSearch(keyword));
						System.out.print("0. 뒤로가기\n자세히 볼 책 번호 : ");
						int book_id = sc.nextInt();
						if(book_id == 0) {
							break;
						}
						new BookMainView(book_id);
						break;
					}
					else {
						System.out.println("보기에 있는 숫자를 입력해주세요.");
					}
				}
				break;
			case 2:
				MyPageView mypage= new MyPageView();
				if(mypage.status!=0) {
					break Loop1;
				}
				break;
			case 3:
				while(true) {
					System.out.print("0. 뒤로 가기\n1. FAQ\n2. 공지사항\n");
					sc = new Scanner(System.in);
					int choice3 = sc.nextInt();
					if(choice3 == 0) {
						break;
					}
					if(choice3 == 1) {
						System.out.println("Q. 이 멋진 사이트의 프로그램의 개발자는 누구인가요?\n");
						System.out.println("A. 잘생긴 정다솔 강사님을 스승으로 둔 페라리4조입니다.\n\n");
						
						System.out.println("Q. 강사님 잘생겼다는 거 구라 아닌가요?\n");
						System.out.println("A. 네, 아닐 겁니다.\n");
					}
					else if(choice3 == 2){
						System.out.println("페라리4조 도서구매시스템의 공지사항\n");
						System.out.println("다양한 기능이 즐비한 저희 시스템을 즐겨주시길 바랍니다.");
						System.out.println("주문 상태의 허위 표기는 범죄 행위이며 걸릴 시 법적 대응을 통해 강경히 처벌할 것입니다.\n");
					}
					else {
						System.out.println("보기에 있는 숫자를 입력해주세요.");
					}
				}
			case 4:
				while(true) {
					System.out.println(bdao.bestSellerBook());
					System.out.print("0. 뒤로가기\n자세히 볼 책 번호 : ");
					int book_id = sc.nextInt();
					if(book_id == 0) {
						break;
					}
					new BookMainView(book_id);
					break;
				}
				
			}
		}
	}
}









