public class PizzaMargherita extends FoodDecorator {
    public PizzaMargherita(BaseFood newFood) {
        super(newFood);
    }

    @Override
    public int Price() {
        return super.Price() + 1200;
    }

    @Override
    public int Calories() {
        return super.Calories() + 300;
    }

    @Override
    public boolean Ishot() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Tomato base, Mozzarella cheese, Tomato"
        );
    }
}
