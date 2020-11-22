//problem: Fruit Into Baskets
//link:https://leetcode.com/problems/fruit-into-baskets/
import java.io.*;
import java.util.*;
public class FruitsIntoBaskets
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();//size of array
        char fruits[]=new char[n];
        for(int i=0;i<n;i++)
        {
            fruits[i]=in.next().charAt(0);
        }
        //sliding window approach
        //window size 
        int k=2;//only 2 basket is allowed
        int windowStart=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int windowEnd=0;windowEnd<n;windowEnd++)
        {
            char ch=fruits[windowEnd];
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>2)
            {   
                char startCh=fruits[windowStart];
                map.put(startCh,map.get(startCh)-1);
                if(map.get(startCh)==0)
                    map.remove(startCh);
                windowStart++;
            }
            max=Math.max(max,windowEnd-windowStart+1);
        }
        System.out.println("maximum number of fruits "+max);
    }
}
