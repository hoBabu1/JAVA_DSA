import java.util.*;
public class BinaryTree_Build_AllTraversal {
    public static void main(String args[])
    {
        int arr[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.build_BT(arr);
        // printing root data 
        System.out.println(root.data);
        // preorder Traversal
        System.out.print("PreOrderTraversal--> ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("InOrderTraversal--> ");
        InOrderTraversal(root);
        System.out.println();
        //levelOrderTraversal
        LevelOrder(root);



    }
    // creating a node which have three things --> data , right , left
    public static class Node{
        int data ;
        Node right ;
        Node left ;
        // constructor to initiallize all 
        public Node(int data )
        {
            this.data = data ;
            this.right = null;
            this.left = null;
        }
    }
    public static class BinaryTree{
        static int idx = -1;
        // function where node will be added
        public static Node build_BT(int arr[])
        {
            idx++;
            if(arr[idx]==-1)
            {
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.right = build_BT(arr);
            newNode.left = build_BT(arr);
            return newNode;
        }
    }
    // pre-order traversal 
    public static void preOrderTraversal(Node root)
    {
        if(root == null )
        {
            return ;
        }
        System.out.print(root.data+",");
        preOrderTraversal(root.right);
        preOrderTraversal(root.left);
    }
    // InorderTraversal 
    public static void InOrderTraversal(Node root)
    {
        if(root == null )
        {
            return ;
        }
        InOrderTraversal(root.right);
        System.out.print(root.data+",");
        InOrderTraversal(root.left);
    }
    // level order traversal via for loop using Queue 
    public static void LevelOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node node = q.remove();
            if(node == null){
                System.out.println();
                if(q.isEmpty())
                {
                    break;
                }
                else 
                {
                    q.add(null);
                }
            }
            else {
            System.out.print(node.data+" ");
            if(node.right != null)
            {
                q.add(node.right);
            }
            if(node.left != null)
            {
                q.add(node.left);
            }
            }
        }
    }
}
