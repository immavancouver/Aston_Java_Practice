package patterns.builder;

public class OrderBuilder {

	String product;
	int quantity;
	double pricePerItem;
	double discount;
	double totalPrice;

	public OrderBuilder product(String product) {
		this.product = product;
		return this;
	}

	public OrderBuilder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderBuilder pricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
		return this;
	}

	public OrderBuilder discount(double discount) {
		this.discount = discount;
		return this;
	}

	private void validate() {
		if (product == null || product.isEmpty()) {
			throw new IllegalStateException("Product is required");
		}
		if (quantity <= 0) {
			throw new IllegalStateException("Quantity must be positive");
		}
		if (pricePerItem <= 0) {
			throw new IllegalStateException("Price per item must be positive");
		}
		if (discount < 0 || discount > 90) {
			throw new IllegalStateException("Discount must be between 0 and 90%");
		}
	}

	private void computeTotalPrice() {
		double base = pricePerItem * quantity;
		this.totalPrice = base - (base * (discount / 100));
	}

	public Order build() {
		validate();
		computeTotalPrice();
		return new Order(this);
	}
}
