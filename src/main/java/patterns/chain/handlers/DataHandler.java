package patterns.chain.handlers;

import patterns.chain.Handler;
import patterns.chain.Request;

public class DataHandler implements Handler {

	@Override
	public boolean handle(Request request) {

		System.out.println("DataHandler: Data processed for " + request.getUsername());
		return true;
	}
}
