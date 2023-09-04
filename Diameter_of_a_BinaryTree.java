public class Diameter_of_a_BinaryTree {
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Info answer = Diameter(root);
        System.out.println("diameter is "+answer.dia);

    }
    public static class Info
    {
        int dia ;
        int height ;
        public Info(int dia, int height )
        {
            this.dia = dia ;
            this.height = height ;
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
    public static Info Diameter(Node root)
    {
        if(root == null)
        {
            return new Info(0,0);
        }
        Info right = Diameter(root.right);
        Info left = Diameter(root.left);
        // calculating diameter 
        int RightHeight = right.height;
        int LeftHeight = left.height;
        int diameter = Math.max(RightHeight+LeftHeight+1 , Math.max(RightHeight,LeftHeight));
        // calculating final diameter 
        int FinalDiameter = Math.max(diameter , Math.max(right.dia, left.dia));
        int FinalHeight = Math.max(RightHeight,LeftHeight)+1;
        return new Info(FinalDiameter,FinalHeight);
        
    }
    
}
