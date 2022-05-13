public class BurgerCheese implements BaseFood {


    @Override
    public String toString() {
        return String.format("HamBurger - Toppings: MeatType:");
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
