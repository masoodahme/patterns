//problem link:https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

//Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.
import java.io.*;
import java.util.*;
public class CountOccurrencesAnagrams
{   
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //get the text
        String txt=in.next();
        //get the pattern
        String pat=in.next();
        //window size k
        int k=pat.length();
        int i=0,j=0;
        int n=txt.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int count=0;
        for(Character ch:pat.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)+1);
            }
            else
            {
                count++;
                map.put(ch,1);
            }
        }
        System.out.println("map elements initially "+map.toString()+" count "+count+" size k "+k+" i and j is "+i+" "+j);
        int counter=1;
        int ans=0;
        while(j<n)
        {
            if(map.containsKey(txt.charAt(j)))
            {
                int val=map.get(txt.charAt(j));
                map.put(txt.charAt(j),--val);
                if(map.get(txt.charAt(j))==0)
                {
                    System.out.println("count at  "+j);
                    count--;
                }
            }
            if(j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            {
                if(count==0)
                {
                    ans++;
                }
                if(map.containsKey(txt.charAt(i)))
                {
                    if(map.get(txt.charAt(i))==0)
                        count++;
                    map.put(txt.charAt(i),map.get(txt.charAt(i))+1);
                }
                i++;
                j++;
            }
            System.out.println("map elements after "+(counter++)+" "+map.toString()+" count is "+count+" size k "+k+" i and j is "+i+" "+j);
        }
        System.out.println("Count Occurrence is "+ans);
    }
}