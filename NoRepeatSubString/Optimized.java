//problem:  Longest Substring Without Repeating Characters
//link:https://leetcode.com/problems/longest-substring-without-repeating-characters/
//optimized window sliding
import java.io.*;
import java.util.*;
public class NoRepeatSubStringOPtimized
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        //sliding window approach
        int n=str.length();
        int windowStart=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int windowEnd=0;windowEnd<n;windowEnd++)
        {
            char ch=str.charAt(windowEnd);
            if(map.containsKey(ch)) //window hit 
            {
                windowStart=Math.max(windowStart,map.get(ch)+1);
            }
            map.put(ch,1);
            max=Math.max(max,windowEnd-windowStart+1);
        }
        System.out.println("Longest Substring Without Repeating Characters is "+max);
    }
}