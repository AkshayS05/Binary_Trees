import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountNodes {
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
    private static int countNodes(BinaryTree<Integer>root){
        //if it is an empty node return 0
        if(root==null){
            return 0;
        }
//        if root is there, it must has one node
        int ans=1;
//        now we will check for root's left and also for root's right
        if(root.left!=null){
            ans+=countNodes(root.left);
        }
        if(root.right!=null){
            ans+=countNodes(root.right);
        }
        return ans;
    }
    public static void main(String[] args) {
        BinaryTree<Integer>root= takeInput();
        System.out.println(countNodes(root));
    }
}
