import java.util.Scanner;

/**
 * You are working in an MNC, which manages the Transactions, where only BST is used as a
 * Data Structure. The company stores all the data of transactions in BST such that the tree is
 * always a complete BST.
 * A new business requirement has arrived where the BST should not contain any left node.
 * You are required to modify the existing BST and display the node values present in ascending
 * order.
 * Hint: ( Convert the Binary Search Tree into a Skewed Tree).
 */
class Node {
   int val;
   Node left, right;

   // Helper function that allocates a new node
   // with the given data and NULL left and right
   // pointers.
   Node(int item) {
      val = item;
      left = right = null;
   }
}

public class Ques_2 {
   public static Node node;
   static Node prevNode = null;
   static Node headNode = null;

   // Function to to flatten the binary
   // search tree into a skewed tree in
   // increasing / decreasing order
   static void convertBSTToRightSkewedTree(Node root, int order) {

      // Base Case
      if (root == null) {
         return;
      }

      // Condition to check the order
      // in which the skewed tree to
      // maintained
      if (order > 0) {
         convertBSTToRightSkewedTree(root.right, order);
      } else {
         convertBSTToRightSkewedTree(root.left, order);
      }
      Node rightNode = root.right;
      Node leftNode = root.left;

      // Condition to check if the root Node
      // of the skewed tree is not defined
      if (headNode == null) {
         headNode = root;
         root.left = null;
         prevNode = root;
      } else {
         prevNode.right = root;
         root.left = null;
         prevNode = root;
      }

      // Similarly recurse for the left / right
      // subtree on the basis of the order required
      if (order > 0) {
         convertBSTToRightSkewedTree(leftNode, order);
      } else {
         convertBSTToRightSkewedTree(rightNode, order);
      }
   }

   // Function to traverse the right
   // skewed tree using recursion
   static void traverseAndPrintRightSkewed(Node root) {
      if (root == null) {
         return;
      }
      System.out.print(root.val + " ");
      traverseAndPrintRightSkewed(root.right);
   }

   // Driver Code
   public static void main(String[] args) {

      Ques_2 tree = new Ques_2();
      tree.node = new Node(50);
      tree.node.left = new Node(30);
      tree.node.right = new Node(60);
      tree.node.left.left = new Node(10);
      tree.node.right.left= new Node(55);

      Scanner sc = new Scanner(System.in);
      System.out.println("For skewed tree , enter 0 for increasing order and 1 for decreasing order");
      int order = sc.nextInt(); // 0 means increasing order , 1 for decreasing order
      convertBSTToRightSkewedTree(node, order);
      traverseAndPrintRightSkewed(headNode);
   }
}

