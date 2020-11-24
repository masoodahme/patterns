//problem:  Longest Substring Without Repeating Characters
//link:https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.io.*;
import java.util.*;
public class NoRepeatSubString
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
                while(((windowEnd-windowStart+1)>0) && map.containsKey(ch))
                {
                    char ch1=str.charAt(windowStart);
                    map.put(ch1,map.get(ch1)-1);
                    if(map.get(ch1)==0)
                        map.remove(ch1);
                    windowStart++;
                  //  System.out.println("map = "+map.toString()+" window start "+windowStart+" windowEnd "+windowEnd+" inner ");
                }
                map.put(ch,1);
            }
            else
            {
                map.put(ch,1);
            }
            max=Math.max(max,windowEnd-windowStart+1);
           // System.out.println("map = "+map.toString()+" window start "+windowStart+" windowEnd "+windowEnd+" outer ");
        }
        System.out.println("Longest Substring Without Repeating Characters is "+max);
    }
}

