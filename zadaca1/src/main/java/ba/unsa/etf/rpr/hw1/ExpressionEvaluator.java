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
        String c;
        Stack<Double> values=new Stack<>();
        Stack<String> operators=new Stack<>();
        Boolean wasNumber= Boolean.FALSE;
        for (String theSymbol : theSymbols) {
            c = theSymbol;
            if (c.equals("(")) continue;
            else if ((c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) && wasNumber) {
                operators.push(c);
                wasNumber = false;
            } else if (c.equals("sqrt") && !wasNumber) {
                operators.push(c);
            } else if (Character.isDigit(c.charAt(0))) {
                values.push(Double.parseDouble(c));
                wasNumber = true;
            } else if (c.equals(")") && wasNumber) {
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
            case "+" -> v+=values.pop();
            case "-" -> v-=values.pop();
            case "*" -> v*=values.pop();
            case "/" -> v/=values.pop();
            case "sqrt" -> v=sqrt(v);
        }
        values.push(v);
    }
}
