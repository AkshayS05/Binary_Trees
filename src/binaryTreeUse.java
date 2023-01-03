import java.util.Scanner;

public class binaryTreeUse {
    private static BinaryTree<Integer> takeInput(Scanner s) {
        System.out.println("Enter the root data");
            int rootData;
            rootData=s.nextInt();
//            check if the rootData is not -1
            if(rootData==-1){
                return null;
            }
//            if not null, then create a node
        BinaryTree<Integer> root=new BinaryTree<>(rootData);
//            if not null, now ask the user to provide left child as well as right child using recursion
        root.left=takeInput(s);
        root.right=takeInput(s);
        return root;
    }
    public static void print(BinaryTree<Integer>root){
//        check if the root is null, then just return;
        if(root==null){
            return;
        }
//        if not null then create a string to print it in an understandable fashion
            String toBeAdded= root.data+",";
//        check if the root.left exists
        if(root.left!=null){
//            add it in a string
                    toBeAdded+="L:"+ root.left.data+ ",";
        }
//        similarly check for right child
        if(root.right!=null){
            toBeAdded+="R:"+root.right.data;
        }
        System.out.println(toBeAdded);
//        call recursion for the rest of the steps
            print(root.left);
            print(root.right);
    }
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        BinaryTree<Integer> root= takeInput(s);
        print(root);
//        BinaryTree<Integer> root= new BinaryTree<>(1);
//        BinaryTree<Integer>node1= new BinaryTree<>(2);
//        BinaryTree<Integer> node2= new BinaryTree<>(3);
//        root.left=node1;
//        root.right=node2;
    }



}
