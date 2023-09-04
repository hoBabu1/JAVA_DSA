public class subtree_of_another_tree {
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
        /*
              2
             / \
            4   5
         */
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        System.out.println(isSubTree(root , subroot));

    }
    public static class Node{
        int data ;
        Node right ;
        Node left ;
        public Node(int data)
        {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static boolean isSubTree(Node root , Node subroot)
    {
        if(root == null)
        {
            return false ;
        }
        if(root.data == subroot.data)
        {
            if(isidentical(root , subroot ))
            {
                return true;
            }
        }
        return isSubTree(root.right , subroot) ||  isSubTree(root.left , subroot);
    }
    public static boolean isidentical(Node root , Node subroot)
    {
        if(root == null && subroot == null)
        {
            return true ;
        }
        else if(root == null || subroot == null || root.data != subroot.data)
        {
            return false ;
        }
        if(!isidentical(root.right , subroot.right))
        {
            return false ;
        }
         if(!isidentical(root.left , subroot.left))
        {
            return false ;
        }
        return true ;
    }
    
}

