//Longest K unique characters substring
//Given a string you need to print the size of the longest possible substring that has exactly k unique characters. If there is no possible substring print -1.
//link:https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring/0
import java.io.*;
import java.util.*;
public class LongestSubStrKDistictCharacters
{   
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String text=in.next();
        int n=text.length();
        int k=in.nextInt();
        //sliding window approach
        int windowStart=0;
        int val=0;
        boolean status=true;
        int max=Integer.MIN_VALUE,no_distinct=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int windowEnd=0;windowEnd<n;windowEnd++)
        {
            char ch=text.charAt(windowEnd);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)+1);
            }
            else
            {
                no_distinct++;
                map.put(ch,1);
            }
            while(no_distinct>k)
            {
                status=false;
                char startCh=text.charAt(windowStart++);
                map.put(startCh,map.get(startCh)-1);
                if(map.get(startCh)==0)
                {
                    map.remove(startCh);
                    no_distinct--;
                }
            }
            max=Math.max(windowEnd-windowStart+1,max);
        }
        if(no_distinct==k)
        {
            System.out.println(max);  
        }
        else
        {
             System.out.println((status==true)?-1:max);   //if k distinct is more than text then print -1
        }
       // System.out.println("Longest K unique characters substring is "+max);
    }
}