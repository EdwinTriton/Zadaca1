package ba.unsa.etf.rpr.hw1;

import java.util.Stack;

import static java.lang.Math.sqrt;

public class ExpressionEvaluator {
    /**
     *
     * @param expression
     * The method evaluate implements Dijkstra's two-stack algorithm to calculate a math expression
     * @return The result of expression
     */
    public static Double evaluate(String expression) {
        String[] theSymbols=expression.split(" ");
        Stack<Double> values=new Stack<>();
        Stack<String> operators=new Stack<>();
        Boolean wasNumber= Boolean.FALSE;
        for (String theSymbol : theSymbols) {
            if (theSymbol.equals("(")) continue;
            else if ((theSymbol.equals("+") || theSymbol.equals("-") || theSymbol.equals("*") || theSymbol.equals("/")) && wasNumber) {
                operators.push(theSymbol);
                wasNumber = false;
            } else if (theSymbol.equals("sqrt") && !wasNumber) {
                operators.push(theSymbol);
            } else if (!wasNumber && Character.isDigit(theSymbol.charAt(0))) {
                values.push(Double.parseDouble(theSymbol));
                wasNumber = true;
            } else if (theSymbol.equals(")") && wasNumber) {
                operiraj(values, operators);
            } else throw new RuntimeException();
        }
        while (!operators.empty()) {
            operiraj(values, operators);
        }
        return values.pop();
    }

    private static void operiraj(Stack<Double> values, Stack<String> operators) {
        String operator=operators.pop();
        double v=values.pop();
        switch (operator) {
            case "+" -> {
                if (operators.empty() || !operators.peek().equals("-")) v += values.pop();
                else v=values.pop() - v;
            }
            case "-" -> {
                if (operators.empty() || !operators.peek().equals("-")) v = values.pop() - v;
                else v += values.pop();
            }
            case "*" -> v*=values.pop();
            case "/" -> v=values.pop()/v;
            case "sqrt" -> v=sqrt(v);
        }
        values.push(v);
    }
}
