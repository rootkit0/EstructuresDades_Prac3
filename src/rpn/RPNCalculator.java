package rpn;

import data.*;
import java.util.StringTokenizer;

/**
 *
 * @author xbp1
 */
public class RPNCalculator {
    private final Stack<Integer> stack;
    
    public RPNCalculator() {
        this.stack = new DynamicStack<>();
    }
    
    public int evaluate(String input) throws EvaluationError, StackError {
        StringTokenizer tokens = new StringTokenizer(input, " ");
        int element1, element2;
        while(tokens.hasMoreTokens()) {
            String tokenActual = tokens.nextToken();
            if(isOperator(tokenActual)) {
                if(stack.size() < 2) {
                    throw new EvaluationError("No hi han prous elements a la pila");
                }
                else {
                    element1 = stack.top();
                    stack.pop();
                    element2 = stack.top();
                    stack.pop();
                    if(tokenActual.equals("+")) {
                        stack.push(element1 + element2);
                    }
                    else {
                        stack.push(element1 * element2);
                    }
                }
            }
            else if(isInteger(tokenActual)){
                stack.push(Integer.parseInt(tokenActual)); 
            }
            else {
                throw new EvaluationError("Hi han elements que no són ni enters ni operadors");
            }
        }
        return stack.top();
    }
    
    public boolean isOperator(String token) {
        return (token.equals("+") || token.equals("*"));
    }
    
    public static boolean isInteger(String token) {
        try { 
            Integer.parseInt(token); 
        }
        catch(NumberFormatException | NullPointerException e) { 
            return false; 
        }
        return true;
    }
}