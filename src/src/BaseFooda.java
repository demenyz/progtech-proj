public abstract class BaseFooda {

    private double price;
    private double calories;
    private boolean IsHot;

    public boolean isHot() {
        return IsHot;
    }
    public void setHot(boolean hot) {
        IsHot = hot;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public double getCalories() {return calories;}
    public void setCalories(double calories) {this.calories = calories;}

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    public String toString()
    {
        return String.format("Price: %p; Calories: %c;",
                price,
                calories);
    }
}
