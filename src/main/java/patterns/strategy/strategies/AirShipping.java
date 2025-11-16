package patterns.strategy.strategies;

import patterns.strategy.ShippingStrategy;

public class AirShipping implements ShippingStrategy {

	@Override
	public double calculate(double weight) {
		return 20 + weight * 3.5;
	}
}
