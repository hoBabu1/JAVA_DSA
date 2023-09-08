
public class Lowest_common_ancestor_optimized {
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
        System.out.println(getLCA(root , 6 ,7).data);
        
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
