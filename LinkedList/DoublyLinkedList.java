public class DoublyLinkedList 
{
    static Node head;
    
    class Node
    {
        int data;
        Node prev;
        Node next;

        Node(int val)
        {
            data= val;
            prev= null;
            next= null;
        }
    };

    void push(int val)
    {
        Node new_node= new Node(val);

        new_node.next= head;
        new_node.prev= null;
        
        if(head!=null)
            head.prev= new_node;

        head= new_node;
    }

    void insertAfter(int key_val, int new_val)
    {
        if(head==null)
        {
            System.out.println("DLL is empty.");
            return;
        }
        
        Node temp= head;

        while(temp!=null && temp.data!=key_val)
        {
            temp= temp.next;
        }

        if(temp==null)
        {
            System.out.println("Key value not found.");
            return;
        }

        Node new_node= new Node(new_val);
        
        new_node.next= temp.next;
        if(temp.next!=null) // In case, temp is the last node
            temp.next.prev= new_node;

        temp.next= new_node;
        new_node.prev= temp;       
    }

    void delete(int key)
    {
        Node prev_node=null, curr= head;
        if(head==null)
        {
            System.out.println("DLL is empty.");
            return;
        }

        while(curr!=null && curr.data!=key)
        {
            prev_node= curr;
            curr= curr.next;
        }

        // If node to be deleted is head and head is the only node
        if(curr==head && head.next==null)
        {
            head=null;
            return;
        }
        
        // If node to be deleted is head and head is not the only node
        if(curr==head)
        {
            head=curr.next;
            head.prev=null;
            return;
        }

        // In case, node to be deleted is the last node
        if(curr.next==null)
        {
            prev_node.next= null;
            return;
        }       

        // For, any node in between
        curr.next.prev= prev_node;
        prev_node.next= curr.next; 

    }

    void printDLL()
    {
        Node temp= head;
        while( temp!=null)
        {
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        DoublyLinkedList dll= new DoublyLinkedList();
        dll.push(1);
        dll.push(2);
        dll.push(3);
        dll.insertAfter(2,4);
        dll.printDLL();
        dll.delete(2);
        dll.printDLL();
    }    
}
