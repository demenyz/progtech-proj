public class BurgerRetro implements BaseFood {
    @Override
    public int Price() {
        return 1400;
    }

    @Override
    public int Calories() {
        return 700;
    }

    @Override
    public boolean Ishot() {
        return true;
    }

    @Override
    public String toString() {
        return "Beef, Onions, Garlic, Mustard, Lettuce, Cheese";
    }
}
