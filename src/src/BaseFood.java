public abstract class BaseFood implements Cloneable {
    private static int ID = 1;

    public BaseFood() { setId(BaseFood.ID++) ;}
    private int id;
    private double price;
    private double calories;

    public boolean isHot() {
        return IsHot;
    }

    public void setHot(boolean hot) {
        IsHot = hot;
    }

    private boolean IsHot;

    public int getId() {return id;}
    public void setId(int id) {this.id=id;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public double getCalories() {return calories;}
    public void setCalories(double calories) {this.calories = calories;}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return String.format("Id: %d; Price: %p; Calories: %c;",
                id,
                price,
                calories);
    }
}
