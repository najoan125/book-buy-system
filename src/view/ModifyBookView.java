package view;

import java.util.Scanner;

import dao.BookDAO;

public class ModifyBookView {
   public ModifyBookView() {
      BookDAO bdao = new BookDAO();
      Scanner sc = new Scanner(System.in);
      
      System.out.print("0. 돌아가기\n1. 책 제목 검색\n2. 작가 검색\n3. 출판사 검색\n4. 장르 검색\n검색방법을 선택해주세요: ");
      sc = new Scanner(System.in);
      int choice2 = sc.nextInt();
      if(choice2 == 1) {
         System.out.print("검색어를 입력하세요 : ");
         sc = new Scanner(System.in);
         String keyword = sc.nextLine();
         
//         System.out.println(bdao.titleSearch(keyword));
         String result = bdao.titleSearch(keyword);
         if (result == "none") {
            System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
            return;
         }
         System.out.println(result);
      }
      else if(choice2 == 2) {
         System.out.print("검색어를 입력하세요 : ");
         sc = new Scanner(System.in);
         String keyword = sc.nextLine();
         
         String result = bdao.authorSearch(keyword);
         if (result == "none") {
            System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
            return;
         }
         System.out.println(result);
      }
      else if(choice2 == 3) {
         System.out.print("검색어를 입력하세요 : ");
         sc = new Scanner(System.in);
         String keyword = sc.nextLine();
         
         String result = bdao.publisherSearch(keyword);
         if (result == "none") {
            System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
            return;
         }
         System.out.println(result);
      }
      else if(choice2 == 4) {
         System.out.print("검색어를 입력하세요 : ");
         sc = new Scanner(System.in);
         String keyword = sc.nextLine();
         
         String result = bdao.genreSearch(keyword);
         if (result == "none") {
            System.out.println("검색 결과가 존재하지 않습니다. 다시 검색해 주세요.");
            return;
         }
         System.out.println(result);
      }
      else if (choice2 == 0) {
         return;
      }
      System.out.print("수정할 책 번호 : ");
      int book_id = sc.nextInt();
      if (!bdao.checkBookId(book_id)) {
         System.out.println("존재하지 않는 책 번호 입니다.");
         return;
      }
      System.out.println("1. 제목수정\n2. 가격수정\n3. 재고수정\n4. 작가수정\n5. 출판사수정\n6. 장르수정\n7. 출판국가수정\n8. 출판년도수정\n9. 사용언어수정");
      int choice = sc.nextInt();
      System.out.print("새로운 정보 : ");
      sc = new Scanner(System.in);
      String newData = sc.nextLine();
      
      //세가지 입력받은 데이터를 DAO에 넘겨주기(행, 열, 새로운 데이터)
      if(bdao.modifyBook(book_id,choice,newData)) {
         System.out.println(book_id+"번 책이 정상적으로 수정되었습니다.");
      }
      else {
         System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
      }
   }
}



