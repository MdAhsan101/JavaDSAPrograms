import java.util.*;
class Pair
{
    private int v;
    private int w;
    
    Pair(int _v, int _w){
        v= _v;
        w= _w;
    }

    int getV(){
        return v;
    }

    int getW(){
        return w;
    }
}


public class DirectedWeigthedGraphOps 
{
    static ArrayList<ArrayList<Pair>> adj= new ArrayList<ArrayList<Pair>>();
    static Scanner sc= new Scanner(System.in);
    
    public static void createGraph()
    {
        
        System.out.println("Enter the no. of vertices and edges for the graph:");
        int v= sc.nextInt();
        int e= sc.nextInt();
        
        for(int i=0; i<=v; i++){
            adj.add(new ArrayList<Pair>());
        }

        System.out.println("Enter end vertices (v1, v2) of all edges with weight (w) :");
        for(int i=1; i<=e; i++){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            int w= sc.nextInt();
            adj.get(v1).add(new Pair(v2, w));
        }
    }

    public static void inDegreeCalculation(int[] indegree)
    {
        int nov= adj.size()-1;

        for(int u=1; u<=nov; u++)
        {
            for(Pair pr: adj.get(u))
            {
                int v= pr.getV();
                indegree[v]++;
            }
        }        
    }

    public static ArrayList<Integer> TopoSort()
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

        ArrayList<Integer> list= new ArrayList<>();
        while(!q.isEmpty())
        {
            int u= q.poll();
            list.add(u);
            for(Pair pr: adj.get(u))
            {
                int v=pr.getV();
                if(indegree[v]>0)
                    indegree[v]--;
                if(indegree[v]==0)
                    q.add(v);
            }
        }
        return list;
    }

    public static void shortestDistanceDAG(int src_vertex)
    {
        ArrayList<Integer> toposort= TopoSort();

        int nov= adj.size()-1;
        int dist[]= new int[nov+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[src_vertex]= 0;

        for(int u: toposort){
            for(Pair pr_v: adj.get(u)){
                int v= pr_v.getV();
                int w= pr_v.getW();
                System.out.println(dist[v]+","+(dist[u]+w));
                if(dist[v]>(dist[u]+w)){
                    dist[v]= (dist[u]+w);
                    System.out.println(dist[u]+w);
                }
            }
        } 

        System.out.println("Distance of each vertice from the vertex "+src_vertex+" are as follows:");
        for(int i=1; i<=nov; i++)
            System.out.print(dist[i]+" ");
        System.out.println();
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
                System.out.print("{"+i+","+adj.get(i).get(j).getV()+"} ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        createGraph();
        System.out.println();
        System.out.println("Graph Print:");
        printGraph();

        System.out.print("Enter the source vertex:");
        shortestDistanceDAG(1);
    }
    
}

