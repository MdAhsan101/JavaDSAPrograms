class Node
{
    int data;
    Node left;
    Node right;

    Node(int d)
    {
        data= d;
        left= null;
        right= null;
    }
};

class AVLTree
{
    Node root=null;

    public int height(Node n)
    {
        if(n==null)
            return 0;

        int l_ht= height(n.left);
        int r_ht= height(n.right);

        return Math.max(l_ht,r_ht)+1;
    }

    public int balanceFactor(Node n)
    {
        int left_subtree_ht= (n!=null && n.left!=null) ? height(n.left):0;
        int right_subtree_ht= (n!=null && n.right!=null) ? height(n.right):0;
        return (left_subtree_ht-right_subtree_ht);
    }

    public Node LLRotation(Node n)
    {
        Node lc= n.left;
        Node lrc= lc.right;

        n.left= lrc;
        lc.right= n;

        return lc;
    }

    public Node RRRotation(Node n)
    {
        Node rc= n.right;
        Node rcl= rc.left;

        n.right= rcl;
        rc.left= n;
        
        return rc;
    }

    public Node LRRotation(Node n)
    {
        Node lc= n.left, lrc= lc.right;
        
        lc.right= lrc.left;
        n.left= lrc.right;

        lrc.left= lc;
        lrc.right= n;

        return lrc;        
    }

    public Node RLRotation(Node n)
    {
        Node rc= n.right;
        Node rlc= n.right.left;
        
        n.right= rlc.left;
        rc.left= rlc.right;        

        rlc.left= n;
        rlc.right= rc;

        return rlc;
    }

    public void insert(int val)
    {
        root= insert(root,val);        
    }
    private Node insert(Node n, int val) // Method Overriding
    {
        if(n==null)
        {
            n= new Node(val);
            return n;
        }

        if(val<=n.data)
        {
            n.left= insert(n.left,val);
        }
        else
        {
            n.right= insert(n.right,val);
        }
        
        if(balanceFactor(n)==2)
        {
            if(balanceFactor(n.left)==1)
                return LLRotation(n);

            else
                return LRRotation(n);
        }
        
        if(balanceFactor(n)==-2)
        {
            if(balanceFactor(n.right)==-1)
                return RRRotation(n);

            else
                return RLRotation(n);
        }

        return n;
    }

    public boolean search(int val)
    {
        return search(root,val);
    }
    private boolean search(Node n, int val)
    {
        if(n==null)
            return false;
        
        if(val<n.data)
            return search(n.left,val);
            
        else if(val>n.data)
            return search(n.right,val);
        else
            return true;
    }

    public void delete(int key)
    {
        root= delete(root,key);
    }
    private Node delete(Node n, int key)
    {
        if(n==null)
            return null;

        if(key<n.data)
            n.left= delete(n.left, key);
        else if(key>n.data)
            n.right= delete(n.right, key);
        else
        {   
            // When node to be deleted has single or no child
            if(n.left==null)
                return n.right;
            else if(n.right==null)
                return n.left;
            
            // When node to be deleted has two childs
            n.data= inorderSuccessor(n.right);
            n.right= delete(n.right,n.data);
        }
        return n;
    }

    int inorderSuccessor(Node n)
    {
        // int succ_val=n.data;
        // while(n!=null)
        // {
        //     succ_val=n.data;
        //     n= n.left;            
        // }
        // return succ_val;

        if(n.left==null)
            return n.data;
        return inorderSuccessor(n.left);
    }

    public void preOrder()
    {
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node n)
    {
        if(n==null)
            return;
        
        System.out.print(n.data+" ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public void inOrder()
    {
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node n)
    {
        if(n==null)
            return;
        
        inOrder(n.left);
        System.out.print(n.data+" ");
        inOrder(n.right);
    }

    public void postOrder()
    {
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node n)
    {
        if(n==null)
            return;
        
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.data+" ");
    }
}

public class AVL 
{
    public static void main(String args[])
    {
        AVLTree avl= new AVLTree();
        avl.insert(5);
        avl.insert(3);
        avl.insert(2);
        // avl.insert(1);
        // avl.insert(2);
        // avl.insert(6);
        // avl.insert(8);

        // avl.delete(5);
        // avl.delete(2);

        avl.preOrder();
        avl.inOrder();
        avl.postOrder();
        
        //System.out.println(avl.search(0));    
    }
        
}
