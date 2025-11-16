package patterns.strategy;

public class Main {

	public static void main(String[] args) {

		ShippingCalculator calculator = new ShippingCalculator();

		System.out.println("Standard: " + calculator.calculate(ShippingType.STANDARD, 5));
		System.out.println("Express:  " + calculator.calculate(ShippingType.EXPRESS, 5));
		System.out.println("Air:      " + calculator.calculate(ShippingType.AIR, 5));
	}
}
