package view;

import java.util.Scanner;

import dao.UserDAO;

public class MyInfoView {
	public int stat = 0;
	public MyInfoView() {
		stat = 0;
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		System.out.println(udao.myInfo());
		System.out.println("0. 뒤로 가기\n1. 비밀번호 수정\n2. 핸드폰 번호 수정\n3. 주소 수정\n4. 이메일 수정\n5. 회원탈퇴");
		int choice = sc.nextInt();
		if(choice == 0) {
			System.out.println("메인으로 돌아갑니다.");
		} else if(choice == 5) {
			System.out.print("정말 탈퇴하시겠습니까?\n1. 네\n2. 아니요");
			int choice0 = sc.nextInt();
			if(choice0 == 1) {
				System.out.print("비밀번호 재입력 : ");
				String user_pw = sc.next();
				//비밀번호 검사를 위해 udao의 checkPw() 호출
				if(udao.checkPw(user_pw)) {
					//회원탈퇴 진행
					//탈퇴 진행 시 현재 탈퇴를 하려는 회원이 올린 모든 상품들도 삭제 혹은 사용불가 처리를 해주어야 한다.
					//후에 삽입될 데이터와 충돌이 발생할 수 있기 때문이다. 상품을 관리할 pdao를 통해 removeAll()을
					//먼저 진행해준다. *실제 DB 환경에서도 상품 삭제가 먼저 되어야지만 회원을 탈퇴 시킬 수 있다.
//					badao.removeAll(); <-- basket 전체 삭제로 변경 예정
					//상품까지 깨끗하게 처리되었으므로 실제 회원 데이터 삭제 진행
					if(udao.leaveId()) {
						//아련하게 인사
						System.out.println("☆☆☆그동안 이용해 주셔서 감사합니다☆☆☆");
						stat++;
					}
					else {
						System.out.println("유저 데이터 삭제 중 오류 발생. 다시 시도해 주세요.");
					}
				}
				//비밀번호 검사 실패
				else {
					System.out.println("비밀번호 오류");
				}
			}
			else if(choice0 == 2) {
				System.out.println("믿음에 보답하겠습니다");
			}
			else {
				System.out.println("보기에 있는 숫자를 입력해주세요.");
			}
		}
		//무언가 회원 정보를 수정하려고 선택했을 때
		else {
			System.out.print("새로운 정보 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			
			boolean check = false;
			check = udao.modifyUser(choice, newData);
			
			if(check) {
				System.out.println("정보 수정 완료!");
			}
			else {
				System.out.println("정보 수정 실패");
			}
		}
	}
}








