import java.util.*;
public class DirectedGraphsOps 
{
    static ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
    static Scanner sc= new Scanner(System.in);

    public static void createGraph()
    {
        
        System.out.println("Enter the no. of vertices and edges for the graph:");
        int v= sc.nextInt();
        int e= sc.nextInt();
        
        for(int i=0; i<=v; i++){
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter end vertices of all edges:");
        for(int i=1; i<=e; i++){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            adj.get(v1).add(v2);
        }
    }

    public static void printGraph()
    {
        System.out.println();
        int ver= adj.size()-1;
        for(int i=1; i<=ver; i++)
        {
            int edg= adj.get(i).size();
            for(int j=0; j<edg; j++)
            {
                System.out.print("{"+i+","+adj.get(i).get(j)+"} ");
            }
            System.out.println();
        }
    }

    public static boolean detectCycleUsingDFS()
    {
        int nov= adj.size()-1;
        boolean vis[]= new boolean[nov+1];
        Arrays.fill(vis,Boolean.FALSE);

        for(int u=1; u<=nov; u++)
        {
            if(vis[u]==false && isCyclePossibleDFS(u,-1,vis))
                return true;
        }
        return false;
    }

    public static boolean isCyclePossibleDFS(int u, int prev_u, boolean vis[])
    {
        vis[u]= true;
        for(int v: adj.get(u))
        {
            if(vis[v]==false)
                return isCyclePossibleDFS(v,u,vis);
            else if(v!=prev_u)
                return true;
        }
        return false;
    }

    public static void inDegreeCalculation(int[] indegree)
    {
        int nov= adj.size()-1;

        for(int u=1; u<=nov; u++)
        {
            for(int v: adj.get(u))
                indegree[v]++;
        }        
    }

    public static void TopoSort()
    {
        int nov= adj.size()-1;
        int indegree[]= new int[nov+1];
        Arrays.fill(indegree,0);

        Queue<Integer> q= new LinkedList<>();
        inDegreeCalculation(indegree);

        for(int i=1; i<=nov; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        while(!q.isEmpty())
        {
            int u= q.poll();
            System.out.print(u+" ");
            for(int v: adj.get(u))
            {
                if(indegree[v]>0)
                    indegree[v]--;
                if(indegree[v]==0)
                    q.add(v);
            }
        }
    }

    public static void main(String args[])
    {
        createGraph();
        printGraph();

        System.out.println();
        if(detectCycleUsingDFS())
            System.out.println("Cycle present is Graph");
        else
            System.out.println("No cycle found");

        TopoSort();
    }
}
