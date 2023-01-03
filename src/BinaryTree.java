//creating a generic type binary tree
public class BinaryTree <T>{
//    type of the data
   public T data;
   public BinaryTree<T>right;
   public BinaryTree<T> left;

   BinaryTree(T data){
       this.data=data;
   }

}
