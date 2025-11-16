package patterns.builder;

public class Main {
	public static void main(String[] args) {
		Order order = Order.builder()
				.product("MacBook Pro")
				.quantity(2)
				.pricePerItem(1500)
				.discount(10)
				.build();

		System.out.println(order);
	}
}
