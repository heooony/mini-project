package view;

import java.util.List;

import dto.Customer;
import dto.Price;

public class SuccessView {
	public static void printPrice(List<Price> price) {
		System.out.println("=============����ǥ=============");
		System.out.println("������ �ݷ����� �����Կ� �°� �ڵ� �����˴ϴ�.");
		System.out.println(" | ���� | �Ϲ� ���� | Ư���� ���� | �ҿ� �ð�");
		System.out.println();
		for (int i = 0; i < price.size(); i++) {
			System.out.println(price.get(i));
		}
		System.out.println("==============================");
	}

	public static void printMessage(String message) {
		
		
	}
	public static void confirmId(Customer customer) {
		System.out.println(customer);
	}
}
