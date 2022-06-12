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

class BST
{
    Node root=null;

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

public class BSTOps 
{
    public static void main(String args[])
    {
        BST bst= new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(2);
        bst.insert(6);
        bst.insert(8);

        bst.delete(5);
        bst.delete(2);

        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
        
        System.out.println(bst.search(0));    
    }
        
}
