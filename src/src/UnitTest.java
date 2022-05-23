import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class UnitTest {
        @Before
        public void setUp() throws Exception {
        Container.prices.add(1000);
        Container.prices.add(1500);
     }
        @Test
        public void testAdd() throws Exception {
        Assert.assertEquals(2500, FormBase.sumOfPrices((ArrayList<Integer>) Container.prices) );
    }

}