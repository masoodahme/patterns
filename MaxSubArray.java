import java.io.*;
import java.util.*;
public class MaxSubArray{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=in.nextInt();
        }
        int k=in.nextInt();

        //sliding window approach
        int i=0,j=0;
        //final answer 
        ArrayList<Integer>finArr=new ArrayList<>();
        LinkedList<Integer>q=new LinkedList<Integer>();
        while(j<n)
        {
            System.out.println("size "+q.size()+"j value is "+j+" i value is "+i+" queue "+q);
            //calculation
            if(q.isEmpty())
                q.addFirst(j);
            else
            {
                while(q.size()!=0 && nums[q.peekLast()]<=nums[j])
                {
                    //System.out.println("size "+q.size());
                    q.removeLast();
                }
               // System.out.println("end");
                q.addLast(j);
            }
            if(j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            { 
                //answer 
                finArr.add(nums[q.peekFirst()]);
                if(i==q.peekFirst())
                    q.removeFirst();
                //sliding the window
                i++;
                j++;
            }
          //  System.out.println("final result array is "+finArr.toArray());
        }
        System.out.println("final result array is "+finArr);
    }
}