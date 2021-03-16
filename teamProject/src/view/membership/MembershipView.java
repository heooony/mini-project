package view.membership;

import controller.membership.MembershipController;

public class MembershipView {
	public static void membership() {
		MembershipController controller = new MembershipController();
		controller.getMembership();
	}
}
