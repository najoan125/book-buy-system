package view;

import java.util.Scanner;

import dao.BookDAO;

//index : 시작하는 페이지
public class Index {
	public static void main(String[] args) {
		BookDAO bdao = new BookDAO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("☆페라리 4조 / 도서 구매 프로그램 입니다.☆");
			System.out.println("1. 회원가입\n2. 로그인\n3. 책 검색\n4. 고객센터\n5. 도서랭킹\n6. 나가기");
			int choice = sc.nextInt();
			
			//Controller
			if(choice == 6) {
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
				for(;;) {
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
						}
						while(true) {
							System.out.println("\n0. 나가기");
							int exit=sc.nextInt();
							if(exit==0)break;
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
						}
						break;
					}
					else {
						System.out.println("다시 입력하세요");
					}
				}
				break;
			case 4:
				for(;;) {
					System.out.println("0. 뒤로 가기\n1. FAQ\n2. 공지사항");
					sc = new Scanner(System.in);
					int choice3 = sc.nextInt();
					if(choice3 == 0) {
						break;
					}
					if(choice3 == 1) {
						System.out.println("Q. 이 멋진 사이트의 프로그램의 개발자는 누구인가요?\n");
						System.out.println("A. 잘생긴 정다솔 강사님을 스승으로 둔 페라리4조입니다.\n\n");
						
						System.out.println("Q. 구라 아닌가요?\n");
						System.out.println("A. 네,아닐겁니다.\n");
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
			case 5:
				while(true) {
					System.out.print("0. 뒤로 가기\n1. 베스트셀러\n2. 좋아요 누적 순위\n");
					sc = new Scanner(System.in);
					int choice4 = sc.nextInt();
					if(choice4 == 0) {
						break;
					}
					if(choice4 == 1) {
						System.out.println(bdao.bestSellerBook());
					}
					else if(choice4 == 2){
						System.out.println(bdao.likeCountRank());
					}
					else {
						System.out.println("보기에 있는 숫자를 입력해주세요.");
					}
				}
			default:
				System.out.println("보기에 있는 숫자를 입력해주세요.");
			}
		}
	}
}












