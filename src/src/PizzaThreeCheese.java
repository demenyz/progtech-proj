public class PizzaThreeCheese extends FoodDecorator {

    public PizzaThreeCheese(BaseFood newFood) {
        super(newFood);

    }
    @Override
    public int Price() {
        return super.Price() + 900;
    }

    @Override
    public int Calories() {
        return super.Calories() + 600;
    }

    @Override
    public boolean Ishot() {
        return false;
    }
    @Override
    public String toString() {
        return String.format("%s: ThreeCheese, Toppings: mozzarella cheese, smoked cheese, trappist cheese, Calories: %s Price: %s Hot: %s",
                super.toString(), Calories(), Price(), Ishot()
        );
    }
}
