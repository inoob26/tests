import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.otheralgor.unitTests.Calc;
import org.otheralgor.unitTests.IListiner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class calcTest {
    private Calc calc = null;

    @Test
    public void testDiv(){
        int res = calc.add(2,5);
        assertEquals(7,res);
        assertTrue("ha-ha",res==7);
        /*if (res != 6){
            fail("Ha-ha!");
        }*/

        System.out.println(new Calc().div(5,2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivException(){
        calc.div(2,0);
    }

    @Before
    public void setup(){
        if (calc == null) {
            calc = new Calc();
        }
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after");
    }


}
