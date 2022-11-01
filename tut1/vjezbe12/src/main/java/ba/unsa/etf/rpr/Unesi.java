package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class Unesi
{


    public static void main( String[] args )
    {
        java.util.Scanner ulaz = new java.util.Scanner(System.in);
        System.out.println( "Unesi n:\n" );
        int n=ulaz.nextInt();
        for (int i=1; i<=n; i++) if (DjeljivoSaSumom(i)) System.out.println(i);
    }

    private static boolean DjeljivoSaSumom(int n) {
        if (n==0) return false;
        int x=SumaSvojiCifara(n);
        return (n%x==0);
    }

    private static int SumaSvojiCifara(int n) {
        if (n<0) n*=-1;
        int t=0;
        while (n>0) {
            t+=n%10;
            n/=10;
        }
        return t;
    }
}
