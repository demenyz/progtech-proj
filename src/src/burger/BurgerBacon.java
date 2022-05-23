public class BurgerBacon implements BaseFood {
    @Override
    public int Price() {
        return 1600;
    }

    @Override
    public int Calories() {
        return 800;
    }

    @Override
    public boolean Ishot() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Beef, Mayo, Onions, Crispy bacon");
    }
}
