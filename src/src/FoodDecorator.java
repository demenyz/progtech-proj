public class FoodDecorator implements BaseFood {


    private BaseFood newFood;

    public FoodDecorator(BaseFood newFood) {
        this.newFood = newFood;
    }

    @Override
    public int Price() {
        return newFood.Price();
    }

    @Override
    public int Calories() {
        return newFood.Calories();
    }

    @Override
    public boolean Ishot() {
        return newFood.Ishot();
    }
}
