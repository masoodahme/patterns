
//Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
//link:https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0#
import java.io.*;
import java.util.*;
public class FirstNegative
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
        Queue<Integer>q=new LinkedList<Integer>();
        System.out.println("First Negative in window Size "+k);
        while(j<n)
        {
            if(arr[j]<0)
                q.add(arr[j]);
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
               if(q.isEmpty())
               {
                    System.out.print(0+" ");

               }
               else
               {
                 System.out.print(q.peek()+" ");
                 if(q.peek()==arr[i])
                    q.poll();
               }
                i++;
                j++;
            }
        }
        
    }
}