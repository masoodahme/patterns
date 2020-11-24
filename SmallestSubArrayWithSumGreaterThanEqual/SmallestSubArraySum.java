//Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.
//Note: There is at least one subarray with sum greater than x
import java.io.*;
import java.util.*;
public class SmallestSubArraySum{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t--!=0)
		{   
            int n=in.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=in.nextInt();
            }
            int sum=in.nextInt();//given sum --> this can considered as window size (k)
            //sliding window approach
            int i=0,j=0;
            int length=0,minLength=Integer.MAX_VALUE;
            int val=0;
            while(j<n)
            {
                val+=arr[j];
                if(val<sum)
                {
                    j++;
                }
                else if(val>sum)
                {
                    minLength=Math.min(length,minLength);
                    while(val>sum)
                    {
                        val-=arr[i];
                         length=j-i+1;
                        minLength=Math.min(length,minLength);
                    }
                    i++;
                    j++;
                }
                length=j-i+1;
            }
            System.out.println("smallest subaray length with greater than sum is "+minLength+" val "+val);
        }
    }
}