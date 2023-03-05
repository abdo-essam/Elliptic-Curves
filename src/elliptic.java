import java.math.BigInteger;
import java.util.Random;
import java.util.Vector;

public class elliptic {

    static int modInverse(double a, int m) {

        for (int x = 1; x < m; x++)
            if (((a % m) * (x % m)) % m == 1)
                return x;
        return 1;
    }

    public static void Double_and_Add(double x, double y, int H, int a, int p, Vector<Integer> v) {
        v.clear();
        double oldx = x;
        double oldy = y;
        String t = Integer.toBinaryString(H);

/*        for (int i = 1; i < t.length(); i++) {
            System.out.print(t.charAt(i));
        }*/
        System.out.println();
        for (int i = 1; i < t.length(); i++) {
            //System.out.println("Double " + "(" +x+"," + y+")" + " + " + "(" +x+"," + y+")");
            int inv = modInverse(2 * y, p);
            double s = (3 * Math.pow(x, 2) + a) * inv % p;
            double x3 = (Math.pow(s, 2) - x - x) % p;
            double y3 = (s * (x - x3) - y) % p;

            while (x3 < 0) {
                x3 += p;
            }
            while (y3 < 0) {
                y3 += p;
            }

            x = x3;
            y = y3;

            if (t.charAt(i) == '1') {
                //System.out.println("Add " + "(" +x+"," + y+")" + " + " + "(" +oldx+"," + oldy+")");
                //System.out.println();

                inv = modInverse((Math.abs(oldx-x)), p); // here we update
                //System.out.println("inv " + inv); // here we update

                if (oldx-x < 0) // here we update
                    inv = inv * -1;// here we update

                double sAdd = (oldy-y) * inv; // here we update
                //System.out.println("sAdd " + sAdd) ;
                double xnew = (Math.pow(sAdd, 2) - x - oldx) % p;
                double ynew = (sAdd * (x - xnew) - y) % p;

                while (xnew < 0) {
                    xnew += p;
                }
                while (ynew < 0) {
                    ynew += p;
                }

                x = xnew;
                y = ynew;
            }

        }
        int value = (int) x;
        int value2 = (int) y;
        v.add(value);
        v.add(value2);


    }

    /////////////////////////////////////

    public static void elgamal(int data, int i, int d, int p, int x1, int y1, Vector<Integer> v) {

        int a = 2;

        //Bob
        Double_and_Add(x1, y1, d, a, p, v);
        int B1 = v.get(0);
        int B2 = v.get(1);
        // System.out.println("B: "+B);


        //Alice
        //int i=getRandomNumber(2, p-2);
        Double_and_Add(x1, y1, i, a, p, v);
        int KE1 = v.get(0);
        int KE2 = v.get(1);

        //System.out.println("ke: "+KE);
        Double_and_Add(B1, B2, i, a, p, v);
        int KM1 = v.get(0);
        int KM2 = v.get(1);

        System.out.println("KM: "+KM1 +" "+KM2);
        int y = (data * KM1) % p;

        System.out.println("Encryption: "+y);


        //BOb
        Double_and_Add(KE1, KE2, d, a, p, v);
        int km_D1 = v.get(0);
        int km_D2 = v.get(1);

        System.out.println("KM_d: "+km_D1+" "+km_D2);

        int inv = modInverse(KM1, p);

        int dec = (y * inv) % p;

        System.out.println("dEncryption: "+dec);


    }

    /////////////////////////////////////


    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(2);

        int p = 20;
        int data = 5;
        int x1 = 5;
        int y1 = 1;
        Random rand = new Random();
        int i = (2) + rand.nextInt(((p - 1) - 2) + 1);
        int d = (2) + rand.nextInt(((p - 1) - 2) + 1);

        elgamal(data,i,d,p,x1,y1,v);
/*        for (int j = 2; j < 20 ; j++) {
            Double_and_Add(5, 1, j, 2, 17, v);
            System.out.print(j +"P = ");
            System.out.print("(" + v.get(0));
            System.out.print("," + v.get(1)+ ")" );
            System.out.println();

        }*/



    }

}
