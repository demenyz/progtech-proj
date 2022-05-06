public class PizzaMargherita extends FoodDecorator {
    public PizzaMargherita(BaseFood newFood) {
        super(newFood);
    }

    @Override
    public int Price() {
        return super.Price() + 500;
    }

    @Override
    public int Calories() {
        return super.Calories() + 200;
    }

    @Override
    public boolean Ishot() {
        return false;
    }
}
