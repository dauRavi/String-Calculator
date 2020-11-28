/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringcalculator;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
/**
 *
 * @author RAVI
 */
@Test
public class TestStringCalculator {
    
    private StringCalculator calculator;
    
    @BeforeTest
    public void init(){
        calculator= new StringCalculator();
    }
    
    public void forEmptyString() throws Exception{
        assertEquals(calculator.calculate(""), 0);
    }
    
    public void forSingleValue() throws Exception{
        assertEquals(calculator.calculate("1"), 1);
    }
     
    public void forTwoNumbersCommaDelimiter() throws Exception{
        assertEquals(calculator.calculate("1,2"), 3);
    }
    
     public void forThreeNumbers() throws Exception{
        assertEquals(calculator.calculate("1,2,3"), 6);
    }
    
    
    public void forTwoNumbersNewLineDelimiter() throws Exception{
        assertEquals(calculator.calculate("1\n2,3"), 6);
    }
    
    @Test(expectedExceptions = Exception.class)
    public void forNegativeNumbers() throws Exception{
        calculator.calculate("-1");
    }
    
    public void ignoreIfNumbersGreaterThan1000() throws Exception{
        assertEquals(calculator.calculate("10,10,1001"), 20);
    }
}
