public class BurgerFactory implements AbstractFactory<BaseFood> {
    @Override
    public BaseFood create(String basefoodtype) {
        if ("CHEESE".equalsIgnoreCase(basefoodtype)) {
            return new BurgerCheese();
        } else if ("JALAPENO".equalsIgnoreCase(basefoodtype)) {
            return new BurgerJalapeno();
        } else if ("RETRO".equalsIgnoreCase(basefoodtype)) {
            return new BurgerRetro();
        } else if ("BACON".equalsIgnoreCase(basefoodtype)) {
            return new BurgerBacon();
        }

        return null;
    }
}
