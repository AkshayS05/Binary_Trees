import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeLevelWise {
    private static BinaryTree<Integer> takeInput() {
        Scanner s= new Scanner(System.in);
        System.out.println("Please enter the root data");
        int rootData= s.nextInt();
//        check if the rootData is -1, then return null meaning user doesn't want to create any node
        if(rootData==-1){
            return null;
        }
//        create a node of that data
        BinaryTree<Integer>root= new BinaryTree<>(rootData);
//        add root in a queue
        Queue<BinaryTree<Integer>> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
//            pop out the front node and take its child nodes from the user
            BinaryTree<Integer> front= queue.poll();
//            check if root.left exists for this node
            System.out.println("Enter the left child for"+front.data);
            int rootLeft=s.nextInt();
            if(rootLeft!=-1){
                BinaryTree<Integer>leftChild= new BinaryTree<>(rootLeft);
//                add it in a queue
                queue.add(leftChild);
//                connect to the left of the parent node
                    front.left=leftChild;

            }
            //  similarly take root.right
            System.out.println("Enter the right child for"+front.data);
            int rootRight= s.nextInt();
            //  print the root data
            if(rootRight!=-1){
                BinaryTree<Integer>rightChild= new BinaryTree<>(rootRight);
                // add it in a queue
                queue.add(rightChild);
//                connect to the right of the parent node
                    front.right=rightChild;

            }
        }
        return root;
    }
//    private static void print(BinaryTree<Integer> root) {
//    }
public static void print(BinaryTree<Integer>root){
//        check if the root is null, then just return;
    if(root==null){
        return;
    }
Queue<BinaryTree<Integer>> queue= new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
//        pop out the first element and check for its children
        BinaryTree<Integer> front= queue.poll();
        System.out.print(front.data+"->");
//        check for its left element
        if(front.left!=null){
            queue.add(front.left);
            System.out.print("L:"+front.left.data+",");
        }else{
            System.out.print("L:"+-1+",");
        }
        // check for its right element
        if(front.right!=null){
            queue.add(front.right);
            System.out.print("R:"+front.right.data);
        }else{
            System.out.print("R:"+-1);
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
        BinaryTree<Integer> root= takeInput();
        print(root);
    }
}
