public class Pizza implements BaseFood {

    public String toString() {
        return String.format("Pizza type:");}

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
