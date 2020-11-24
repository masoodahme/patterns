import java.io.*;
import java.util.*;
public class maximumSubArraySum
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        System.out.println("Size of Window is ");
        int k=in.nextInt();
        int i=0,j=0;
        int sum=0,max=0;
        while(j<n)
        {
            sum+=arr[j];
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
                max=Math.max(sum,max);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        System.out.println("maximum sum in subArray is "+max);
    }
}