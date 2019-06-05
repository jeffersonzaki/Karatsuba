import javax.swing.*;

//for multiplication
public class Karatsuba {

    public static String output = "\nUsing Karatsuba multiplication algorithm.";

    public static int getSize(long n){
        int kntr = 0;

        while(n != 0){
            kntr++;
            n = n / 10;
        }
        return kntr;
    }

    public static long multiply(long x, long y){

        int size1 =  getSize(x);
        int size2 =  getSize(y);

        //find out which one is bigger
        int n = Math.max(size1, size2);
        if(n < 10) {
            return x * y;
        }

        n = (n/2) + (n%2);
        long m = (long)Math.pow(10, n);
        long b = x/m;
        long a = x - (b * m);
        long d = y/m;
        long c = y - (d * n);

        long z0 = multiply(a, c);
        long z1 = multiply(a+b, c+d);
        long z2 = multiply(b,d);

        return z0 + (z1 - z0 - z2) * m  + z2 * (long)(Math.pow(10, 2 * n));

    }




    // * Main Method * //
    public static void main(String[] args) {

        while(true){

            long num1 = Long.parseLong(JOptionPane.showInputDialog("\nEnter first number e.g. 7867"));
            long num2 = Long.parseLong(JOptionPane.showInputDialog("\nEnter second number e.g. 9750"));

            output += " " + num1 + " * " + num2 + " = " + multiply(num1, num2);

            //print.
            JOptionPane.showMessageDialog(null, output);
        }
    }
}
