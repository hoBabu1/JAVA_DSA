public class Word_Break_problem {
    public static  class Node 
    {
        Node children[] = new Node[26];
        boolean end_of_word ;
        Node()
        {
            for(int i = 0 ; i<26 ; i++)
            {
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void main(String args[])
    {
        String words[] = {"i" , "like", "sam" ,"samsung" , "mobile" , "ice"};
        String key = "samsung";
        for(int i = 0 ; i<words.length ;i++)
        {
            insert(words[i]);
        }
        System.out.println("output-->"+Word_break_problem(key));
    }
    public static boolean Word_break_problem(String key)
    {
        if(key.length() == 0)
        {
            return true;
        }
        for(int i =1;i<=key.length();i++)
        {
            if(search(key.substring(0,i)) && Word_break_problem(key.substring(i) ))
            {
                return true ;
            }
        }
        return false ;
    }
    public static void insert(String str)
    {
        Node curr = root ;
        for(int i = 0 ; i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(curr.children[ch-'a']==null)
            {
                curr.children[ch-'a']=new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.end_of_word= true;
    }
    public static boolean search(String str)
    {
        Node curr = root ;
        for(int i = 0 ;i<str.length() ; i++)
        {
            char ch = str.charAt(i);
            if(curr.children[ch-'a'] == null)
            {
                return false;
            }
            curr = curr.children[ch-'a'];

        }
        if(curr.end_of_word== true)
        {
            return true ;
        }
        else 
        {
            return false ;
        }
    }
    
}
