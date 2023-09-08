public class build_a_BST {
    public static void main(String args[])
    {
        Node root = null;
        int arr[] = {5,1,3,4,2,7};
        for(int i = 0 ;i<arr.length; i++)
        {
            root = Build(root , arr[i] );
        }
        System.out.println(root.data);
        InOrderTraversal(root);
    }
    public static Node Build(Node root , int n  )
    {
        if(root == null)
        {
            return new Node(n);
        }
        // right
        if(root.data>n)
        {
            root.left = Build(root.left,n);
        }
        if(root.data<n)
        {
            root.right = Build(root.right,n);
        }
        return root;

    }
    public static void InOrderTraversal(Node root)
    {
        if(root == null )
        {
            return ;
        }
        InOrderTraversal(root.left);
         System.out.print(root.data+",");
         InOrderTraversal(root.right);
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
