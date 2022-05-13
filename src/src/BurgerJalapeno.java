public class BurgerJalapeno implements BaseFood {
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
        return true;
    }
    @Override
    public String toString() {
        return String.format("%s; Jalapeno Toppings: bolognese, cheese, hot peppers Calories: %i; Price: %i; Hot: %b;",
                super.toString(), Calories(), Price(), Ishot()
        );
    }
}
