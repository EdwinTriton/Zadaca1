package ba.unsa.etf.rpr.hw1;


public class App 
{
    public static void main( String[] args ) {
        try {
            StringBuilder stringer = new StringBuilder();
            /*Takes the individual strings from the cmd line and combines them all into one string with ' ' between*/
            for (String arg : args) stringer.append(arg).append(" ");

            /*The last space is unnecessary*/
            stringer.delete(stringer.length() - 1, stringer.length());

            String izraz = stringer.toString();
            System.out.println(izraz + " = " + ExpressionEvaluator.evaluate(izraz));
        } catch (Exception e) {
            System.out.println("Greska pri unosu");
        }
    }
}

