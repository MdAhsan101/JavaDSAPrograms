import java.util.*;
public class ArrayOps 
{

    public static void main(String args[])
    {
        int arr[]={4,2,3,6,8,7,5,1,2,0};
        System.out.println(Arrays.binarySearch(arr, 2)); // return index value

        Arrays.sort(arr);

        for(Integer e: arr)
            System.out.print(e+" ");
        System.out.println();
        
        int brr[]= new int[10];
        Arrays.fill(brr, -1);
        for(Integer e: brr)
            System.out.print(e+" ");
    }
    
}
