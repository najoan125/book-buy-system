package view;

import java.util.Scanner;

import dao.OrderDAO;

public class ModifyOrderView {
	public ModifyOrderView() {
		OrderDAO odao = new OrderDAO();
		Scanner sc = new Scanner(System.in);
		//나의 주문 목록 출력
		while(true) {
			System.out.println(odao.getOrderList());
			System.out.print("뒤로가기: 0\n변경할 주문 번호 : ");
			int order_id = sc.nextInt();
			if(order_id==0)break;
			System.out.println("1. 주문 취소\n2. 배송 완료 확인\n3. 돌아가기");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(odao.cancelOrder(order_id)) {
					System.out.println("정상적으로 주문이 취소되었습니다.");
					break;
				}
				else {
					System.out.println("정상적으로 처리 되지 않았습니다. 다시 시도해주세요.");
				}
			case 2:
				if(odao.modifyOrder(order_id)) {
					System.out.println("배송 상태가 변경되었습니다.");
					break;
				}
				else {
					System.out.println("정상적으로 처리 되지 않았습니다. 다시 시도해주세요.");
				}
			case 3:
				System.out.println("안녕히가세요");
				break;
			default:
				System.out.println("보기에 있는 숫자를 입력해주세요.");
			}
		}
	}
}




