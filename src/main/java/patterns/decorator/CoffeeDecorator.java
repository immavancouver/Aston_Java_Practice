package patterns.decorator;

public abstract class CoffeeDecorator implements Coffee{

	protected final Coffee decoratedCoffee;

	public CoffeeDecorator(Coffee coffee) {
		this.decoratedCoffee = coffee;
	}

	@Override
	public double cost() {
		return decoratedCoffee.cost();
	}

	@Override
	public String description() {
		return decoratedCoffee.description();
	}
}
