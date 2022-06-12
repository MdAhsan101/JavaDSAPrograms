import java.util.*;

public class QuickSortProg 
{
    public void swap(int arr[],int i, int j) // index as parameter
    {
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
    public int partition(int arr[],int low, int high)
    {
        int pivot= arr[low];
        int i= low, j= high;

        while(i<j)
        {
            do
            {
                i++;
            }while(i<high && arr[i]<=pivot);
    
            do
            {
                j--;
            }while(j>=0 && arr[j]>pivot);
            
            if(i<j)
            {
                swap(arr,i,j); // index is used as parameter for swapping         
            }
        }

        swap(arr,low,j);
        return j;

    }    

    public void quickSort(int arr[],int low, int high)
    {
        if(low<high)
        {
            int j= partition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j+1, high);
        }
    }

    public static void main(String args[])
    {
        int arr[]= {4,3,2,6,7,1};
        QuickSortProg qs= new QuickSortProg();
        qs.quickSort(arr, 0, arr.length);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
    
}
