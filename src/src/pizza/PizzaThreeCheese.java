public class PizzaThreeCheese extends FoodDecorator {

    public PizzaThreeCheese(BaseFood newFood) {
        super(newFood);

    }
    @Override
    public int Price() {
        return super.Price() + 1300;
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
        return String.format("Mozzarella cheese, Smoked cheese, Trappist cheese,");
    }
}
