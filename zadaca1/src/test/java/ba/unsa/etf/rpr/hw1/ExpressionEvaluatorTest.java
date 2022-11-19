package ba.unsa.etf.rpr.hw1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ExpressionEvaluatorTest {


    @Test
    void evaluateTest1() {
        String s = "( ( ( 2 + 1 ) * ( 4 * 5 ) ) + 1 )";
        assertEquals(61D, ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest2(){
        String s = "( 7 + ( 1 / ( 1 / 3 ) ) )";
        assertEquals(10D, ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest3(){
        String s = "3.1416 + 3";
        assertEquals(6.1416, ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest4(){
        String s = "( 1 + sqrt ( 5 ) ) / 2";
        assertEquals((1+Math.sqrt(5))/2, ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest5(){
        /*test for subtraction ,i.e. 4 - 3 + 1 != 4 - 4 = 0
        * had to use round because the difference is 10^-10 */
        /*Technically might not be legal but easier than writing a parenthesis around every addition and subtraction*/
        String s = "( 4 - ( 4 / 3 ) + ( 4 / 5 ) - ( 4 / 7 ) + ( 4 / 9 ) - ( 4 / 11 ) + ( 4 / 13 ) )";
        assertEquals(Math.round((4 - 4. / 3 + 4. / 5 - 4. / 7 + 4. / 9 - 4. / 11 + 4. / 13)*100), Math.round(ExpressionEvaluator.evaluate(s)*100));
    }

    @Test
    void evaluateTest6() {
        /* small difference between sqrt(2)*sqrt(2) and 2*/
        String s = "sqrt ( 2 ) * sqrt ( 2 ) ";
        assertEquals(2D,Math.round(ExpressionEvaluator.evaluate(s)));
    }

    @Test
    void evaluateTest7(){
        /*missing operator test*/
        String s = "5 + 3 5";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest8(){
        /*missing number test*/
        String s = "( ( - ) * 4 )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest9(){
        String s = "( 1 + ( ( 2 + 3 ) * ) 4 * 5 ( ) )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    @Test
    void evaluateTest10(){
        String s = "( 4 * 3 ) ( 2 + 1) / ( 1 - 2 )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

}
