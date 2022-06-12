public class TowerOfHanoi
{
    public static void toh(int n, char from_rod, char to_rod, char aux_rod)
    {
        if(n==0)
        {
            return;
        }
        toh(n-1,from_rod,aux_rod,to_rod);
        System.out.println("Moved disk "+n+" from "+from_rod+" to "+to_rod);
        toh(n-1,aux_rod,to_rod,from_rod);
    }
    public static void main(String args[])
    {
        int n=3;
        char from_rod='A', to_rod='C', aux_rod='B';
        toh(n,from_rod,to_rod,aux_rod);
    }
}