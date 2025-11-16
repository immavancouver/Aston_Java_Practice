package patterns.chain.handlers;

import patterns.chain.Handler;
import patterns.chain.Request;

public class RoleHandler implements Handler {

	@Override
	public boolean handle(Request request) {
		if (!"ADMIN".equals(request.getRole())) {
			System.out.println("RoleHandler: Access denied");
			return false;
		}

		System.out.println("RoleHandler: Role OK");
		return true;
	}

}
