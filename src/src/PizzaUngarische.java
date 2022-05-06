public class PizzaUngarische extends FoodDecorator {
    public PizzaUngarische(BaseFood newFood) {
        super(newFood);
    }

    @Override
    public int Price() {
        return super.Price() + 700;
    }

    @Override
    public int Calories() {
        return super.Calories() + 300;
    }

    @Override
    public boolean Ishot() {
        return true;
    }
    @Override
    public String toString() {
        return String.format("%s; Ungarische Toppings: hot sausage, cheese, salami, pepperoni, hot peppers  Calories: %i; Price: %i; Hot: %b;",
                super.toString(), Calories(), Price(), Ishot()
        );
    }
}
