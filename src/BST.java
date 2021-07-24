//import java.util.Stack;
//
//public class BST {
//    static Node root;
//
//    public static void add(Node node, int data){
//        if(node==null){
//            Node root = root.set;
//        }
//        else if(root.data>data){
//            add(node.left,data);
//        }
//        else if(node.data<data)
//            add(node.right,data);
//    }
//
//    public static void InOrder(Node root) {
//        Stack<Node> s = new Stack<>();
//        Node cur=root;
//        while(cur != null || !s.isEmpty()){
//            while(cur != null) {
//                s.push(cur);
//                cur = cur.getLeft();
//            }
//
//            cur = s.pop();
//            System.out.print(cur.getData() + " ");
//            cur = cur.getRight();
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] a=  {10,3,15,14,8,5,7,9};
//        for(int i : a){
//            add(root, i);
//        }
//        InOrder(root);
//    }
//}
