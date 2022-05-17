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
        return super.Calories() + 500;
    }

    @Override
    public boolean Ishot() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Bolognese, Cheese, Hot peppers, Onions, Garlic");
    }
}
