import java.util.*;

public class height_of_a_tree {
    public static void main(String args[])
    {
        // creating a tree 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // function calling to calculate height
        System.out.println( "Height of the tree is "+height(root));

    }
    public static int height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int rightheight = height(root.right);
        int leftheight = height(root.left);
        return Math.max(rightheight ,leftheight)+1;

    }
    public static class Node{
        int data ;
        Node left ;
        Node right ;
        public Node(int data )
        {
            this.data = data;
            this.right = null ;
            this.left = null;

        }
    }
    
}
