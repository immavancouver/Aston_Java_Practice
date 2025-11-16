package patterns.decorator;

public class SugarDecorator extends CoffeeDecorator{

	public SugarDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return super.cost() + 0.5;
	}

	@Override
	public String description() {
		return super.description() + ", sugar";
	}
}
