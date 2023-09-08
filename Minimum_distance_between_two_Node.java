
public class Minimum_distance_between_two_Node {
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
        System.out.println(get_distance(root , 4,5));
        
    }
    public static int get_distance(Node root , int n1 , int n2)
    {
        Node head = getLCA(root , n1 , n2);
        int n1_dist = get_distance_btw_lca_toNode(head , n1);
        int n2_dist = get_distance_btw_lca_toNode(head , n2);
        return n1_dist+n2_dist;

    }
    public static int get_distance_btw_lca_toNode(Node LCA , int n )
    {
        if(LCA == null)
        {
            return -1;
        }
        if(LCA.data == n)
        {
            return 0;
        }
        int right = get_distance_btw_lca_toNode(LCA.right , n);
        int left = get_distance_btw_lca_toNode(LCA.left , n);
        if(right == -1 && left == -1)
        {
            return -1;
        }
        else if(right == -1)
        {
            return left+1;
        }
        else 
        {
            return right+1;
        }
    }

    public static Node getLCA(Node root , int n1 , int n2)
    {
        if(root == null)
        {
            return null;
        }
        if(root.data == n1 || root.data == n2)
        {
            return root ;
        }

        Node left = getLCA(root.left , n1 , n2);
        Node right = getLCA(root.right , n1 , n2);

        if(left == null)
        {
            return right;
        }
        if(right == null)
        {
            return left ;
        }
        return root ;
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
