public class HamBurger extends BaseFood {
    private String Topping;
    private String MeatType;

    public String getTopping() {
        return Topping;
    }

    public void setTopping(String topping) {
        Topping = topping;
    }

    public String getMeatType() {
        return MeatType;
    }

    public void setMeatType(String meatType) {
        MeatType = meatType;
    }
    @Override
    public String toString() {
        return String.format("HamBurger - %s; Toppings: %t; MeatType: %h;",
                super.toString(),
                Topping,
                MeatType);
    }

}
