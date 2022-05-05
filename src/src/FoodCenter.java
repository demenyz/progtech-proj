import java.sql.Array;
import java.util.ArrayList;

public class FoodCenter {
    private static FoodCenter instance;

    public static FoodCenter CreateInstance() throws Exception {
        if (instance!=null)
            throw new IllegalArgumentException("The instance can only be created once");
        instance = new FoodCenter();
        return instance;
    }

    public static FoodCenter GetInstance() throws  Exception {
        if (instance == null)
            throw new Exception("Please create instance first");
        return instance;
    }

    private ArrayList<BaseFood> foods = new ArrayList<>();
    public ArrayList<BaseFood> getFoods() {
        return new ArrayList<>(this.foods);
    }
    public String Install(){
        return "nincs kész";
    }
}
