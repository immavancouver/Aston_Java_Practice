package patterns.chain;

import java.util.ArrayList;
import java.util.List;

public class ProcessingPipeline {

	private final List<Handler> handlers = new ArrayList<>();

	public ProcessingPipeline addHandler(Handler handler) {
		handlers.add(handler);
		return this;
	}

	public void process(Request request) {
		for (Handler handler : handlers) {
			boolean shouldContinue = handler.handle(request);
			if (!shouldContinue) {
				break;
			}
		}
	}
}
