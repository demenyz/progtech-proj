public class PastaCarbonara implements BaseFood {
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
        return false;
    }

    @Override
    public String toString() {
        return "Pasta, Carbonara sauce, Ham";
    }
}
