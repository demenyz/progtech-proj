public class BurgerJalapeno implements BaseFood {
    @Override
    public int Price() {
        return 1200;
    }

    @Override
    public int Calories() {
        return 600;
    }

    @Override
    public boolean Ishot() {
        return true;
    }
    @Override
    public String toString() {
        return String.format("Beef, Bacon, Pickled jalapenos, Crispy fried onions, BBQ sauce ");
    }
}
