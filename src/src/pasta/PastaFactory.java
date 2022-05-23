public class PastaFactory implements AbstractFactory<BaseFood> {
    @Override
    public BaseFood create(String basefoodtype) {
        if ("CARBONARA".equalsIgnoreCase(basefoodtype)) {
            return new PastaCarbonara();
        } else if ("CHEESE".equalsIgnoreCase(basefoodtype)) {
            return new PastaCheese();
        } else if ("HAM".equalsIgnoreCase(basefoodtype)) {
            return new PastaHam();
        } else if ("BOLOGNESE".equalsIgnoreCase(basefoodtype)) {
            return new PastaBolognese();
        }

        return null;
    }
}
