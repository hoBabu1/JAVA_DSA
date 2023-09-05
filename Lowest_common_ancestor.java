// to find lowest common ancestor of given tw0 node by usig path 
import java.util.*;
public class Lowest_common_ancestor {
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

        
        System.out.println( "Lowest common ancestor is "+getLCA(root,4 ,7));
    }
    public static int getLCA(Node root , int one , int two )
    {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        getPath(root , one, path1);
        getPath(root ,two , path2);

        int i = 0 ;
        for(;i<path1.size() && i<path2.size();i++)
        {
            if(path1.get(i)!=path2.get(i))
            {
                break;
            }
        }
        return path1.get(i-1);
    }
    // function to get path 
    public static boolean getPath(Node root  ,int n , ArrayList<Integer> path)
    {
        if(root == null)
        {
            return false;
        }
        path.add(root.data);
        if(n == root.data)
        {
            return true;
        }
        boolean left = getPath(root.left ,n, path) ;
        boolean right = getPath(root.right ,n, path);
        if(left || right )
        {  
            return true ;
        }
        else 
        {
            path.remove(path.size()-1);
            return false;
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
