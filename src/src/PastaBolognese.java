public class PastaBolognese implements BaseFood {
    @Override
    public int Price() {
        return 1500;
    }

    @Override
    public int Calories() {
        return 800;
    }

    @Override
    public boolean Ishot() {
        return true;
    }

    @Override
    public String toString() {
        return "Pasta, Bolognese sauce, Minced meat, Cheese";
    }
}
