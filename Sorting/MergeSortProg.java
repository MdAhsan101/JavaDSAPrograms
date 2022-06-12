public class MergeSortProg
{
    public void merge(int arr[], int l, int m, int r)
    {
        int s1= m-l+1; // size of left part of array
        int s2= r-m;  // size of right part of array
        
        int left[]= new int[s1];
        int right[]= new int[s2];

        for(int i=0; i<s1; i++)
            left[i]= arr[l+i];
        
        for(int j=0; j<s2; j++)
            right[j]= arr[m+1+j];
        
        int i=0,j=0,k=0;
        
        while(i<s1 && j<s2)
        {
            if(left[i]<right[j])
            {
                arr[l+k]= left[i];
                i++;
                k++;
            }
            else
            {
                arr[l+k]= right[j];
                j++;
                k++;
            }
        }

        while(i<s1)
        {
            arr[l+k]= left[i];
            i++;
            k++;
        }

        while(j<s2)
        {
            arr[l+k]= right[j];
            j++;
            k++;
        }
    }

    public void quickSort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int mid= (l+r)/2;
            quickSort(arr, l, mid);
            quickSort(arr, mid+1, r);
            merge(arr,l,mid,r);
        }
    }

    public static void main(String args[])
    {
        int arr[]={5,3,2,8,6,1,7,4};
        MergeSortProg ms= new MergeSortProg();
        ms.quickSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }

}