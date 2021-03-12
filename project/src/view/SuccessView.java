package view;

import java.util.List;

import dto.Customer;
import dto.Price;

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



	public static void confirmId(Customer customer) {
		System.out.println(customer);

	}
	public static void printMessage(String message) {
		System.out.println(message);

	}
}
