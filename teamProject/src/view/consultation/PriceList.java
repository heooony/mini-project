package view.consultation;

import java.util.Scanner;

import controller.CSBoardController;
import dto.Price;

public class PriceList {
	static Scanner sc = new Scanner(System.in);
	
	public static void priceListMenu() {
		while (true) {
			System.out.println();
			System.out.println("┌────────────────────────────────────────┐");
			System.out.println("          🍇 Price Management 🍇      " );     
			System.out.println(" ────────────────────────────────────────");
			System.out.println("             1. 미용 가격 조회");
			System.out.println("             2. 미용 서비스 등록 ");
			System.out.println("             3. 미용 서비스 삭제");
			System.out.println("             9. 이전으로");
			System.out.println("└────────────────────────────────────────┘");
			System.out.print("서비스 번호를 입력해주세요 > ");
			int no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case 1:CSBoardController.priceSelectAll();break;
			case 2:inputPriceInsert();break;
			case 3:inputPriceDelete();break;
			case 9:return;
			}
		}
	}
	
	/**
	 * 가격표 레코드 입력
	 * */
	public static void inputPriceInsert() {
		try {
			System.out.print(" 서비스명 : ");
			String grmType = sc.nextLine();

			System.out.print(" 일반견 가격 : ");
			int bCost = Integer.parseInt(sc.nextLine());
			
			System.out.print(" 특수견 가격 : ");
			int spcCost = Integer.parseInt(sc.nextLine());
			
			System.out.print(" 소요시간 : ");
			int grmTimes = Integer.parseInt(sc.nextLine());
		
			Price price = new Price(grmType, bCost, spcCost, grmTimes);
			CSBoardController.priceInsert(price);
			CSBoardController.priceSelectAll();
		}catch(Exception e) {
			System.out.print(" 잘못된 입력입니다. 다시 시도하시겠습니까? ( 1:예 / 2:아니오 )");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputPriceInsert();
			}
		}
	}
	
	/**
	 * 가격표 레코드 삭제
	 * */
	public static void inputPriceDelete() {
		try {
			System.out.print(" 삭제할 서비스명 : ");
			String grmType = sc.nextLine();
			CSBoardController.priceDelete(grmType);
			CSBoardController.priceSelectAll();
		} catch (Exception e) {
			System.out.print(" 잘못된 입력입니다. 다시 시도하시겠습니까? ( 1:예 / 2:아니오 )");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				inputPriceDelete();
			}
		}
	}
}
