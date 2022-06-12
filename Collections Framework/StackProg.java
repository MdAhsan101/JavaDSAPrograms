import java.util.*;

public class StackProg 
{
    public static void main(String args[]) 
    {
        Stack<Integer> stk= new Stack<>();

        stk.push(1);
        stk.push(2);
        stk.push(0);
        stk.push(3);
        
        System.out.println(stk);

        System.out.println(stk.peek());
        System.out.println();

        while(!stk.isEmpty())
        {
            System.out.print(stk.peek()+" ");
            stk.pop();
        }

    }   
}
