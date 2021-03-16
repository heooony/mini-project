package view;

import java.util.List;
import java.util.Scanner;

import dto.CSBoardDTO;
import dto.CSReplyDTO;
import dto.Customer;
import dto.Grades;
import dto.Price;
import dto.Reservation;

public class SuccessView {
	public static void printPrice(List<Price> price) {
		System.out.println();
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("                  🍇 Personal Price 🍇             " );       
		System.out.println(" ──────────────────────────────────────────────────── ");  
		System.out.println("          입력하신 몸무게에 맞추어 산정된 가격입니다 ^^");
		System.out.println("    Type   |     Basic    |    Special   |    Time    ");
		System.out.println(" ────────────────────────────────────────────────────");
		for (int i = 0; i < price.size(); i++) {
			System.out.println(price.get(i));
		}
		System.out.println("└────────────────────────────────────────────────────┘");
	}

	public static void printMessage(String message) {
		System.out.println(message);

	}
	
	/**
	 * 상담 게시판 전체 게시물 출력하기
	 * */
	public static void selectAllBoardPrint(List<CSBoardDTO> list) {
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("                                    🍇  Post List 🍇 "+list.size()+"" );       
		System.out.println(" ────────────────────────────────────────────────────────────────────────────────────────────────── ");  
		for(CSBoardDTO dto : list) {
			System.out.println(dto);
			for(CSReplyDTO reply : dto.getReplyList()) {
				System.out.println("    ▶"+reply);
			}
			System.out.println(" ──────────────────────────────────────────────────────────────────────────────────────────────────");
		}
		System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────┘");
		System.out.println();
	}

	/**
	 * 상담 게시판 게시글과 댓글 정보 출력하기
	 * */
	public static void boardWithReplyPrint(CSBoardDTO boardDTO) {
		System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("                                    🍇  Post List 🍇 ");       
		System.out.println(" ────────────────────────────────────────────────────────────────────────────────────────────────── ");  
		System.out.println(boardDTO);
		for(CSReplyDTO reply : boardDTO.getReplyList()) {
			System.out.println("    ▶"+reply);
		}
		System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────┘");
		System.out.println();
	}
	
	/**
	 * 가격표 리스트 전체 출력
	 * */
	public static void allPriceListPrint(List<Price> list) {
		System.out.println();
		System.out.println("┌─────────────────────────────────────────────────────┐");
		System.out.println("                    🍇 Basic Price 🍇                 " );
		System.out.println("    2kg 기준의 가격표이며, 견종과 몸무게에 따라 가격은 조정됩니다^^  " );
		System.out.println(" ───────────────────────────────────────────────────── ");  
		for(Price price : list) {
			System.out.println("    Type   |     Basic    |    Special   |    Time    ");
			System.out.println(price);
			System.out.println(" ───────────────────────────────────────────────────── ");
		}
		System.out.println("└─────────────────────────────────────────────────────┘");
	}
	
	public static void printReservation(List<Reservation> list) {
		System.out.println();
		System.out.println("┌─────────────────────────────────────────────────────┐");
		System.out.println("                    🍇 예약 현황 🍇                 " );       
		System.out.println(" ───────────────────────────────────────────────────── ");  
		for(int i = 0; i < list.size(); i++) {
			System.out.println("            "+list.get(i).getResvTime() + " / " + list.get(i).getGrmType() + " / " + list.get(i).getPay());
			System.out.println("            현재 [" + list.get(i).getResvState() + "] 상태입니다.");
			System.out.println(" ───────────────────────────────────────────────────── ");
		}	System.out.println("└─────────────────────────────────────────────────────┘");
			System.out.println();
	         System.out.print("서비스로 돌아가려면 Enter를 눌러주세요.");
	         Scanner s = new Scanner(System.in);
	         s.nextLine();
	         System.out.println();
		
	}


	/**
	 * 
	 */
	public static void printCustomerInform(Customer customer) {
		System.out.println(customer); 
		System.out.println();
		System.out.print("서비스로 돌아가려면 Enter를 눌러주세요.");
		Scanner s = new Scanner(System.in);
        s.nextLine();
	}

	public static void printReservationList(List<Reservation> list) {
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────────┐");
		System.out.println("             🍇 Reservation List 🍇                 " );       
		System.out.println("───────────────────────────────────────────────────");  
	

		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCustomer().getCstmName()+ "고객님의 반려견 " + list.get(i).getCustomer().getPname() + " 예약 대기상태입니다.");
			System.out.println("        전화번호 : " + list.get(i).getCustomer().getTel());
			System.out.println("        예약시간 : " + list.get(i).getResvTime());
			System.out.println("        예약내용 : " + list.get(i).getGrmType());
			System.out.println("        예약금액 : " + list.get(i).getPay());
			System.out.println("        예약번호 : " + list.get(i).getResvno());
			System.out.println("└──────────────────────────────────────────────────┘");
			System.out.println();
			
		}
	}

	public static void printMembership(List<Grades> list) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("            🍇 Membership Information 🍇                 " );       
		System.out.println(" ───────────────────────────────────────────────────────");  
		System.out.println("       등급      |       승급조건       |   마일리지 적립(%)");
		System.out.println("      Bronze              5회                  1%");
		System.out.println("      Silver             10회                  2%");
		System.out.println("      Gold               20회                  3%");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println(); 
		System.out.print("서비스로 돌아가려면 Enter를 눌러주세요.");
		 Scanner s = new Scanner(System.in);
		 s.nextLine();
	}

	public static void printMembershipCard(Customer customer) {
		System.out.println();
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────────┐");
		System.out.println("              PodoSalon Membership card       " );
		System.out.println();
		System.out.println("    ,:':,...,:':,         Owner            "+ customer.getPname());
		System.out.println("    ,:' ・ 👅 ・   ':,       CardNo           " + customer.getCardno() );
		System.out.println("   ;:　　  　      :;       Membership       "+ customer.getGrade());
		System.out.println("   ':............:・'       Name             " + customer.getCstmName()); 
		System.out.println("└──────────────────────────────────────────────────┘");
		System.out.println();
		System.out.println();
	
	
		
	}
}
