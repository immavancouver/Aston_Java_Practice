package patterns.strategy.strategies;

import patterns.strategy.ShippingStrategy;

public class ExpressShipping implements ShippingStrategy {

	@Override
	public double calculate(double weight) {
		return 10 + weight * 2.0;
	}
}
