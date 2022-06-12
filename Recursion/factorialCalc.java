import java.util.Scanner;

public class factorialCalc
{
    public static long myfact(int num)
    {
        if(num>1)
        {
            return num*myfact(num-1);
        }
        else
            return 1;
    }

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num= sc.nextInt();
        long fact= myfact(num);
        System.out.println("Factorial value is "+fact);
        sc.close();
    }
}