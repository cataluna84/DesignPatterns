package pattern.decorator.ex2;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Most Excellent Dark Roast";
	}

	public double cost() {
		return 1.99;
	}
}