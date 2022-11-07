package ba.unsa.etf.rpr;

public class KonzolnaSin {
    public static void main(String[] args) {
        int n=Integer.parseInt(args[0]);
        double x=Math.sin(n);
        int y=Faktorijal(n);
        System.out.printf("Sinus od %d je %f, a faktorijal je %d",n,x,y);
    }

    private static int Faktorijal(int i) {
        int t=1;
        for (int k=1; k<=i; k++) t*=k;
        return t;
    }
}


