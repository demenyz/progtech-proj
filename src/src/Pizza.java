public class Pizza extends BaseFood {
    private String PizzaBase;
    private String Topping;

    public String getPizzaBase() {
        return PizzaBase;
    }
    public void setPizzaBase(String pizzaBase) {
        PizzaBase = pizzaBase;
    }
    public String getTopping() {
        return Topping;
    }
    public void setTopping(String topping) {
        Topping = topping;
    }
    public Pizza() {
    }


    @Override
    public String toString() {
        return String.format("Pizza - %s; PizzaBase: %d; Toppings: %t;",
                super.toString(),
                PizzaBase,
                Topping);
    }
}
