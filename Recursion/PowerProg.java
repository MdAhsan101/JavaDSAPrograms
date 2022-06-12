import java.util.*;

public class PowerProg
{
    public static double powerCalc(double b, int p)
    {
        if(p==0)
            return 1;
        return b*powerCalc(b,p-1);
    }
    public static void main(String args[])
    {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter base value : ");
        double base= scan.nextDouble();
        System.out.print("Enter power value : ");
        int power= scan.nextInt();
        double ans= powerCalc(base,power);
        System.out.print("Ans : "+ans);
        scan.close();
    }
}