public class BurgerBacon implements BaseFood {
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
