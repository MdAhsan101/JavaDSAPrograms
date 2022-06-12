import java.util.*;

public class Fibonacci
{
    static int n1=0, n2=1, n3=0, fibsum=1;

    public static void fibonacciCalc(int count)
    {
        if(count>0)
        {
            n3= n1+n2;
            fibsum+=n3;
            n1=n2;
            n2=n3;
            System.out.print(n3+" ");
            fibonacciCalc(count-1);
        }
    }
    public static void main(String args[])
    {
        System.out.print("Enter the count value: ");
        Scanner scan= new Scanner(System.in);
        int count= scan.nextInt() - 2;
        scan.close();
        if(count>0)
        {
            System.out.print(n1+" "+n2+" ");
            fibonacciCalc(count);
            System.out.println("\nFibonacci sum is "+ fibsum);
        }
        else
        {
            System.out.println("Enter larger value for count.");
        }
    }
}