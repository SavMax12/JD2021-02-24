package by.it._classwork_.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }


    @Test
    public void addTest() throws CalcException {
        Var actualScalar = parser.calc("A=2+2+7+8");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 19.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void expressionScalar() throws CalcException {
        double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        assertEquals(7.3,actual,1e-5);
        actual = Double.parseDouble(parser.calc("B=A*3.5").toString());
        assertEquals(25.55,actual,1e-5);
        actual = Double.parseDouble(parser.calc("B1=B+0.11*-5").toString());
        assertEquals(25,actual,1e-5);
        actual = Double.parseDouble(parser.calc("B2=A/2-1").toString());
        assertEquals(2.65,actual,1e-5);

    }

    @Test
    public void expressionVectors() throws CalcException {
        Vector vector = (Vector)parser.calc("E={2,3}*(D/2)");
        double[] actual = vector.getValue();
        double[] expected = {10,15};
        assertArrayEquals(expected,actual,1e-5);

        Var actualVar1 = parser.calc("C=B+(A*2)");
        double actual1 = Double.parseDouble(actualVar1.toString());
        double expected1 = 40.15;
        assertEquals(expected1, actual1, 1e-5);

        Var actualVar2 = parser.calc("D=((C-0.15)-20)/(7-5)");
        actual1 = Double.parseDouble(actualVar2.toString());
        expected1 = 10;
        assertEquals(expected1, actual1, 1e-5);


    }

    @After
    public void tearDown() throws Exception {
    }
}