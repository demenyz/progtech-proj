public class BurgerCheese implements BaseFood {


    @Override
    public String toString() {
        return String.format("Beef, Lettuce, Tomato, Onion, Pickles, Mayo, Ketchup, Cheese");
    }

    @Override
    public int Price() {
        return 1000;
    }

    @Override
    public int Calories() {
        return 500;
    }

    @Override
    public boolean Ishot() {
        return false;
    }
}
