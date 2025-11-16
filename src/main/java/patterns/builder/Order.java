package patterns.builder;

public class Order {

	private final String product;
	private final int quantity;
	private final double pricePerItem;
	private final double discount;
	private final double totalPrice;

	Order(OrderBuilder builder) {
		this.product = builder.product;
		this.quantity = builder.quantity;
		this.pricePerItem = builder.pricePerItem;
		this.discount = builder.discount;
		this.totalPrice = builder.totalPrice;
	}

	@Override
	public String toString() {
		return "Order {" +
				"product='" + product + '\'' +
				", quantity=" + quantity +
				", pricePerItem=" + pricePerItem +
				", discount=" + discount +
				", totalPrice=" + totalPrice +
				'}';
	}

	public static OrderBuilder builder() {
		return new OrderBuilder();
	}
}
