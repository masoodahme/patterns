import java.io.*;
import java.util.*;
public class StringAnagram
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        int n=str.length();
        String pattern=in.next();
        int k=pattern.length();//K-->Window Size 
        //sliding window approach
        int i=0,j=0,count=0;
        HashMap<Character,Integer>map=new HashMap<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for(char ch:pattern.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        count=map.size();//no of characters in a pattern
        while(j<n)
        {
            char ch1=str.charAt(j);
            if(map.containsKey(ch1))
            {
                map.put(ch1,map.get(ch1)-1);
                if(map.get(ch1)==0)
                    count--;
            }
            if(j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            {
                char ch2=str.charAt(i);
                if(count==0)
                {
                    ans.add(i);
                }
                if(map.containsKey(ch2))
                {
                    if(map.get(ch2)==0)
                        count++;
                    map.put(ch2,map.get(ch2)+1);
                }
                i++;
                j++;
            }
        }
        System.out.println("List Of Indices of a anagram "+ans);
    }
}