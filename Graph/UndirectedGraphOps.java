import java.util.*;
class UndirectedGraphOps
{
    static ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
    static Scanner sc= new Scanner(System.in);

    public static void createGraph(int vertices, int edges)
    {
        for(int i=0; i<=vertices; i++)
        {
            adj.add(new ArrayList<Integer>());            
        }

        System.out.print("Enter end vertices of edge: \n");
        for(int i=1; i<=edges; i++)
        {
            int u= sc.nextInt();
            int v= sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public static void printGraph()
    {
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

    public static void BFS()
    {
        int s= adj.size();
        Boolean vis[]= new Boolean[s];
        Arrays.fill(vis, Boolean.FALSE);
        int nov= adj.size()-1;

        for(int i=1; i<=nov; i++)
        {
            if(vis[i]==false)
            {
                Queue<Integer> q= new LinkedList<>();
                q.add(i);
                vis[i]= true;
                while(!q.isEmpty())
                {
                    int u= q.poll();
                    System.out.print(u+" ");
                    for(Integer v: adj.get(u))
                    {
                        if(vis[v]==false)
                        {
                            q.add(v);
                            vis[v]= true;
                        }
                    }
                }
            }
        }
    }


    
    public static void DFS()
    {
        int nov= adj.size()-1;
        boolean[] vis_array= new boolean[nov+1];
        Arrays.fill(vis_array,Boolean.FALSE);
        for(int i=1; i<=nov; i++)
        {
            if(vis_array[i]==false)
            {
                DFS(vis_array,nov,i);
            }
        }
        System.out.println();
    }

    public static void DFS(boolean[] vis_array, int nov, int u)
    {
        vis_array[u]=true;
        System.out.print(u+" ");
        for(Integer v: adj.get(u))
        {
            if(vis_array[v]==false)
            {
                DFS(vis_array,nov,v);
            }
        }      

    }

    public static boolean detectCycleUsingBFS()
    {
        int nov= adj.size()-1;
        boolean vis[]= new boolean[nov+1];
        Arrays.fill(vis,Boolean.FALSE);
        for(int i=0; i<=nov; i++)
        {
            if(vis[i]==false && isCycleBFS(vis,nov,i,-1))
            {
                return true;
            }
        }
        return false;        
    }


    public static boolean isCycleBFS(boolean vis[], int nov, int vertex, int prev_vertex)
    {
        Queue<Integer> q1= new LinkedList<>();
        Queue<Integer> q2= new LinkedList<>();

        q1.add(vertex);
        q2.add(prev_vertex);

        vis[vertex]= true;

        while(!q1.isEmpty())
        {
            int u= q1.poll();
            int pu= q2.poll(); // pu= previous node to vertex 'u'

            for(int v: adj.get(u))
            {
                if(vis[v]==false)
                {
                    vis[v]=true;
                    q1.add(v);
                    q2.add(u);
                }
                else if(v!=pu)
                {
                    return true; // it means cycle is detected
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUsingDFS()
    {
        int nov= adj.size()-1;
        boolean vis[]= new boolean[nov+1];
        Arrays.fill(vis,Boolean.FALSE);

        for(int i=1; i<=nov; i++)
        {
            if(vis[i]==false && isCycleDFS(vis,nov,i,-1))
                return true;
        }
        return false;
    }

    public static boolean isCycleDFS(boolean vis[], int nov, int u, int prev_u)
    {
        if(vis[u]==true)
            return true;

        vis[u]= true;
        for(int v: adj.get(u))
        {
            if(v!=prev_u && isCycleDFS(vis,nov,v,u))
                return true;                         
        }
        return false;
    }

    public static boolean checkBipartiteBFS(int start_vertex)
    {
        int nov= adj.size()-1;
        int color[]= new int[nov+1];
        Arrays.fill(color, -1);
        
        Queue<Integer> q= new LinkedList<>();
        q.add(start_vertex);
        color[start_vertex]=0;

        while(!q.isEmpty())
        {
            int u= q.poll();
            for(int v: adj.get(u))
            {
                if(color[v]==-1)
                {
                    if(color[u]==0)
                        color[v]=1;
                    else if(color[u]==1)
                        color[v]=0;
                    q.add(v);
                }
                else if(color[v]==color[u])
                    return false;
            }
        }
        return true;
    }

      
    public static boolean checkBipartiteDFS(int u, int pu, int nov, int color[])
    {
        if(pu==-1)
            color[u]=0;

        for(int v:adj.get(u))
        {
            if(color[v]==-1){
                if(color[u]==0){
                    color[v]=1;
                }
                else
                    color[v]=0;

                return checkBipartiteDFS(v,u,nov,color);
            }
            else if(v!=pu && color[v]==color[u])
                return false;
        }
        return true;
    }

    public static int[] shortestDistanceCalc(int start_vertex)
    {
        int nov= adj.size()-1;
        int min_dist[]= new int[nov+1];
        Arrays.fill(min_dist, Integer.MAX_VALUE);

        Queue<Integer> q= new LinkedList<>();
        q.add(start_vertex);
        min_dist[start_vertex]=0;

        while(!q.isEmpty())
        {
            int u= q.poll();
            for(int v: adj.get(u))
            {
                if(min_dist[v]>(min_dist[u]+1)){
                    q.add(v);
                    min_dist[v]= (min_dist[u]+1);
                }
            }
        }

        return min_dist;
    }

    public static void main(String args[])
    {
        int v,e;
        System.out.println("Enter no. of vertices and edges for the graph: ");
        v= sc.nextInt();
        e= sc.nextInt();
        createGraph(v, e);
        System.out.println("Representation of graph in adjacency matrix:");
        printGraph();
        System.out.println("\nBFS Traversal is as follows:");
        BFS();
        System.out.println("\nDFS Traversal is as follows:");
        DFS();

        if(detectCycleUsingBFS())
        {
            System.out.println("Cycle present is Graph");
        }
        else{
            System.out.println("No cycle found");
        }

        if(detectCycleUsingDFS())
        {
            System.out.println("Cycle present is Graph");
        }
        else{
            System.out.println("No cycle found");
        }

        if(checkBipartiteBFS(1))
        {
            System.out.println("Graph is Bipartite");
        }
        else{
            System.out.println("Graph is not Bipartite");
        }

        int nov= adj.size()-1;
        int color[]= new int[nov+1];
        Arrays.fill(color, -1);
        if(checkBipartiteDFS(1,-1,nov,color))
        {
            System.out.println("Graph is Bipartite");
        }
        else{
            System.out.println("Graph is not Bipartite");
        }

        System.out.println("Shortest distance for graph with vertex from 1 to "+nov+" are as follows:");
        int min_dist[]= shortestDistanceCalc(1);
        for(int i=1; i<=nov; i++ )
            System.out.print(min_dist[i]+" ");
        System.out.println();
    }
}