//SmallestSubArrayGivenSum
//Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than or equal to the given value
//link:https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x/0
import java.io.*;
import java.util.*;
public class SmallestLengthSubArr
{   
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        int sum=in.nextInt();//given sum
        int windowStart=0;
        int val=0;
        int min=Integer.MAX_VALUE;
        for(int windowEnd=0;windowEnd<n;windowEnd++)
        {
            val+=arr[windowEnd];
            while(val>=sum)
            {
                min=Math.min(min,windowEnd-windowStart+1);
                val-=arr[windowStart];
                windowStart++;
            }
        }
        System.out.println("min length subarray is "+min);
    }
}