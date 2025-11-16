package patterns.strategy;

import patterns.strategy.strategies.AirShipping;
import patterns.strategy.strategies.ExpressShipping;
import patterns.strategy.strategies.StandardShipping;

import java.util.Map;

public class ShippingCalculator {

	private final Map<ShippingType, ShippingStrategy> strategies =
			Map.of(
					ShippingType.STANDARD, new StandardShipping(),
					ShippingType.EXPRESS, new ExpressShipping(),
					ShippingType.AIR, new AirShipping()
			);

	public double calculate(ShippingType type, double weight) {
		ShippingStrategy strategy = strategies.get(type);

		if (strategy == null) {
			throw new IllegalArgumentException("No strategy found for: " + type);
		}

		return strategy.calculate(weight);
	}

}
