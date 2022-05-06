package view;

import java.util.Scanner;

import dao.BookDAO;
import dao.BookDAO;
import dao.Session;

public class AdminMainView {
	public AdminMainView() {
		Scanner sc = new Scanner(System.in);
		BookDAO bdao = new BookDAO();
		
		while(true) {
			//우리가 만든 프로젝트는 무조건 main()부터 시작하는 프로그램이다.
			//즉 진입점이 한개이기 때문에 아래와 같은 코드를 생략 가능하다.
			//*웹 상이나 다른 프로그램에서는 진입점이 여러개일 수 있으므로
			//아래처럼 로그인 되어있는지를 먼저 검사해주는것이 필요하다.
			if(Session.get("login_id") == null) {
				System.out.println("로그인 후 이용하세요");
				break;
			}
			System.out.println("☆★☆★☆★☆★"+"관리자님의 화면입니다☆★☆★☆★☆★\n"
					+ "1. 책 추가\n2. 책 수정\n3. 책 삭제\n4. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice == 4) {
				//로그아웃
				System.out.println(Session.get("login_id")+"님 안녕히가세요~\n");
				//로그인한 정보를 담아주는 Session에서 login_id라는 KEY 와 쌍을 이루고 있는 값은
				//로그아웃을 했다면 없애주어야 한다. 따라서 null로 초기화 해주어야 한다.
				Session.put("login_id", null);
				break;
			}
			switch(choice) {
			case 1:
				//책 추가
				while(true) {
					System.out.println("뒤로가기: 0\n계속 진행하기: 1\n");
					int choice3 = sc.nextInt();
					if(choice3==0) {
						break;
					}
					else if(choice3==1) {
						new AddBookView();
					}
					else {
						System.out.println("보기에 있는 숫자를 골라주세요");
					}
				}
				
				break;
			case 2:
				//책 정보 수정
				while (true) {
					System.out.println("뒤로가기: 0\n계속 진행하기: 1\n");
					int choice4 = sc.nextInt();
					if(choice4==0) {
						break;
					}
					else if(choice4==1) {
						new ModifyBookView();
						break;
					}
					else {
						System.out.println("보기에 있는 숫자를 골라주세요");
					}
				}
				break;
			case 3:
				//책 삭제
				//책 목록 띄워주고 번호 입력받아서 삭제시키기
				while(true) {
					System.out.print("0. 뒤로 가기\n1. 책 제목 검색\n2. 작가 검색\n3. 출판사 검색\n4. 장르 검색\n검색방법을 선택해주세요: ");
					sc = new Scanner(System.in);
					int choice2 = sc.nextInt();
					if(choice2 == 0){
						break;
					}
					else if(choice2 == 1) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.titleSearch(keyword);
						if(result.equals("")) {
							System.out.println("검색결과가 존재하지 않습니다.");
						}
						else {
							System.out.println(result);
							System.out.print("삭제할 책 번호 : ");
							int book_id = sc.nextInt();
							if(bdao.removeBook(book_id)) {
								System.out.println(book_id+"번 책 삭제 성공!");
							}
							else {
								System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
							}
						}
						
						break;
					}
					else if(choice2 == 2) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.authorSearch(keyword);
						if(result.equals("")) {
							System.out.println("검색결과가 존재하지 않습니다.");
						}
						else {
							System.out.println(result);
							System.out.print("삭제할 책 번호 : ");
							int book_id = sc.nextInt();
							if(bdao.removeBook(book_id)) {
								System.out.println(book_id+"번 책 삭제 성공!");
							}
							else {
								System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
							}
						}
						
						break;
					}
					else if(choice2 == 3) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.publisherSearch(keyword);
						if(result.equals("")) {
							System.out.println("검색결과가 존재하지 않습니다.");
						}
						else {
							System.out.println(result);
							System.out.print("삭제할 책 번호 : ");
							int book_id = sc.nextInt();
							if(bdao.removeBook(book_id)) {
								System.out.println(book_id+"번 책 삭제 성공!");
							}
							else {
								System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
							}
						}
						
						break;
					}
					else if(choice2 == 4) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.genreSearch(keyword);
						if(result.equals("")) {
							System.out.println("검색결과가 존재하지 않습니다.");
						}
						else {
							System.out.println(result);
							System.out.print("삭제할 책 번호 : ");
							int book_id = sc.nextInt();
							if(bdao.removeBook(book_id)) {
								System.out.println(book_id+"번 책 삭제 성공!");
							}
							else {
								System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
							}
						}
						
						break;
					}
					else {
						System.out.println("보기에 있는 숫자를 골라주세요");
					}
				}
				break;
				default:
					System.out.println("보기에 있는 숫자를 골라주세요");
			}
		}
	}
}









