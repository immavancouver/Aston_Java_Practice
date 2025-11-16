package patterns.chain.handlers;

import patterns.chain.Handler;
import patterns.chain.Request;

public class AuthHandler implements Handler {
	@Override
	public boolean handle(Request request) {

		if(!request.hasToken()) {
			System.out.println("AuthHandler: No token");
			return false;
		}

		System.out.println("AuthHandler: Token OK");
		return true;
	}
}
