public class Pizza extends BaseFood {
    private String PizzaBase;
    private String Topping;
    private Boolean ISHot;

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
    public Boolean getISHot() {
        return ISHot;
    }
    public void setISHot(Boolean ISHot) {
        this.ISHot = ISHot;
    }

    public Pizza() {
    }


    @Override
    public String toString() {
        return String.format("Pizza - %s; PizzaBase: %d; Toppings: %t; IsHot: %h;",
                super.toString(),
                PizzaBase,
                Topping,
                ISHot);
    }
}
