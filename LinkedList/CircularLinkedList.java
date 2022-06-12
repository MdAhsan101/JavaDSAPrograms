public class CircularLinkedList 
{

    static Node head;

    class Node
    {
        int data;
        Node next;

        Node(int val)
        {
            data= val;
            next= null;
        }
    };

    void push(int val)
    {
        Node new_node= new Node(val);
        
        if(head!=null)
        {
            new_node.next= head;
            
            Node temp_node= head;
            while(temp_node.next!=head)
            {
                temp_node= temp_node.next;
            }
            temp_node.next= new_node;
            
        }
        else
            new_node.next= new_node;
        
        head= new_node;
    }

    void delete(int val)
    {
        Node prev=null, curr= head;
        if(head==null)
        {
            System.out.println("CLL is empty.");
            return;
        }

        while(curr!=null && curr.data!=val)
        {
            if(curr.next==head)
            {
                System.out.println("No such value is found. Reached to the end of loop.");
                return;
            }
            prev= curr;
            curr= curr.next;
        }

        // If CLL comprises of single element and head is the one needed to be deleted
        if(curr==head && curr.next==head)
        {
            head=null;
        }
        // If CLL comprises of more than one elements and head is the one needed to be deleted
        else if(curr==head)
        {
            do
            {
                prev= curr;
                curr= curr.next;
            }while(curr!=head);

            prev.next=curr.next;
            head= prev.next;
        }
        else
        {
            prev.next=curr.next;
        }
    }

    int countNodes()
    {
        Node curr=head;
        if(head==null) 
            return 0;
        
        int count=1;
        while(curr.next!=head)
        {
            count++;
            curr= curr.next;
        }
        return count;
    }

    void printCLL()
    {
        Node temp_node= head;
        
        if(head!=null)
        {
            do
            {
                System.out.print(temp_node.data+" ");
                temp_node= temp_node.next;
            }while(temp_node!=head);

            System.out.println();
        }
        
    }

    public static void main(String args[])
    {
        CircularLinkedList cll= new CircularLinkedList();
        cll.push(1);
        cll.push(2);
        cll.push(3);
        cll.push(4);

        cll.printCLL();
        cll.delete(1);
        cll.printCLL();
        System.out.println("Total nodes in CLL is "+ cll.countNodes());
    }
    
}
