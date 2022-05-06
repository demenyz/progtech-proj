public class PizzaBolognese extends FoodDecorator {

    public PizzaBolognese(BaseFood newFood) {
        super(newFood);
    }

    @Override
    public int Price() {
        return super.Price()+ 1000;
    }

    @Override
    public int Calories() {
        return super.Calories() + 700;
    }

    @Override
    public boolean Ishot() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s; Bolognese Toppings: bolognese, cheese, hot peppers Calories: %i; Price: %i; Hot: %b;",
        super.toString(), Calories(), Price(), Ishot()
        );
    }
}
