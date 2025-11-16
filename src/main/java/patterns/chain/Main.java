package patterns.chain;

import patterns.chain.handlers.AuthHandler;
import patterns.chain.handlers.DataHandler;
import patterns.chain.handlers.RoleHandler;

public class Main {
	public static void main(String[] args) {

		ProcessingPipeline pipeline = new ProcessingPipeline()
				.addHandler(new AuthHandler())
				.addHandler(new RoleHandler())
				.addHandler(new DataHandler());

		Request request = new Request("Kirill", "ADMIN", true);

		pipeline.process(request);
	}
}
