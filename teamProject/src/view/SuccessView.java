package view;

import java.util.List;

import dto.CSBoardDTO;
import dto.CSReplyDTO;
import dto.Customer;
import dto.Price;
import dto.Reservation;

public class SuccessView {
	public static void printPrice(List<Price> price) {
		System.out.println("=============가격표=============");
		System.out.println("가격은 반려견 몸무게에 맞게 산정됩니다.");
		System.out.println(" | 종류 | 일반견 가격 | 특수견 가격 | 소요 시간");
		System.out.println();
		for (int i = 0; i < price.size(); i++) {
			System.out.println(price.get(i));
		}
		System.out.println("==============================");
	}

	public static void printMessage(String message) {
		System.out.println(message);

	}
	
	/**
	 * 상담 게시판 전체 게시물 출력하기
	 * */
	public static void selectAllBoardPrint(List<CSBoardDTO> list) {
		System.out.println("\n --------------------------------[ 게시글 목록 (" +list.size()+") ]-------------------------------\n");
		for(CSBoardDTO dto : list) {
			System.out.println(dto);
			for(CSReplyDTO reply : dto.getReplyList()) {
				System.out.println("    ▶"+reply);
			}
			System.out.println(" ----------------------------------------------------------------------------------");
		}
		System.out.println();
	}
	
	/**
	 * 상담 게시판 게시글과 댓글 정보 출력하기
	 * */
	public static void boardWithReplyPrint(CSBoardDTO boardDTO) {
		System.out.println("\n --------------------------------[ 게시글 목록  ]-------------------------------\n");
		System.out.println(boardDTO);
		for(CSReplyDTO reply : boardDTO.getReplyList()) {
			System.out.println("    ▶"+reply);
		}
		System.out.println();
	}
	
	public static void printReservation(List<Reservation> list) {
		System.out.println("===============예약 현황===============");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getResvTime() + " / " + list.get(i).getGrmType() + " / " + list.get(i).getPay());
			System.out.println("[" + list.get(i).getResvState() + "] 상태입니다.");
			System.out.println();
		}
	}


	/**
	 * 
	 */
	public static void printCustomerInform(Customer customer) {
		System.out.println(customer);
		
	}

	public static void printReservationList(List<Reservation> list) {
		System.out.println("===============예약 현황===============");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCustomer().getCstmName()+ "고객님의 반려견 " + list.get(i).getCustomer().getPname() + " 예약 대기상태입니다.");
			System.out.println("전화번호 : " + list.get(i).getCustomer().getTel());
			System.out.println("예약시간 : " + list.get(i).getResvTime());
			System.out.println("예약내용 : " + list.get(i).getGrmType());
			System.out.println("예약금액 : " + list.get(i).getPay());
			System.out.println();
		}
	}
}
