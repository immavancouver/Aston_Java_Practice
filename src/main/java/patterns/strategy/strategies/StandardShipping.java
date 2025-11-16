package patterns.strategy.strategies;

import patterns.strategy.ShippingStrategy;

public class StandardShipping implements ShippingStrategy {

	@Override
	public double calculate(double weight) {
		return 5 + weight;
	}
}
