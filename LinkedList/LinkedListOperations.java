
public class LinkedListOperations
{
        static Node head;

        class Node
        {
            int data;
            Node next;

            Node(int d)
            {
                data= d;
                next= null;
            }
        }

        public void push(int val)
        {
            Node new_node= new Node(val);
            if(head==null)
                head= new_node;
            else
            {
                new_node.next=head.next;
                head= new_node;
            }
        }

        public void insertAfter(int prev_val, int new_val)
        {
            if(head==null)
            {
                System.out.println("List is empty");
                return;
            }

            Node temp_node= head;
            while(temp_node!=null)
            {
                if(temp_node.data==prev_val)
                    break;
                temp_node= temp_node.next;
            }

            if(temp_node==null)
            {                
                System.out.println("No node exist with "+prev_val+" value.");
                return;
            }

            Node new_node= new Node(new_val);
            new_node.next= temp_node.next;
            temp_node.next= new_node;
        }

        public void append(int val)
        {
            Node new_node= new Node(val);
            if(head==null)
                head= new_node;
            else
            {
                Node temp_node= head;
                while(temp_node.next!=null)
                {
                    temp_node= temp_node.next;
                }

                temp_node.next= new_node;
            }            
        }

        public void delete(int key)
        {
            Node temp_node= head, prev_node= null;
            if(head==null)
            {
                System.out.println("List is already empty.");
                return;
            }
            if(head.data==key)
            {
                head= head.next;
                return;
            }

            while(temp_node!=null && temp_node.data!=key)
            {
                prev_node= temp_node;
                temp_node= temp_node.next;
            }

            if(temp_node==null)
            {
                System.out.println("Key not found.");
                return;
            }

            prev_node.next=temp_node.next;
        }

        public void deleteEntireLinkedList()
        {
            head=null;
            return;
        }

        public int countNode(Node node)
        {
            if(node==null)
                return 0;
            return 1+countNode(node.next);
        }

        public void reverseLinkedList()
        {
            Node prev=null, curr=head, next= null;
            
            while(curr!=null)
            {
                next= curr.next;
                curr.next= prev;
                prev= curr;
                curr= next;
            }
            head= prev;
        }

        public void printList()
        {
                Node temp_node= head;
                while(temp_node!=null)
                {
                    System.out.print(temp_node.data+" ");
                    temp_node= temp_node.next;
                }    
                System.out.print("\n");                  
        }

        public static void main(String args[])
        {
            LinkedListOperations llist= new LinkedListOperations();
            llist.push(1);
            llist.append(3);
            llist.insertAfter(1,2);
            llist.printList();

            int total_nodes= llist.countNode(head);
            System.out.println("The number of nodes in linked list is "+total_nodes);

            llist.reverseLinkedList();
            System.out.print("Reversed LL: ");
            llist.printList();
            
            llist.delete(2);
            llist.delete(1);
            llist.printList();

        }
}