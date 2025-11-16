package patterns.decorator;

public class Main {

	public static void main(String[] args) {
		Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.description() + " $" + coffee.cost());

		Coffee milkCoffee = new MilkDecorator(coffee);
		System.out.println(milkCoffee.description() + " $" + milkCoffee.cost());

		Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
		System.out.println(milkSugarCoffee.description() + " $" + milkSugarCoffee.cost());
	}

}
