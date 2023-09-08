
public class kth_ancestor_node {
     public static void main(String args[])
    {
          /*
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(getKthAncestor(root , 5 ,1));
        
    }
    public static int getKthAncestor(Node root , int n1 , int k )
    {
        if(root == null)
        {
            return -1 ;
        }
        if(root.data == n1)
        {
            return 0;
        }
        int right = getKthAncestor(root.right , n1 , k);
        int left = getKthAncestor(root.left , n1 , k);
        if(left == -1 && right == -1)
        {
            return -1;
        }
        else 
        {
            int valid = Math.max(right, left);
            if(k == valid+1)
            {
               return root.data;
            }
            else 
            {
                return valid+1;
            }
        }


    }
    public static class Node 
    {
        int data ;
        Node right ;
        Node left ;
        public Node(int data )
        {
            this.data = data ;
            this.right = null;
            this.left = null;
        }
    }
    
}
