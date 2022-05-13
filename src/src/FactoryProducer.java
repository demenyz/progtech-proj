public class FactoryProducer {
    public static AbstractFactory getFactory(boolean burger){
        if(burger){
            return new BurgerFactory();
        }else{
            return new PastaFactory();
        }
    }
}
}
