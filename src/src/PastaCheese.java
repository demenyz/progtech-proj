public class PastaCheese implements BaseFood {
    @Override
    public int Price() {
        return 1300;
    }

    @Override
    public int Calories() {
        return 400;
    }

    @Override
    public boolean Ishot() {
        return false;
    }

    @Override
    public String toString() {
        return "Pasta, Cheese, Cheddar, Spring onion ";
    }
}
