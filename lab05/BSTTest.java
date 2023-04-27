package cosc201.lab05;

import java.util.ArrayList;
import java.util.Arrays;

public class BSTTest {

    public static void main(String[] args) {
        BST tree = new BST();

        // testing the isEmpty() method, should retunr true
        System.out.println("Is the tree empty? " + tree.isEmpty()); // Should print true
        
        // testing the  add() and contains()
        tree.add("ant");
        tree.add("bat");
        tree.add("mat");
        tree.add("cat");
        tree.add("dog");
        tree.add("elephant");
        
        System.out.println("Does the tree contain 'ant'? " + tree.contains("ant")); // Should print true
        System.out.println("Does the tree contain 'bat'? " + tree.contains("bat")); // Should print true
        System.out.println("Does the tree contain 'cat'? " + tree.contains("cat")); // Should print true
        System.out.println("Does the tree contain 'dog'? " + tree.contains("dog")); // Should print true
        System.out.println("Does the tree contain 'fox'? " + tree.contains("fox")); // Should print false
        
        System.out.println(tree.toString());
        // testing the height() and size() metohds 
         System.out.println("Height of 'ant': " + tree.height("ant"));
        System.out.println("Height of 'bat': " + tree.height("bat"));
        System.out.println("Height of 'cat': " + tree.height("cat"));
        System.out.println("Height of 'mat': " + tree.height("mat"));
        System.out.println("Height of 'dog': " + tree.height("dog"));
        System.out.println("Height of 'elephant': " + tree.height("elephant"));
        System.out.println("size of 'ant': " + tree.size("ant"));
        System.out.println("Size of 'cat': " + tree.size("cat"));
        System.out.println("Size of 'mat': " + tree.size("mat"));
        System.out.println("Size of 'elephant': " + tree.size("elephant"));
        System.out.println("Size of 'dog': " + tree.size("dog"));
        // Testing the next()
        System.out.println("Next after 'banana': " + tree.next("bat")); // should return cat 
        
        
        // // Test delete()
        tree.delete("mat");
        System.out.println("Does the tree contain 'mat'? " + tree.contains("mat")); // Should print false
        System.out.println(tree.toString());
        
        // Test traversals()
        // removed dog()
        System.out.println("Preorder traversal: " + tree.preorder());
        System.out.println("Inorder traversal: " + tree.inorder()); 
        System.out.println("Postorder traversal: " + tree.postorder());
        System.out.println("Levelorder traversal: " + tree.levelorder());

        //Test makeBalanced()
        String[] arr = {"ant", "bat", "cat", "dog", "mat", "elephant", "kiwi", "leopard", "monkey", "orangutang"};
        BST balancedTree = BST.makeBalanced(arr);
        System.out.println("Balanced tree inorder traversal: " + balancedTree.toString());
        balancedTree.toString();

    }
}
