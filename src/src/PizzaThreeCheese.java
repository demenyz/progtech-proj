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
}
