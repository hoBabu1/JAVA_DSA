public class linkedlist_delete_At_index {
    public static void main(String args[])
    {
        linkedlist ll = new linkedlist();
        ll.addAtHead(21);
        ll.addAtHead(20);
        ll.addAtTail(38);
        ll.addAtTail(57);
        ll.addAtTail(59);
        ll.addAtTail(58);
        ll.Print();
        ll.delete(4);
        ll.Print();

    }
    
    // creating node class 
    public static class Node
    {
        int data ;
        Node next;
        public Node( int data )
        {
            this.data = data;
            this.next = next; 
        }
    }
    public static Node head ;
    public static Node tail;
    
    public static  class linkedlist
    {
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        if(head == null)
        {
            head = tail =  newNode;
            return;
        }
        else {
            newNode.next = head ;
            head = newNode;
        }  
    }
    public static void addAtTail(int val)
    {
        Node newNode= new Node(val);
        if(head == null )
        {
            head = tail = newNode;
            return;
        }
        else 
        {
            tail.next = newNode;
            tail = newNode;

        }

    }
    public static void Print( )
    {
        Node temp = head ;
        while(temp != null)
        {
            System.out.print(temp.data+" -->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static int get(int index) {
        Node curr = head;
        if(head == null)
        {
            return -1;
        }
        int count = 0 ;
        while(curr != null)
        {
            if(count == index)
            {
                return curr.data;
            }
            curr = curr.next;
            count++;
        }
        return -1;
    }
    public static void delete(int idx )
    {
        // calculating size
        int size = 0 ;
        Node temp = head ;
        while(temp != null)
        {
            temp = temp.next;
            size++;
        }
        // invalid index 
        if(idx >= size)
        {
            return;
        }
        // if linked list is empty 
        if(size == 0)
        {
            return;
        }
        // if there is only head 
        else if(idx == 0 && size == 1 )
        {
           head = tail = null;
        }

        // for last index 
        else if(size-1 == idx)
        {
            Node prev = head ;
           for(int i = 0 ; i<size-2 ; i++)
           {
            prev = prev.next;
           }
           prev.next = null;
           tail = prev;
        }
        else if(idx == 0)
        {
            head = head.next;
        }
        else 
        {
            Node temp2 = head ;
            for(int i = 1 ; i<idx ;i++)
            {
                temp2 = temp2.next;
            }
            temp2.next = temp2.next.next;
        }
 
    } 
}
}
