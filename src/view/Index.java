package view;

import java.util.Scanner;

import dao.BookDAO;

//index : 시작하는 페이지
public class Index {
	public static void main(String[] args) {
		System.out.println("페라리 4조 / 도서 구매 프로그램 입니다.");
		
		BookDAO bdao = new BookDAO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 책 검색\n4. 나가기");
			int choice = sc.nextInt();
			
			//Controller
			if(choice == 4) {
				System.out.println("안녕히가세요");
				break;
			}
			switch(choice) {
			case 1:
				//회원가입
				//많은 데이터들의 입출력이 일어나기 때문에 코드가 길어진다.
				//따라서 새로운 View를 띄워준다.(흐름을 이동시킨다)
				new UserJoinView();
				break;
			case 2:
				//로그인
				new LoginView();
				break;
			case 3:
				System.out.print("0. 뒤로 가기\n1. 책 제목 검색\n2. 작가 검색\n3. 출판사 검색\n4. 장르 검색\n검색방법을 선택해주세요: ");
				sc = new Scanner(System.in);
				for(;;) {
					int choice2 = sc.nextInt();
					if(choice2 == 0){
						break;
					}
					else if(choice2 == 1) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
//						System.out.println(bdao.titleSearch(keyword));
						String result = bdao.titleSearch(keyword);
						if (result == "none") {
							System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
							break;
						}
						System.out.println(result);
						break;
					}
					else if(choice2 == 2) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.authorSearch(keyword);
						if (result == "none") {
							System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
							break;
						}
						System.out.println(result);
						break;
					}
					else if(choice2 == 3) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.publisherSearch(keyword);
						if (result == "none") {
							System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
							break;
						}
						System.out.println(result);
						break;
					}
					else if(choice2 == 4) {
						System.out.print("검색어를 입력하세요 : ");
						sc = new Scanner(System.in);
						String keyword = sc.nextLine();
						
						String result = bdao.genreSearch(keyword);
						if (result == "none") {
							System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
							break;
						}
						System.out.println(result);
						break;
					}
					else {
						System.out.println("다시 입력하세요");
					}
				}
				
			default:
				System.out.println("보기에 있는 숫자를 입력해주세요.");
			}
		}
	}
}












