public class PizzaUngarische extends FoodDecorator {
    public PizzaUngarische(BaseFood newFood) {
        super(newFood);
    }

    @Override
    public int Price() {
        return super.Price() + 1400;
    }

    @Override
    public int Calories() {
        return super.Calories() + 800;
    }

    @Override
    public boolean Ishot() {
        return true;
    }
    @Override
    public String toString() {
        return String.format("Hot sausage, Cheese, Salami, Pepperoni, Hot peppers");
    }
}
