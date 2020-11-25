import java.io.*;
import java.util.*;
public class SmallestWindowContainingSubstr{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        int n=str.length();
        String pattern=in.next();
        int k=pattern.length();
        int matchCount=0;
        //sliding window 
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:pattern.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int windowStart=0,min=Integer.MAX_VALUE,subStrStart=0;
        int countKey=map.size();
        for(int windowEnd=0;windowEnd<n;windowEnd++)
        {
            char ch=str.charAt(windowEnd);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                    matchCount++;
            }
            while(matchCount==countKey)//window is hit
            {
                if(min>windowEnd-windowStart+1)
                {
                    min=Math.min(min,windowEnd-windowStart+1);
                    subStrStart=windowStart;
                }
                char leftCh=str.charAt(windowStart++);
                if(map.containsKey(leftCh))
                {
                    if(map.get(leftCh)==0)
                        matchCount--;
                    map.put(leftCh,map.get(leftCh)+1);
                }
            }
        }
        System.out.println("Smallest Window Containing Substring "+(min==Integer.MAX_VALUE?"":str.substring(subStrStart,subStrStart+min)))
            ;
    }
}