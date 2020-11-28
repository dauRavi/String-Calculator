/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringcalculator;

import java.util.regex.Pattern;

/**
 *
 * @author RAVI
 */
public class StringCalculator {
    
    private String delimter = ",|\n";
    public int calculate(String input) throws Exception{
       String[] numbers=input.split(delimter);          
        if(isEmpty(input)){
            return 0;
        }
        if(input.length()==1){
            return stringToInt(input);
        }
        else {
            return add(numbers);
        }
    }
    
    public int add(String[] numbers) throws Exception{
        forNegatives(numbers);
        return calculateValues(numbers);
    }
    
    private int calculateValues(String[] numbers){
         int sum=0;
           for(String i:numbers){
            if(stringToInt(i)>1000){
                continue;
            }
            sum=sum+stringToInt(i);
        }
           return sum;
    }
    private void forNegatives(String[] numbers) throws Exception{
        for(String i:numbers){
            if(stringToInt(i)<0){
                throw new Exception("negatives not allowed");
            }
        }
    }
    
    private boolean isEmpty(String input){
        return input.isEmpty();
    }
    
    private int stringToInt(String input){
        return Integer.parseInt(input);
    }
}
