package controller.membership;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dto.Customer;
import dto.Grades;
import service.membership.MembershipService;
import view.FailView;
import view.SuccessView;

public class MembershipController {
	MembershipService service = new MembershipService();
	
	public void getMembership() {
		try {
			
			Customer customer = service.getCustomer();
			SuccessView.printMembershipCard(customer);
			
			List<Grades> list = service.getMembership();
			SuccessView.printMembership(list);
			
			System.out.println("Enter를 입력하세요.");
			Scanner s = new Scanner(System.in);
			s.nextLine();
			
		} catch(SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
}
