package test;

import data.*;
import rpn.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author xbp1
 */
public class RPNCalculatorTest {
    
    @Test
    public void test() throws EvaluationError, StackError {
        RPNCalculator calc = new RPNCalculator();
        
        //5+((1+2)*4)
        System.out.println("Expressió algebraica: 5+((1+2)*4)");
        String prova1 = "5 1 2 + 4 * +";
        System.out.println("En notació polaca: " + prova1);
        int resultat1 = 17;
        assertEquals(calc.evaluate(prova1), resultat1);
        System.out.println("Resultat: " + resultat1 + "\n");
        
        //4*(3+2)
        System.out.println("Expressió algebraica: 4*(3+2)");
        String prova2 = "4 3 2 + *";
        System.out.println("En notació polaca: " + prova2);
        int resultat2 = 20;
        assertEquals(calc.evaluate(prova2), resultat2);
        System.out.println("Resultat: " + resultat2 + "\n");
        
        //1*(4*-3)+2
        System.out.println("Expressió algebraica: 1*(4*-3)+2");
        String prova3 = "1 4 -3 * 2 + 1 *";
        System.out.println("En notació polaca: " + prova3);
        int resultat3 = -10;
        assertEquals(calc.evaluate(prova3), resultat3);
        System.out.println("Resultat: " + resultat3 + "\n");
    }
}
