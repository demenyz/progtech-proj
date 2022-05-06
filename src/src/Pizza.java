public class Pizza implements BaseFood {

   /* @Override
    public String toString() {
        return String.format("Pizza - %s; PizzaBase: %d; Toppings: %t;",
                super.toString()}*/

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
