package patterns.adapter;

public class Adapter implements Target{

	private final Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		System.out.println("Adapter: translating request to specificRequest");
		adaptee.specificRequest();
	}
}
